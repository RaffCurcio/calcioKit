package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import model.Cliente;
import model.Cliente;

public class ClienteDAO {
    private DataSource dataSource;

    public ClienteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void addCliente(Cliente cliente) throws SQLException {
		String query = "INSERT INTO Cliente (username, pwd, email, ruolo_cliente) VALUES (?, ?, ?, ?)";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, cliente.getUsername());
			statement.setString(2, cliente.getPassword());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getRuolo_cliente());

			statement.executeUpdate();
		}
	}
    
    public void cancellaCliente(String username , String password) throws SQLException {
		String query = "DELETE FROM Cliente WHERE username = ? AND pwd = ?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
		}
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
        cliente.setCitta(resultSet.getString("citta"));
        cliente.setProvincia(resultSet.getString("provincia"));
        cliente.setCap(resultSet.getString("cap"));
        cliente.setRuolo_cliente(resultSet.getString("ruolo_cliente"));
        return cliente;
    }
    
    public Cliente getClienteByUsernamePassword(String Username, String Password) throws SQLException {
		String query = "SELECT * FROM Cliente WHERE username = ? AND pwd = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, Username);
			statement.setString(2, Password);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					Cliente cliente = new Cliente();
					cliente.setUsername(resultSet.getString("username"));
					cliente.setPassword(resultSet.getString("pwd"));
					cliente.setEmail(resultSet.getString("email"));
					cliente.setCap(resultSet.getString("cap"));
					cliente.setCitta(resultSet.getString("citta"));
					cliente.setCognome(resultSet.getString("cognome"));
					cliente.setNome(resultSet.getString("nome"));
					cliente.setIndirizzo(resultSet.getString("indirizzo"));
					cliente.setProvincia(resultSet.getString("provincia"));
			        cliente.setRuolo_cliente(resultSet.getString("ruolo_cliente"));

					
					return cliente;
				}
			}
		}

		return null;
	}
    
    public void updateCliente(Cliente cliente) throws SQLException {
		String query = "UPDATE Cliente SET nome = ?, cognome = ?, citta = ?, provincia = ?, indirizzo = ?, cap = ? WHERE username = ? AND pwd = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCognome());
			statement.setString(3, cliente.getCitta());
			statement.setString(4, cliente.getProvincia());
			statement.setString(5, cliente.getIndirizzo());
			statement.setString(6, cliente.getCap());
			statement.setString(7, cliente.getUsername());
			statement.setString(8, cliente.getPassword());

			statement.executeUpdate();
		}
	}
}



