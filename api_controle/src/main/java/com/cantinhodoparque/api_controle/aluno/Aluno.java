package com.cantinhodoparque.api_controle.aluno;

import java.util.List;

import com.cantinhodoparque.api_controle.responsavel.Responsavel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "alunos")
@Entity(name = "Aluno")
public class Aluno {
	
	public Aluno(DadosCadastroAluno dados) {
		this.nome = dados.nome();
		this.turma = dados.turma();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Turma turma;
	
	@OneToMany
	@JoinColumn(name = "aluno_id")
	private List<Responsavel> responsavel;

}
