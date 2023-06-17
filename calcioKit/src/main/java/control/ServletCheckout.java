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
	private static final long serialVersionUID = 2L;
	private ProdottoDAO prodottoDAO;
	private ComposizioneDAO composizioneDAO;
	private OrdineDAO ordineDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		//String sessionToken = ((String) session.getAttribute("sessionToken"));
		//String clientToken = (request.getParameter("clientToken"));
		BigDecimal totalPrice = new BigDecimal(request.getParameter("prezzoTotale"));

		Cliente cliente = (Cliente) session.getAttribute("cliente");
		java.sql.Date localDate = new java.sql.Date(System.currentTimeMillis());

		if (cliente == null /*	|| !sessionToken.equals(clientToken)*/) {
			// Cliente is not authenticated, redirect to login page or show an error message
			response.sendRedirect("Login.jsp");
			return;
		}

		@SuppressWarnings("unchecked")
		List<Composizione> composizioni = (List<Composizione>) session.getAttribute("carrello");
		try {
			composizioneDAO.saveAllComposizioni(composizioni);
		} catch (SQLException e) {
			String errorMessage = "There was an error in saving your cart data to the database";
			response.sendError(500, errorMessage + e);
			return;
		}
		try {
			Ordine ordine = new Ordine();
			Prodotto prodotto = new Prodotto();

			ordine.setIdOrdine(0);
			ordine.setDataInserimento(localDate);
			ordine.setPrezzoVendita(totalPrice);
			ordine.setEmailCliente(cliente.getEmail());
			ordine.setUsernameCliente(cliente.getUsername());
			ordine.setIvaCout(22);
			ordine.setStatoOrdine("Spedito");
			int ordineId = ordineDAO.saveOrdine(ordine); // Save the ordine

			for (Composizione composizione : composizioni) {
				try {
					prodotto = prodottoDAO.getProdottoById(composizione.getIdProdotto());
				} catch (SQLException e) {
					String errorMessage = "There was an error in retrieving the prodotto in your cart, try removing each cart item";
					response.sendError(500, errorMessage);
					return;

				}
				composizione.setPrezzo_vendita(prodotto.getPrezzo());
				composizioneDAO.updateComposizione(ordineId, cliente.getUsername(), cliente.getEmail(), prodotto.getPrezzo(),
						prodotto.getIdProdotto());
				session.setAttribute("carrello", null);
			}

		} catch (SQLException e) {
			String errorMessage = "There was an error in retrieving saving your ordine, try again" + e;
			response.sendError(500, errorMessage);
			return;
		}
		response.sendRedirect("Ordines.jsp");
	}

	@Override
	public void init() {
		// Initialize the ClienteDAO instance
		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource());
		composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource());
		ordineDAO = new OrdineDAO(DBConnection.getDataSource());

	}

}
