package control;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Cliente;
import model.Composizione;

@WebServlet("/update-quantita")
public class ServletAggiornaQuantitaCarrello extends HttpServlet {
	private static final long serialVersionUID = 5162781596625596474L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve the quantita and product ID from the request
		String requestBody = request.getReader().lines().collect(Collectors.joining());

		// Parse the request payload to a JsonObject
		JsonObject json = new Gson().fromJson(requestBody, JsonObject.class);

		// Retrieve the quantita and product ID from the JsonObject
		int quantita = json.get("quantita").getAsInt();
		int prodottoId = json.get("prodottoId").getAsInt();

		// Perform validation or further processing as needed

		// Update the quantita in the session
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Composizione> carrello = null;
		if (((Cliente) session.getAttribute("cliente")) == null) {
			carrello = (List<Composizione>) session.getAttribute("guestCart");

			session.setAttribute("guestCart", carrello);
		} else {
			carrello = (List<Composizione>) session.getAttribute("carrello");

		}
		if (carrello != null) {
			for (Composizione cartItem : carrello) {
				if (cartItem.getIdProdotto() == prodottoId) {
					if (quantita > 10 || quantita < 1) {
						String errorMessage = "Invalid quanitity found, min 1, max 10";
						request.setAttribute("errorMessage", errorMessage);
						request.getRequestDispatcher("/Cart.jsp").forward(request, response);
					}
					cartItem.setQuantita_prodotto(quantita);
					break;
				}
			}
		}
		if (((Cliente) session.getAttribute("cliente")) == null) {
			session.setAttribute("guestCart", carrello);

		} else {
			session.setAttribute("carrello", carrello);

		}
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("success", true);

		// Convert the JSON response to a string
		String json2 = new Gson().toJson(jsonResponse);

		// Send the response
		response.setContentType("application/json");
		response.getWriter().write(json2);
	}
}
