package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDAO {
	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes(){
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentacoes", MediaComData.class);
		
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {
		TypedQuery<BigDecimal> query = em.createNamedQuery("somaMovimentacoes", BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		return somaDasMovimentacoes;
	}
	
	public Double getMediaDasMovimentacoes() {
		TypedQuery<Double> query = em.createNamedQuery("mediaMovimentacoes", Double.class);
		Double mediaDasMovimentacoes = query.getSingleResult();
		
		return mediaDasMovimentacoes;
	}
}
