package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Fattura;

public class FatturaDAO {
	private DataSource dataSource;

	public FatturaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertFattura(Fattura fattura) throws SQLException {
		String query = "INSERT INTO Fattura (ID_fattura, data_fattura, anno, iva_fattura, ID_P) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, fattura.getIdFattura());
			statement.setDate(2, fattura.getDataFattura());
			statement.setInt(3, fattura.getAnno());
			statement.setBigDecimal(4, fattura.getIvaFattura());
			statement.setInt(5, fattura.getIdPagamento());
			statement.executeUpdate();
		}
	}

	// Altre operazioni CRUD per Fattura
}
