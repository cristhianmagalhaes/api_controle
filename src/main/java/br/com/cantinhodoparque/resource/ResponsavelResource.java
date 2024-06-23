package br.com.cantinhodoparque.resource;

import br.com.cantinhodoparque.service.ResponsavelService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/responsavel")
public class ResponsavelResource {
	
	@Inject
	ResponsavelService responsavelService;
	
	@Path("/cadastrar")
	@POST
	@Transactional
	public void cadastrar(@QueryParam("nome") String nome, @QueryParam("email") String email, @QueryParam("telefone") String telefone, @QueryParam("parentesco") String parentesco,
							@QueryParam("logradouro") String logradouro, @QueryParam("bairro") String bairro, @QueryParam("cep") String cep, @QueryParam("cidade") String cidade,
							@QueryParam("uf") String uf, @QueryParam("numero") String numero, @QueryParam("complemento") String complemento, @QueryParam("ativo") boolean ativo,
							@QueryParam("aluno_id") int alunoId) {
		responsavelService.cadastrarResponsavel(nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, alunoId);
	}

}
