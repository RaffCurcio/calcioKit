package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Catalogo;

public class CatalogoDAO {
	private Connection connection;

	// Costruttore
	public CatalogoDAO(Connection connection) {
		this.connection = connection;
	}

	// Metodo per ottenere tutti i cataloghi
	public List<Catalogo> getAllCataloghi() throws SQLException {
		List<Catalogo> cataloghi = new ArrayList<>();

		String query = "SELECT * FROM Catalogo";
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				String nomeCatalogo = resultSet.getString("nome_catalogo");
				String descrizione = resultSet.getString("descrizione_cat");

				Catalogo catalogo = new Catalogo(nomeCatalogo, descrizione);
				cataloghi.add(catalogo);
			}
		}

		return cataloghi;
	}

	// Altri metodi per CRUD (Create, Read, Update, Delete) dei cataloghi
	// ...
}
