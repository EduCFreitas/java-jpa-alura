package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //<persistence-unit name="contas"> em persistence.xml
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}

}
