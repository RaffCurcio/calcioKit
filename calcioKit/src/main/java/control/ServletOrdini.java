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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.ComposizioneDAO;
import dao.DBConnection;
import dao.OrdineDAO;
import dao.ProdottoDAO;
import model.Cliente;
import model.Composizione;
import model.Ordine;
import model.Prodotto;

@WebServlet("/Ordini")
public class ServletOrdini extends HttpServlet {
	private static final long serialVersionUID = 8L;
	private ComposizioneDAO composizioneDAO;
	private Gson gson;
	private OrdineDAO ordineDAO;
	private ProdottoDAO prodottoDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");

		if (cliente == null) {
			response.sendRedirect("Login.jsp");
			return;
		}

		try {
			System.out.println(cliente.getUsername() + cliente.getEmail());
			List<Ordine> ordini = ordineDAO.getOrdineForUser(cliente.getUsername(), cliente.getEmail());
			JsonObject resultJson = new JsonObject();

			for (Ordine ordine : ordini) {
				int ordineId = ordine.getIdOrdine();
				List<Composizione> composizioni = composizioneDAO.findOrderedItemsByOrderId(cliente.getUsername(),
						cliente.getEmail(), ordineId);

				JsonObject ordineJson = new JsonObject();
				ordineJson.addProperty("orderId", ordine.getIdOrdine());

				ordineJson.addProperty("orderDate", ordine.getDataInserimento().toString());
				ordineJson.addProperty("totalAmount", ordine.getPrezzoVendita().toString());
				ordineJson.addProperty("orderStatus", ordine.getStatoOrdine());

				JsonArray composizioniJson = new JsonArray();
				for (Composizione composizione : composizioni) {
					JsonObject composizioneJson = new JsonObject();

					Prodotto prodotto = prodottoDAO.getProdottoById(composizione.getIdProdotto());
					JsonObject prodottoJson = new JsonObject();
					prodottoJson.addProperty("price", prodotto.getPrezzo().toString());
					prodottoJson.addProperty("name", prodotto.getNomeProdotto());
					prodottoJson.addProperty("description", prodotto.getDescrizione());

					prodottoJson.addProperty("image", prodotto.getPath_immagine());

					composizioneJson.add("product", prodottoJson);
					composizioneJson.addProperty("quantity", composizione.getQuantita_prodotto());
					composizioneJson.addProperty("price", composizione.getPrezzo_vendita().toString());

					composizioniJson.add(composizioneJson);
				}

				ordineJson.add("composizioni", composizioniJson);
				resultJson.add(String.valueOf(ordineId), ordineJson);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(resultJson));
		} catch (SQLException e) {
			String errorMessage = "There was an error during the retrieval of your ordini, try again " + e;
			response.sendError(500, errorMessage);
		}
	}

	@Override
	public void init() {
		ordineDAO = new OrdineDAO(DBConnection.getDataSource());
		composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource());
		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource());
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
}
