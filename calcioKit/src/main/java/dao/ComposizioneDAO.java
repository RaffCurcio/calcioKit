package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

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
        String query = "SELECT * FROM composizione WHERE username = ? AND email = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idProdotto = resultSet.getInt("id_prodotto");
                    // Altri campi da recuperare se necessario
                    
                    Composizione composizione = new Composizione();
                    composizione.setIdProdotto(idProdotto);
                    composizioni.add(composizione);
                }
            }
        }
        return composizioni;
    }
    // Altre operazioni CRUD per Composizione
}

