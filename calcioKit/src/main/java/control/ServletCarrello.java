package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Cliente;
import model.Composizione;
import model.Prodotto;

@WebServlet("/Cart")
public class ServletCarrello extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private ProdottoDAO prodottoDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Composizione> composizioni = null;
		if (((Cliente) session.getAttribute("cliente")) == null) {
			composizioni = (List<Composizione>) session.getAttribute("guestCart");

		} else {
			composizioni = (List<Composizione>) session.getAttribute("carrello");

		}		// Create a JsonArray to hold the cart item objects
		JsonArray composizioniJson = new JsonArray();
		BigDecimal prezzoTotale = BigDecimal.ZERO;
		if (composizioni != null) {
			for (Composizione composizione : composizioni) {
				Prodotto product = null;
				try {

					product = prodottoDAO.getProdottoById(composizione.getIdProdotto());

					// Create a JsonObject for each cart item
					JsonObject composizioneJson = new JsonObject();
					composizioneJson.addProperty("path_immagine", product.getPath_immagine());

					composizioneJson.addProperty("nomeProdotto", product.getIdProdotto());
					composizioneJson.addProperty("descrizione", product.getDescrizione());
					composizioneJson.addProperty("nomeCatalogo", product.getNomeCatalogo());
					composizioneJson.addProperty("prezzo", product.getPrezzo());
					composizioneJson.addProperty("quantity", composizione.getQuantita_prodotto());
					try {
						prezzoTotale = prezzoTotale.add(
								product.getPrezzo().multiply(BigDecimal.valueOf(composizione.getQuantita_prodotto())));
					} catch (NullPointerException e) {
						String errorMessage = "There was an error retrieving your cart data";
						response.sendError(500, errorMessage);
						return;
					}
					composizioniJson.add(composizioneJson); // Add composizioneJson to composizioniJson

				} catch (SQLException e) {
					String errorMessage = "There was an error retrieving your cart data";
					response.sendError(500, errorMessage);
					return;

				}

			}
		}
		// Set the cart items JsonArray as a request attribute
		request.setAttribute("composizioniJson", composizioniJson.toString());
		request.setAttribute("prezzoTotale", prezzoTotale);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	public void init() {
		// Initialize the UserDAO instance
		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data
																		// source
																		// source
	}

}
