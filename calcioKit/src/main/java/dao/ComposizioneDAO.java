package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    // Altre operazioni CRUD per Composizione
}

