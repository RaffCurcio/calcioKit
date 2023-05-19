package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Magazzino;

public class MagazzinoDAO {
    private DataSource dataSource;

    public MagazzinoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertMagazzino(Magazzino magazzino) throws SQLException {
        String query = "INSERT INTO Magazzino (nome_magazzino, indirizzo, città) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, magazzino.getNomeMagazzino());
            statement.setString(2, magazzino.getIndirizzo());
            statement.setString(3, magazzino.getCittà());
            statement.executeUpdate();
        }
    }

    public Magazzino getMagazzinoByNomeIndirizzoCittà(String nomeMagazzino, String indirizzo, String città) throws SQLException {
        String query = "SELECT * FROM Magazzino WHERE nome_magazzino = ? AND indirizzo = ? AND città = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, nomeMagazzino);
            statement.setString(2, indirizzo);
            statement.setString(3, città);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Magazzino magazzino = new Magazzino();
                    magazzino.setNomeMagazzino(resultSet.getString("nome_magazzino"));
                    magazzino.setIndirizzo(resultSet.getString("indirizzo"));
                    magazzino.setCittà(resultSet.getString("città"));
                    return magazzino;
                }
            }
        }
        return null;
    }

    // Altre operazioni CRUD per Magazzino
}

