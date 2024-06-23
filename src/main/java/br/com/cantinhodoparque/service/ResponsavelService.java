package br.com.cantinhodoparque.service;

import br.com.cantinhodoparque.dao.ResponsavelDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ResponsavelService {
	
	@Inject
	ResponsavelDao responsavelDao;

	public void cadastrarResponsavel(String nome, String email, String telefone, String parentesco, String logradouro, String bairro, String cep, String cidade,
									String uf, String numero, String complemento, boolean ativo, int alunoId) {
		responsavelDao.cadastrarResponsaveis(nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, alunoId);
	}

}
