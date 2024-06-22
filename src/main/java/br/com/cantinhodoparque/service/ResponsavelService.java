package br.com.cantinhodoparque.service;

import br.com.cantinhodoparque.dao.ResponsavelDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ResponsavelService {
	
	@Inject
	ResponsavelDao responsavelDao;
	
	private static final String CADASTRAR_RESPONSAVEL = "INSERT INTO cantinho_do_parque.responsaveis\r\n"
			+ "(nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, aluno_id)\r\n"
			+ "VALUES(:parametro1, :parametro2, :parametro3, :parametro4, :parametro5, :parametro6, :parametro7, :parametro8, :parametro9, :parametro10, :parametro11, :parametro12, :parametro13);\r\n"
			+ "";

	public void cadastrarResponsavel() {
		
	}

}
