package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes"; //join fetch evita n+1
		//distinct faz com que recebamos apenas resultados distintos, evitando duplicidade na esquerda (left)
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Ag�ncia: " + conta.getAgencia());
			System.out.println("N�mero: " + conta.getNumero());
			System.out.println("Movimenta��es: " + conta.getMovimentacoes());
			System.out.println("=============================");
		}

	}

}
