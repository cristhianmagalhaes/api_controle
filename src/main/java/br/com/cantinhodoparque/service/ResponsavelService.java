package br.com.cantinhodoparque.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cantinhodoparque.dao.ResponsavelDao;
import br.com.cantinhodoparque.dto.ResponsavelDto;
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

	public void excluirResponsavel(Long id) {
		responsavelDao.excluirResponsaveis(id);
	}

	public List<ResponsavelDto> listar() {
		return responsavelDao.listarResponsaveis().stream().map(tuple -> {
			ResponsavelDto responsavel = new ResponsavelDto();
			responsavel.setId((Long) tuple.get("id"));
			responsavel.setNome((String) tuple.get("nome"));
			responsavel.setEmail((String) tuple.get("email"));
			responsavel.setTelefone((String) tuple.get("telefone"));
			responsavel.setParentesco((String) tuple.get("parentesco"));
			responsavel.setLogradouro((String) tuple.get("logradouro"));
			responsavel.setBairro((String) tuple.get("bairro"));
			responsavel.setCep((String) tuple.get("cep"));
			responsavel.setCidade((String) tuple.get("cidade"));
			responsavel.setUf((String) tuple.get("uf"));
			responsavel.setNumero((String) tuple.get("numero"));
			responsavel.setComplemento((String) tuple.get("complemento"));
			responsavel.setAtivo((Boolean) tuple.get("ativo"));
			responsavel.setAlunoNome((String) tuple.get("nomeAluno"));
			return responsavel;
		}).collect(Collectors.toList());
	}

	public void atualizar(Long id, String nome, String email, String telefone, String parentesco, String logradouro,
			String bairro, String cep, String cidade, String uf, String numero, String complemento, boolean ativo,
			int alunoId) {
		
		responsavelDao.atualizarResponsavel(id, nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, alunoId);
		
	}

}
