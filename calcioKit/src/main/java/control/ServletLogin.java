package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComposizioneDAO;
import dao.DBConnection;
import dao.ClienteDAO;
import model.Composizione;
import model.Cliente;


@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 3L;

	private ComposizioneDAO composizioneDAO;
	private ClienteDAO clienteDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the entered username and password from the request parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Perform authentication logic here (e.g., checking against a database)
		Cliente cliente = null;
		List<Composizione> composizioni = null;

		try {
			cliente = clienteDAO.getClienteByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
			
		}

		if (cliente != null) {
			try {
				
				composizioni = composizioneDAO.getComposizioniByUsernameAndEmail(cliente.getUsername(),cliente.getEmail());

			} catch (SQLException e) {
				response.sendRedirect("error.jsp");
			}

			// Create a session and set session attributes
			HttpSession session = request.getSession();
			session.setAttribute("cliente", cliente);
			session.setAttribute("carrello", composizioni);

			// Redirect to a protected resource or home page
			response.sendRedirect("Homepage.jsp");
		} else {
			// Authentication failed, redirect back to the login page with an error message
			response.sendRedirect("login.jsp?error=1");
		}
	}

	@Override
	public void init() {
		// Initialize the ClienteDAO instance
		clienteDAO = new ClienteDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source
		
		composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource());
	}

}
