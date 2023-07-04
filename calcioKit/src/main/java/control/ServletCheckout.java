package control;

import java.io.IOException;
import java.math.BigDecimal;
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
import dao.OrdineDAO;
import dao.ProdottoDAO;
import model.Cliente;
import model.Composizione;
import model.Ordine;
import model.Prodotto;

@WebServlet("/Checkout")
public class ServletCheckout extends HttpServlet {
	private static final long serialVersionUID = 12L;
	private ComposizioneDAO composizioneDAO;
	private OrdineDAO ordineDAO;
	private ProdottoDAO prodottoDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String sessionToken = ((String) session.getAttribute("sessionToken"));
		String clientToken = (request.getParameter("clientToken"));
		BigDecimal totalPrice = new BigDecimal(request.getParameter("prezzoTotale"));

		Cliente cliente = (Cliente) session.getAttribute("cliente");
		java.sql.Date localDate = new java.sql.Date(System.currentTimeMillis());

		if (cliente == null || !sessionToken.equals(clientToken)) {
			String errorMessage = "You are not logged in, please login";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}
		if (cliente.getNome() == null || !cliente.getNome().matches("^[a-zA-Z ]{1,30}$")) {
			String errorMessage = "Cliente Profile must be compiled before Checkout (First Name missing)";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("ProfiloUtente.jsp").forward(request, response);

			return;
		}
		if (cliente.getCognome() == null || !cliente.getCognome().matches("^[a-zA-Z ]{1,30}$")) {
			String errorMessage = "Cliente Profile must be compiled before Checkout (Last Name missing)";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("ProfiloUtente.jsp").forward(request, response);

			return;
		}

		if (cliente.getIndirizzo() == null || !cliente.getIndirizzo().matches("[a-zA-Z0-9 ]{1,100}$")) {
			String errorMessage = "Cliente Profile must be compiled before Checkout (Home Address missing)";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("ProfiloUtente.jsp").forward(request, response);

			return;
		}

		List<Composizione> composiziones;
		if (((Cliente) session.getAttribute("cliente")) == null) {
			composiziones = (List<Composizione>) session.getAttribute("guestCart");
		} else {
			composiziones = (List<Composizione>) session.getAttribute("carrello");
		}
		try {
			composizioneDAO.saveAllComposizioni(composiziones);
		} catch (SQLException e) {
			String errorMessage = "There was an error in saving your cart data to the database";
			response.sendError(500, errorMessage);
			return;
		}

		Ordine ordine = new Ordine();
		Prodotto product;

		ordine.setIdOrdine(0);
		ordine.setDataInserimento(localDate);
		ordine.setPrezzoVendita(totalPrice);
		ordine.setEmailCliente(cliente.getEmail());
		ordine.setUsernameCliente(cliente.getUsername());
		ordine.setStatoOrdine("Awaiting Shipment");
		int ordineId;
		try {
			ordineId = ordineDAO.saveOrdine(ordine);
		} catch (SQLException e) {
			String errorMessage = "There was an error in creating the ordine, try again";
			response.sendError(500, errorMessage);
			return;
		}

		for (Composizione composizione : composiziones) {
			try {

				product = prodottoDAO.getProdottoById(composizione.getIdProdotto());
				if (product == null) {
					String errorMessage = "The item you were buying got deleted, return to the cart";
					response.sendError(500, errorMessage);
					return;
				}

			} catch (SQLException e) {
				String errorMessage = "There was an error in retrieving the product in your cart, try removing each cart item";
				response.sendError(500, errorMessage);
				return;

			}
			composizione.setPrezzo_vendita(product.getPrezzo());
			try {
				composizioneDAO.updateComposizione(ordineId, cliente.getUsername(), cliente.getEmail(),
						product.getPrezzo(), product.getIdProdotto());
			} catch (SQLException e) {
				String errorMessage = "There was an error in updating the product in your cart, try removing each cart item";
				response.sendError(500, errorMessage);
				return;
			}
			session.setAttribute("carrello", null);
		}

		response.sendRedirect("Ordini.jsp");
	}

	@Override
	public void init() {
		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource());
		composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource());
		ordineDAO = new OrdineDAO(DBConnection.getDataSource());

	}

}