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

    // Metodo per ottenere tutti i prodotti
 // Get all Prodotti
    public List<Prodotto> getAllProdotti() throws SQLException {
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
                prodotto.setPrezzo(resultSet.getDouble("prezzo"));
                prodotto.setPath_immagine(resultSet.getString("path_immagine"));
                prodotto.setNomeCatalogo(resultSet.getString("nome_c"));
                prodotti.add(prodotto);
                
            }
            return prodotti;
        }
    }

    // Altri metodi per CRUD (Create, Read, Update, Delete) dei prodotti
    // ...
}

