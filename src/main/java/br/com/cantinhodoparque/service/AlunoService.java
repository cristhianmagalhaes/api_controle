package br.com.cantinhodoparque.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cantinhodoparque.dao.AlunoDao;
import br.com.cantinhodoparque.dto.AlunoDto;
import br.com.cantinhodoparque.model.Turma;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AlunoService {

	@Inject
	AlunoDao alunoDao;
	
	public void cadastrar(String nome, String turma) {
		alunoDao.cadastrarAlunos(nome, turma);		
	}
	
	public void excluir(Long id) {
		alunoDao.excluirAlunos(id);
	}

	public List<AlunoDto> listar() {
		return alunoDao.listarAlunos().stream().map(tuple -> {
			AlunoDto alunoDto = new AlunoDto();
			alunoDto.setId((Long) tuple.get("id"));
			alunoDto.setNome((String) tuple.get("nome"));
			alunoDto.setTurma((String) tuple.get("turma"));
			return alunoDto;
		}).collect(Collectors.toList());
	}

	public void atuarlizar(Long id, String nome, Turma turma) {
		alunoDao.atualizarAlunos(id, nome, turma);
	}

}
