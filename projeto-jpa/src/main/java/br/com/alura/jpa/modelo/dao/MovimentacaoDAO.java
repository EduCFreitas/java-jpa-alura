package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDAO {

	public List<MediaComData> getMediaDiariaDasMovimentacoes(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
		
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
		
	}
	
	public Double getMediaDasMovimentacoes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor) from Movimentacao m";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double mediaDasMovimentacoes = query.getSingleResult();
		
		return mediaDasMovimentacoes;
	}
}
