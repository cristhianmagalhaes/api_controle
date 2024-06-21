package com.cantinhodoparque.api_controle.responsavel;

import com.cantinhodoparque.api_controle.endereco.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Table(name = "responsaveis")
@Entity(name = "Responsavel")
@EqualsAndHashCode(of = "id")
public class Responsavel {

	public Responsavel(DadosCadastroResponsavel dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.parentesco = dados.parentesco();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = true;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	private Parentesco parentesco;
	
	@Embedded
	private Endereco endereco;
	
	private boolean ativo;
	
	private Long aluno_id;

	public void atualizarInformacoes(DadosAtualizacaoResponsavel dados) {
		if(dados.nome()!=null) {
			this.nome = dados.nome();
		}
		if(dados.telefone()!=null) {
			this.telefone = dados.telefone();
		}
		if(dados.email()!=null) {
			this.email = dados.email();
		}
		if(dados.aluno_id()!=null) {
			this.aluno_id = dados.aluno_id();
		}
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(Long aluno_id) {
		this.aluno_id = aluno_id;
	}

	public Long getId() {
		return id;
	}

	public void excluir() {
		this.ativo = false;
		
	}

}
