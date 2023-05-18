package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import model.Cliente;

public class ClienteDAO {
    private DataSource dataSource;

    public ClienteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Cliente getClienteByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClienteFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public Cliente getClienteByEmail(String email) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE email = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClienteFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    private Cliente extractClienteFromResultSet(ResultSet resultSet) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setUsername(resultSet.getString("username"));
        cliente.setEmail(resultSet.getString("email"));
        cliente.setPassword(resultSet.getString("pwd"));
        cliente.setNome(resultSet.getString("nome"));
        cliente.setCognome(resultSet.getString("cognome"));
        cliente.setIndirizzo(resultSet.getString("indirizzo"));
        cliente.setCittà(resultSet.getString("città"));
        cliente.setProvincia(resultSet.getString("provincia"));
        cliente.setCap(resultSet.getString("cap"));
        return cliente;
    }
}

