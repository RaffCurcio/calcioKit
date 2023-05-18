package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.Ordine;

public class OrdineDAO {
    private DataSource dataSource;

    public OrdineDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Ordine getOrdineByID(int idOrdine) throws SQLException {
        String query = "SELECT * FROM Ordine WHERE ID_ordine = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, idOrdine);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractOrdineFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    private Ordine extractOrdineFromResultSet(ResultSet resultSet) throws SQLException {
        Ordine ordine = new Ordine();
        ordine.setIdOrdine(resultSet.getInt("ID_ordine"));
        ordine.setDataInserimento(resultSet.getDate("data_inserimento"));
        ordine.setPrezzoVendita(resultSet.getDouble("prezzo_vendita"));
        ordine.setIvaCout(resultSet.getDouble("iva_cout"));
        ordine.setStatoOrdine(resultSet.getString("stato_ordine"));
        ordine.setUsernameCliente(resultSet.getString("username_cli"));
        ordine.setEmailCliente(resultSet.getString("email_cli"));
        return ordine;
    }
}

