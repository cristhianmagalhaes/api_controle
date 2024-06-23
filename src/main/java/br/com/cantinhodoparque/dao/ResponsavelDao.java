package br.com.cantinhodoparque.dao;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;

@RequestScoped
public class ResponsavelDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String CADASTRAR_RESPONSAVEL = "INSERT INTO cantinho_do_parque.responsaveis\r\n"
			+ "(nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, aluno_id)\r\n"
			+ "VALUES(:parametro1, :parametro2, :parametro3, :parametro4, :parametro5, :parametro6, :parametro7, :parametro8, :parametro9, :parametro10, :parametro11, :parametro12, :parametro13);\r\n"
			+ "";
	
	private static final String EXCLUIR_RESPONSAVEIS = "DELETE FROM cantinho_do_parque.responsaveis WHERE id = :parametro1";
	
	private static final String LISTAR_RESPONSAVEIS = "SELECT resp.id, resp.nome, resp.email, resp.telefone, resp.parentesco, resp.logradouro, resp.bairro, resp.cep, resp.cidade, resp.uf, resp.numero, resp.complemento, resp.ativo, aluno.nome as nomeAluno  FROM cantinho_do_parque.responsaveis resp inner join cantinho_do_parque.alunos aluno on resp.aluno_id = aluno.id";
	
	private static final String ATUALIZAR_RESPONSAVEIS = "UPDATE cantinho_do_parque.responsaveis\r\n"
			+ "SET nome=:parametro1, email=:parametro2, telefone=:parametro3, parentesco=:parametro4, logradouro=:parametro5, bairro=:parametro6, cep=:parametro7, cidade=:parametro8, uf=:parametro9, numero=:parametro10, complemento=:parametro11, ativo=:parametro12, aluno_id=:parametro13\r\n"
			+ "WHERE id=:parametro14;\r\n"
			+ "";
	
	public void cadastrarResponsaveis(String nome, String email, String telefone, String parentesco, String logradouro, String bairro, String cep, String cidade,
			String uf, String numero, String complemento, boolean ativo, int alunoId) {
		Query query = entityManager.createNativeQuery(CADASTRAR_RESPONSAVEL, Tuple.class);
		query.setParameter("parametro1", nome);
		query.setParameter("parametro2", email);
		query.setParameter("parametro3", telefone);
		query.setParameter("parametro4", parentesco);
		query.setParameter("parametro5", logradouro);
		query.setParameter("parametro6", bairro);
		query.setParameter("parametro7", cep);
		query.setParameter("parametro8", cidade);
		query.setParameter("parametro9", uf);
		query.setParameter("parametro10", numero);
		query.setParameter("parametro11", complemento);
		query.setParameter("parametro12", ativo);
		query.setParameter("parametro13", alunoId);
		query.executeUpdate();
	}

	public void excluirResponsaveis(Long id) {
		Query query = entityManager.createNativeQuery(EXCLUIR_RESPONSAVEIS, Tuple.class);
		query.setParameter("parametro1", id);
		query.executeUpdate();
	}
	
	public List<Tuple> listarResponsaveis(){
		Query query = entityManager.createNativeQuery(LISTAR_RESPONSAVEIS, Tuple.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public void atualizarResponsavel(Long id, String nome, String email, String telefone, String parentesco,
			String logradouro, String bairro, String cep, String cidade, String uf, String numero, String complemento,
			boolean ativo, int alunoId) {
		Query query = entityManager.createNativeQuery(ATUALIZAR_RESPONSAVEIS, Tuple.class);
		query.setParameter("parametro1", nome);
		query.setParameter("parametro2", email);
		query.setParameter("parametro3", telefone);
		query.setParameter("parametro4", parentesco);
		query.setParameter("parametro5", logradouro);
		query.setParameter("parametro6", bairro);
		query.setParameter("parametro7", cep);
		query.setParameter("parametro8", cidade);
		query.setParameter("parametro9", uf);
		query.setParameter("parametro10", numero);
		query.setParameter("parametro11", complemento);
		query.setParameter("parametro12", ativo);
		query.setParameter("parametro13", alunoId);
		query.setParameter("parametro14", id);
		query.executeUpdate();
	}

}
