package br.com.db1.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CidadeTest {



	@Test
	public void selectHqlTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db1start");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("Select c from Cidade c");
		List<Cidade> cidades = query.getResultList();

		for(Cidade cidade:cidades) {
			System.out.println(cidade.getNome());
			System.out.println(cidade.getId());
			System.out.println(cidade.getUf().getNome());
		}
		factory.close();

	}
	
}