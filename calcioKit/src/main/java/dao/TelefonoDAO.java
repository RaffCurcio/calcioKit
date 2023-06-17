package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Telefono;

public class TelefonoDAO {
	private DataSource dataSource;

	public TelefonoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertTelefono(Telefono telefono) throws SQLException {
		String query = "INSERT INTO Telefono (numero_tel, prefisso, username_cli, email_cli) VALUES (?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, telefono.getNumeroTelefono());
			statement.setString(2, telefono.getPrefisso());
			statement.setString(3, telefono.getUsernameCliente());
			statement.setString(4, telefono.getEmailCliente());
			statement.executeUpdate();
		}
	}

	// Altre operazioni CRUD per Telefono
}
