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
        String query = "INSERT INTO Pagamento (ID_pagamento, data_pag, importo_pag, tipo_pag, num_carta, data_scadenza, " +
                       "cvc, titolare_conto, iban, bic, email_payp, pwd_payp, id_ordine) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, pagamento.getIdPagamento());
            statement.setDate(2, pagamento.getDataPagamento());
            statement.setBigDecimal(3, pagamento.getImportoPagamento());
            statement.setString(4, pagamento.getTipoPagamento());
            statement.setString(5, pagamento.getNumeroCarta());
            statement.setDate(6, pagamento.getDataScadenza());
            statement.setString(7, pagamento.getCvc());
            statement.setString(8, pagamento.getTitolareConto());
            statement.setString(9, pagamento.getIban());
            statement.setString(10, pagamento.getBic());
            statement.setString(11, pagamento.getEmailPayPal());
            statement.setString(12, pagamento.getPasswordPayPal());
            statement.setInt(13, pagamento.getIdOrdine());
            statement.executeUpdate();
        }
    }

    // Altre operazioni CRUD per Pagamento
}

