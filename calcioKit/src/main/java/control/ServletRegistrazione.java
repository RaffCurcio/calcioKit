package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.DBConnection;
import model.Cliente;

@WebServlet("/registrazione")
public class ServletRegistrazione extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve cliente input from the registration form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// Validate username
		if (!username.matches("^[a-zA-Z0-9_]{5,20}$")) {
			String errorMessage = "Invalid username (5-20 characters, alphanumeric and underscore only)";
			request.setAttribute("errorMessage", errorMessage);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// Validate email
		if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
			String errorMessage = "Invalid email address";
			request.setAttribute("errorMessage", errorMessage);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// Validate password
		if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
			String errorMessage = "Invalid password (minimum 8 characters, at least one letter and one number)";
			request.setAttribute("errorMessage", errorMessage);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// Create a new Cliente object
		Cliente cliente = new Cliente();
		cliente.setUsername(username);
		cliente.setPassword(password);
		cliente.setEmail(email);
		cliente.setRuolo_cliente("cliente");

		try {
			// Save the cliente to the database
			clienteDAO.addCliente(cliente);

			// Redirect to a success page or display a success message
			request.getRequestDispatcher("login").forward(request, response);
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				// Handle duplicate entry error
				String errorMessage = "Username or email already exists";
				request.setAttribute("errorMessage", errorMessage);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				request.getRequestDispatcher("/Registrazione.jsp").forward(request, response);
			} else {
				// Redirect to an error page or display a generic error message
				response.sendRedirect("error.jsp");
			}
		}
	}

	@Override
	public void init() {
		// Initialize the ClienteDAO instance
		clienteDAO = new ClienteDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source

	}

	// Other methods, such as doGet(), can be implemented if needed
}
