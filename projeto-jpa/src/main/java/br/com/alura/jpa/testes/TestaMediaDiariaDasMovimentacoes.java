package br.com.alura.jpa.testes;

import java.util.List;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TestaMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDAO().getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A m�dia das movimenta��es do dia " + resultado.getDia() + "/" + resultado.getMes() + " �: " + resultado.getValor());
		}
		
	}

}
