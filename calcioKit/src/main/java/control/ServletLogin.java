package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComposizioneDAO;
import dao.DBConnection;
import dao.PagamentoDAO;
import dao.ClienteDAO;
import model.Composizione;
import model.Pagamento;
import model.Cliente;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 3L;

	private ComposizioneDAO carrelloItemDAO;
	private ClienteDAO clienteDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the entered clientename and password from the request parameters
		String clientename = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		// Perform authentication logic here (e.g., checking against a database)
		Cliente cliente = null;
		Pagamento paymentMethod = null;
		List<Composizione> carrelloItems = null;

		try {
			cliente = clienteDAO.getClienteByUsernamePassword(clientename, password);
		} catch (SQLException e) {
			String errorMessage = "There was an error during the login, try again";
			response.sendError(500, errorMessage);

			return;
		}
		System.out.println(cliente);

		if (cliente != null) {
			/*try {
				//paymentMethod = paymentMethodDAO.getPagamento(cliente.getClienteId());
			} catch (SQLException e) {
				String errorMessage = "There was an error during the retrieval of your data, try again";
				response.sendError(500, errorMessage);
				return;
			}*/

			try {
				carrelloItems = carrelloItemDAO.getComposizioniByUsernameAndEmail(cliente.getUsername(), cliente.getEmail());
			} catch (SQLException e) {
				String errorMessage = "There was an error during the retrieval of your carrello items, try again";
				response.sendError(500, errorMessage);
				return;
			}
			// Get the guest carrello from the guest session
			List<Composizione> guestCart = (List<Composizione>) session.getAttribute("guestCart");

			// Get the cliente carrello from the session or create a new carrello if it doesn't exist
			if (carrelloItems == null) {
				carrelloItems = new ArrayList<>();
			}

			if (guestCart != null && !guestCart.isEmpty()) {
				for (Composizione guestComposizione : guestCart) {
					boolean productExists = false;
					for (Composizione clienteComposizione : carrelloItems) {
						if (guestComposizione.getIdProdotto() == clienteComposizione.getIdProdotto()) {
							// Update the quantity of the existing carrello item
							clienteComposizione.setQuantita_prodotto((clienteComposizione.getQuantita_prodotto() + guestComposizione.getQuantita_prodotto()));
							productExists = true;
							break;
						}
					}
					if (!productExists) {
						// Add the guest carrello item as a new carrello item
						guestComposizione.setUsername(cliente.getUsername());
						guestComposizione.setEmail(cliente.getEmail());
						carrelloItems.add(guestComposizione);
					}
				}
			}

			// Remove the guest carrello from the session
			session.removeAttribute("guestCart");

			// Save the updated cliente carrello in the session
			session.setAttribute("carrello", carrelloItems);

			String sessionToken = UUID.randomUUID().toString();

			session.setAttribute("cliente", cliente);
			session.setAttribute("paymentMethod", paymentMethod);
			session.setAttribute("sessionToken", sessionToken);

			// Redirect to a protected resource or home page
			response.sendRedirect("Homepage.jsp");
		} else {

			String errorMessage = "Incorrect clientename or password";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
	}

	@Override
	public void init() {
		// Initialize the ClienteDAO instance
		clienteDAO = new ClienteDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source
		carrelloItemDAO = new ComposizioneDAO(DBConnection.getDataSource());
	}

}
