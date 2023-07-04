package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Prodotto;

public class ProdottoDAO {
	private DataSource dataSource;

	// Costruttore
	public ProdottoDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Metodo per creare un nuovo prodotto
	public void createProdotto(Prodotto prodotto) throws SQLException {
		String query = "INSERT INTO prodotto (nome_prodotto, descrizione, iva_p, prezzo, path_immagine) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, prodotto.getNomeProdotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setDouble(3, prodotto.getIva());
			statement.setBigDecimal(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getPath_immagine());
			statement.executeUpdate();
		}
	}

	// Metodo per eliminare un prodotto esistente
	public void deleteProdotto(int id) throws SQLException {
		String query = "UPDATE prodotto SET cancellato = TRUE WHERE ID_prodotto = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		}
	}
	public List<Prodotto> getAllProdottiZoccolame() throws SQLException {
		String query = "SELECT * FROM prodotto";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			List<Prodotto> prodotti = new ArrayList<>();
			while (resultSet.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt("ID_prodotto"));
				prodotto.setNomeProdotto(resultSet.getString("nome_prodotto"));
				prodotto.setDescrizione(resultSet.getString("descrizione"));
				prodotto.setIva(resultSet.getDouble("iva_p"));
				prodotto.setPrezzo(resultSet.getBigDecimal("prezzo"));
				prodotto.setPath_immagine(resultSet.getString("path_immagine"));
				prodotti.add(prodotto);

			}
			return prodotti;
		}
	}
	// Metodo per ottenere tutti i prodotti
	// Get all Prodotti
	public List<Prodotto> getAllProdotti() throws SQLException {
		String query = "SELECT * FROM prodotto WHERE cancellato = FALSE";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			List<Prodotto> prodotti = new ArrayList<>();
			while (resultSet.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setIdProdotto(resultSet.getInt("ID_prodotto"));
				prodotto.setNomeProdotto(resultSet.getString("nome_prodotto"));
				prodotto.setDescrizione(resultSet.getString("descrizione"));
				prodotto.setIva(resultSet.getDouble("iva_p"));
				prodotto.setPrezzo(resultSet.getBigDecimal("prezzo"));
				prodotto.setPath_immagine(resultSet.getString("path_immagine"));
				prodotti.add(prodotto);

			}
			return prodotti;
		}
	}

	public Prodotto getOrderProduct(int productId) throws SQLException {
		String query = "SELECT * FROM prodotto WHERE ID_prodotto = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, productId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Prodotto product = new Prodotto();
					product.setIdProdotto(resultSet.getInt("ID_prodotto"));
					product.setNomeProdotto(resultSet.getString("nome_prodotto"));
					product.setDescrizione(resultSet.getString("descrizione"));
					product.setIva(resultSet.getDouble("iva_p"));
					product.setPrezzo(resultSet.getBigDecimal("prezzo"));
					product.setPath_immagine(resultSet.getString("path_immagine"));
					product.setCancellato(resultSet.getBoolean("cancellato"));

					return product;

				} else {
					return null;
				}
			}
		}
	}

	// Altri metodi per CRUD (Create, Read, Update, Delete) dei prodotti
	// ...
	// Metodo per ottenere un prodotto per ID
	public Prodotto getProdottoById(int id) throws SQLException {
		String query = "SELECT * FROM prodotto WHERE ID_prodotto = ? AND cancellato = FALSE";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Prodotto prodotto = new Prodotto();
					prodotto.setIdProdotto(resultSet.getInt("ID_prodotto"));
					prodotto.setNomeProdotto(resultSet.getString("nome_prodotto"));
					prodotto.setDescrizione(resultSet.getString("descrizione"));
					prodotto.setIva(resultSet.getDouble("iva_p"));
					prodotto.setPrezzo(resultSet.getBigDecimal("prezzo"));
					prodotto.setPath_immagine(resultSet.getString("path_immagine"));
					return prodotto;
				}
			}
		}
		return null; // Prodotto non trovato
	}

	public Prodotto getProdottoByName(String name) throws SQLException {
		String query = "SELECT * FROM prodotto WHERE nome_prodotto = ? AND cancellato = FALSE";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, name);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Prodotto prodotto = new Prodotto();
					prodotto.setIdProdotto(resultSet.getInt("ID_prodotto"));
					prodotto.setNomeProdotto(resultSet.getString("nome_prodotto"));
					prodotto.setDescrizione(resultSet.getString("descrizione"));
					prodotto.setIva(resultSet.getDouble("iva_p"));
					prodotto.setPrezzo(resultSet.getBigDecimal("prezzo"));
					prodotto.setPath_immagine(resultSet.getString("path_immagine"));
					return prodotto;
				}
			}
		}
		return null; // Prodotto non trovato
	}

	public void toggleProductDeleted(int productId) throws SQLException {
		String query = "UPDATE Prodotto SET cancellato = CASE WHEN cancellato = 1 THEN 0 ELSE 1 END WHERE ID_prodotto = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, productId);
			statement.executeUpdate();
		}
	}

	// Metodo per aggiornare un prodotto esistente
	public void updateProdotto(Prodotto prodotto) throws SQLException {
		String query = "UPDATE prodotto SET nome_prodotto = ?, descrizione = ?, iva_p = ?, prezzo = ?, path_immagine = ? WHERE ID_prodotto = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, prodotto.getNomeProdotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setDouble(3, prodotto.getIva());
			statement.setBigDecimal(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getPath_immagine());
			statement.setInt(6, prodotto.getIdProdotto());
			statement.executeUpdate();
		}
	}

}
