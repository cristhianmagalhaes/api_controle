
package br.com.cantinhodoparque.dao;


import java.util.List;

import br.com.cantinhodoparque.model.Turma;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

@RequestScoped
public class AlunoDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String CADASTRAR_ALUNOS = "INSERT INTO cantinho_do_parque.alunos\r\n"
			+ "(nome, turma)\r\n"
			+ "VALUES(:parametro1, :parametro2);\r\n"
			+ "";
	
	private static final String EXCLUIR_ALUNOS = "DELETE FROM cantinho_do_parque.alunos WHERE id = :parametro1";
	
	private static final String LISTAR_ALUNOS = "SELECT c.id, c.nome, c.turma FROM cantinho_do_parque.alunos c";
	
	private static final String ATUALIZAR_ALUNOS = "UPDATE cantinho_do_parque.alunos\r\n"
			+ "SET nome=:parametro1, turma=:parametro2\r\n"
			+ "WHERE id=:parametro3;\r\n"
			+ "";
	
	public void cadastrarAlunos(String nome, String turma){	
		Query query = entityManager.createNativeQuery(CADASTRAR_ALUNOS, Tuple.class);
		query.setParameter("parametro1", nome);
		query.setParameter("parametro2", turma);
		query.executeUpdate();
	}
	
	public void excluirAlunos(Long id) {
		Query query = entityManager.createNativeQuery(EXCLUIR_ALUNOS, Tuple.class);
		query.setParameter("parametro1", id);
		query.executeUpdate();
	}
	
	public List<Tuple> listarAlunos() {
		Query query = entityManager.createNativeQuery(LISTAR_ALUNOS, Tuple.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public void atualizarAlunos(Long id, String nome, Turma turma) {
		Query query = entityManager.createNativeQuery(ATUALIZAR_ALUNOS, Tuple.class);
		query.setParameter("parametro1", nome);
		query.setParameter("parametro2", turma);
		query.setParameter("parametro3", id);
		query.executeUpdate();
	}

}
