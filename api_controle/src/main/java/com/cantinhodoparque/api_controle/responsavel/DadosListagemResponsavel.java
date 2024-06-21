package com.cantinhodoparque.api_controle.responsavel;

public class DadosListagemResponsavel {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Parentesco parentesco;

	public DadosListagemResponsavel(Responsavel responsavel) {
		this.id = responsavel.getId();
		this.nome = responsavel.getNome();
		this.email = responsavel.getEmail();
		this.telefone = responsavel.getTelefone();
		this.parentesco = responsavel.getParentesco();
	}

}
