package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Composizione;
import model.Composizione;

public class ComposizioneDAO {
    private DataSource dataSource;

    public ComposizioneDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertComposizione(Composizione composizione) throws SQLException {
        String query = "INSERT INTO composizione (id_prodotto, id_ordine) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, composizione.getIdProdotto());
            statement.setInt(2, composizione.getIdOrdine());
            statement.executeUpdate();
        }
    }

    public List<Composizione> getComposizioniByUsernameAndEmail(String username, String email) throws SQLException {
        List<Composizione> composizioni = new ArrayList<>();
        String query = "SELECT * FROM composizione WHERE username_cli = ? AND email_cli = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                	int quantita = resultSet.getInt("quantita");
                	int idProdotto = resultSet.getInt("ID_prodotto");
                	String username_cli = resultSet.getString("username_cli");
                	String email_cli = resultSet.getString("email_cli");
                    // Altri campi da recuperare se necessario
                    
                    Composizione composizione = new Composizione();
                    composizione.setIdProdotto(idProdotto);
                    composizione.setQuantita_prodotto(quantita);
                    composizione.setUsername(username_cli);
                    composizione.setEmail(email_cli);
                    composizioni.add(composizione);
                }
            }
        }
        return composizioni;
    }
    
    public void saveAllComposizione(List<Composizione> composizioni) throws SQLException {

		String query = "INSERT INTO composizione (username_cli, email_cli, quantita , id_prodotto) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE quantita =VALUES(quantita);";
		
		for (Composizione composizione : composizioni) {
			try (Connection connection = dataSource.getConnection();
					PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, composizione.getUsername());
				statement.setString(2, composizione.getEmail());
				statement.setInt(3, composizione.getQuantita_prodotto());
				statement.setInt(4, composizione.getIdProdotto());
				statement.executeUpdate();
			}
		}
	}
    
    public void removeComposizione(String username, String email , int idProdotto) throws SQLException {
		String query = "DELETE FROM composizione WHERE username_cli = ? AND email_cli = ? AND id_prodotto = ?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, idProdotto);
			statement.executeUpdate();
		}
	}
    // Altre operazioni CRUD per Composizione
}

