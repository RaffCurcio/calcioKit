package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.DBConnection;
import model.Cliente;

@WebServlet("/modificaProfilo")
public class ServletProfiloUtente extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 5L;
	private ClienteDAO clienteDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handle GET requests to the /register URL
		// Display an error message or redirect to an appropriate page
		String errorMessage = "HTTP method GET is not supported for this resource";
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the entered profile details from the request parameters
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String indirizzo = request.getParameter("indirizzo");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		String cap = request.getParameter("cap");

		if (!nome.matches("^[a-zA-Z]{1,50}$")) {
			String errorMessage = "Invalid nome (1-50 characters)";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}
		if (!cognome.matches("^[a-zA-Z]{1,50}$")) {
			String errorMessage = "Invalid cognome (1-50 characters)";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}

		// Validate indirizzo
		if (!indirizzo.matches("^[a-zA-Z0-9 ]{1,100}$")) {
			String errorMessage = "Invalid indirizzo (1-100 characters)";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}

		// Validate citta
		if (!citta.matches("^[a-zA-Z]{1,50}$")) {
			String errorMessage = "Invalid indirizzo (1-50 characters)";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}

		if (!provincia.matches("^[a-zA-Z]{1,50}$")) {
			String errorMessage = "Invalid indirizzo (1-50 characters)";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}

		// Get the cliente ID from the session
		HttpSession session = request.getSession();
		Cliente cliente = ((Cliente) session.getAttribute("cliente"));
		;

		if (cliente == null) {
			// Cliente is not authenticated, redirect to login page or show an error message
			response.sendRedirect("login.jsp");
			return;
		}

		// Create a new Cliente object

		cliente.setUsername(cliente.getUsername());
		cliente.setEmail(cliente.getEmail());
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setIndirizzo(indirizzo);
		cliente.setCitta(citta);
		cliente.setCap(cap);
		cliente.setProvincia(provincia);

		try {
			// Update the cliente details in the database
			clienteDAO.updateCliente(cliente);
			// Update the cliente object in the session
			session.setAttribute("cliente", cliente);
			// Redirect to the profile page with a success message
			response.sendRedirect("ProfiloUtente.jsp");
		} catch (SQLException e) {
			// Redirect to the profile page with an error message
			response.sendRedirect("ProfiloUtente.jsp");
		}
	}

	@Override
	public void init() {
		clienteDAO = new ClienteDAO(DBConnection.getDataSource());
	}
}
