package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		MovimentacaoDAO dao = new MovimentacaoDAO();
		
		System.out.println("A soma das movimenta��es �: " + dao.getSomaDasMovimentacoes());
		System.out.println("A m�dia das movimenta��es �: " + dao.getMediaDasMovimentacoes());

	}

}
