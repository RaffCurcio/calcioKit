package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Spedizione;

public class SpedizioneDAO {
	private DataSource dataSource;

	public SpedizioneDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertSpedizione(Spedizione spedizione) throws SQLException {
		String query = "INSERT INTO Spedizione (ID_spedizione, data_sp, costi_sp, costi_exp, ordine_spedito) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, spedizione.getIdSpedizione());
			statement.setDate(2, spedizione.getDataSpedizione());
			statement.setBigDecimal(3, spedizione.getCostiSpedizione());
			statement.setBigDecimal(4, spedizione.getCostiExtra());
			statement.setInt(5, spedizione.getIdOrdine());
			statement.executeUpdate();
		}
	}

	// Altre operazioni CRUD per Spedizione
}
