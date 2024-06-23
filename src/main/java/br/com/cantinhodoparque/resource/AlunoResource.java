package br.com.cantinhodoparque.resource;

import java.util.List;

import br.com.cantinhodoparque.dto.AlunoDto;
import br.com.cantinhodoparque.model.Turma;
import br.com.cantinhodoparque.service.AlunoService;
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

@Path("/aluno")
public class AlunoResource {
	
	@Inject
	AlunoService alunoService;
	
	@Path("/cadastrar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void cadastrarAluno(@QueryParam("nome") String nome, @QueryParam("turma") String turma) {
		alunoService.cadastrar(nome, turma);
	}
	
	@Path("/excluir")
	@DELETE
	@Transactional
	public void excluirAluno(@QueryParam("id") Long id) {
		alunoService.excluir(id);
	}
	
	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AlunoDto> listarAluno() {
		return alunoService.listar();
	}
	
	@Path("/atualizar")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void atualizarAluno(@QueryParam("id") Long id, @QueryParam("nome") String nome, @QueryParam("turma") Turma turma) {
		alunoService.atuarlizar(id, nome, turma);
	}

}
