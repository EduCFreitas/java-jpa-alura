package br.com.alura.jpa.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDAO {
	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(dia != null) {
			//day(m.data)
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}
		if(mes != null) {
			//month(m.data)
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}
		if(ano != null) {
			//year(m.data)
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}
		
		query.where((Predicate[]) predicates.toArray(new Predicate[0])); 
		
		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);
		
		return typedQuery.getResultList();
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
