package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Pagamento;

public class PagamentoDAO {
	private DataSource dataSource;

	public PagamentoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertPagamento(Pagamento pagamento) throws SQLException {
		String query = "INSERT INTO Pagamento (ID_pagamento, data_pag, importo_pag,num_carta, data_scadenza, "
				+ "titolare_conto,id_ordine) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, pagamento.getIdPagamento());
			statement.setDate(2, pagamento.getDataPagamento());
			statement.setBigDecimal(3, pagamento.getImportoPagamento());
			statement.setString(4, pagamento.getNumeroCarta());
			statement.setDate(5, pagamento.getDataScadenza());
			statement.setString(6, pagamento.getTitolareConto());
			statement.setInt(7, pagamento.getIdOrdine());
			statement.executeUpdate();
		}
	}

}
