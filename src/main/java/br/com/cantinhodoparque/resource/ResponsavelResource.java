package br.com.cantinhodoparque.resource;

import java.util.List;

import br.com.cantinhodoparque.dto.ResponsavelDto;
import br.com.cantinhodoparque.model.Turma;
import br.com.cantinhodoparque.service.ResponsavelService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

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
	
	@Path("/excluir")
	@DELETE
	@Transactional
	public void excluir(@QueryParam("id") Long id) {
		responsavelService.excluirResponsavel(id);
	}
	
	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResponsavelDto> listar(){
		return responsavelService.listar();
	}
	
	@Path("/atualizar")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void atualizarAluno(@QueryParam("id") Long id, @QueryParam("nome") String nome, @QueryParam("email") String email, @QueryParam("telefone") String telefone, @QueryParam("parentesco") String parentesco,
							@QueryParam("logradouro") String logradouro, @QueryParam("bairro") String bairro, @QueryParam("cep") String cep, @QueryParam("cidade") String cidade,
							@QueryParam("uf") String uf, @QueryParam("numero") String numero, @QueryParam("complemento") String complemento, @QueryParam("ativo") boolean ativo,
							@QueryParam("aluno_id") int alunoId) {
		responsavelService.atualizar(id, nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, alunoId);
	}

}
