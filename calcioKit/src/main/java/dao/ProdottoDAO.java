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
		String query = "INSERT INTO prodotto (nome_prodotto, descrizione, iva_p, prezzo, path_immagine, nome_c) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, prodotto.getNomeProdotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setDouble(3, prodotto.getIva());
			statement.setBigDecimal(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getPath_immagine());
			statement.setString(6, prodotto.getNomeCatalogo());
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
				prodotto.setNomeCatalogo(resultSet.getString("nome_c"));
				prodotti.add(prodotto);

			}
			return prodotti;
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
					prodotto.setNomeCatalogo(resultSet.getString("nome_c"));
					return prodotto;
				}
			}
		}
		return null; // Prodotto non trovato
	}

	// Metodo per aggiornare un prodotto esistente
	public void updateProdotto(Prodotto prodotto) throws SQLException {
		String query = "UPDATE prodotto SET nome_prodotto = ?, descrizione = ?, iva_p = ?, prezzo = ?, path_immagine = ?, nome_c = ? WHERE ID_prodotto = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, prodotto.getNomeProdotto());
			statement.setString(2, prodotto.getDescrizione());
			statement.setDouble(3, prodotto.getIva());
			statement.setBigDecimal(4, prodotto.getPrezzo());
			statement.setString(5, prodotto.getPath_immagine());
			statement.setString(6, prodotto.getNomeCatalogo());
			statement.setInt(7, prodotto.getIdProdotto());
			statement.executeUpdate();
		}
	}

}
