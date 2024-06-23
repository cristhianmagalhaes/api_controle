package br.com.cantinhodoparque.dao;

import io.smallrye.mutiny.tuples.Tuple;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@RequestScoped
public class ResponsavelDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	private static final String CADASTRAR_RESPONSAVEL = "INSERT INTO cantinho_do_parque.responsaveis\r\n"
			+ "(nome, email, telefone, parentesco, logradouro, bairro, cep, cidade, uf, numero, complemento, ativo, aluno_id)\r\n"
			+ "VALUES(:parametro1, :parametro2, :parametro3, :parametro4, :parametro5, :parametro6, :parametro7, :parametro8, :parametro9, :parametro10, :parametro11, :parametro12, :parametro13);\r\n"
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

}
