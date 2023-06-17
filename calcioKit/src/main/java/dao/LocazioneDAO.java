package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Locazione;

public class LocazioneDAO {
	private DataSource dataSource;

	public LocazioneDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertLocazione(Locazione locazione) throws SQLException {
		String query = "INSERT INTO Locazione (Id_prod, nome_m, indirizzo_m, città_m) VALUES (?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, locazione.getIdProdotto());
			statement.setString(2, locazione.getNomeMagazzino());
			statement.setString(3, locazione.getIndirizzoMagazzino());
			statement.setString(4, locazione.getCittàMagazzino());
			statement.executeUpdate();
		}
	}

	// Altre operazioni CRUD per Locazione
}
