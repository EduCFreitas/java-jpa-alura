package br.com.alura.jpa.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jpa.modelo.Conta;

public class TesteSQL {

	public static void main(String[] args) throws SQLException {
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost/alura_jpa?serverTimezone=UTC", "root", "root");
		String sql = "SELECT * FROM CONTA";
		
		PreparedStatement ps = cnn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Conta> contas = new ArrayList<Conta>();
		while(rs.next()) {
			Conta conta = new Conta();
			conta.setAgencia(rs.getInt("agencia"));
			conta.setNumero(rs.getInt("numero"));
			conta.setSaldo(rs.getDouble("saldo"));
			
			contas.add(conta);
		}
		
		for(Conta conta : contas) {
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
			System.out.println("=================================");
		}

	}

}
