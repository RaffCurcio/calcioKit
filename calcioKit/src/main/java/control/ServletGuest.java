package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletGuest")
public class ServletGuest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void addToCart(HttpServletRequest request, HttpServletResponse response, String productId) {
		// Ottenere il carrello corrente dal cookie
		List<String> cart = getCartFromCookie(request);

		// Aggiungere l'ID del prodotto al carrello
		cart.add(productId);

		// Salvare il carrello nel cookie
		saveCartToCookie(response, cart);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null && action.equals("add")) {
			String productId = request.getParameter("productId");
			if (productId != null && !productId.isEmpty()) {
				addToCart(request, response, productId);
			}
		} else if (action != null && action.equals("remove")) {
			String productId = request.getParameter("productId");
			if (productId != null && !productId.isEmpty()) {
				removeFromCart(request, response, productId);
			}
		}

		// Redirect alla pagina del carrello
		
	}

	private List<String> getCartFromCookie(HttpServletRequest request) {
		List<String> cart = new ArrayList<>();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart")) {
					// Se il cookie "cart" esiste, recuperare il valore (ID dei prodotti nel
					// carrello)
					String[] productIds = cookie.getValue().split(",");
					for (String productId : productIds) {
						cart.add(productId);
					}
					break;
				}
			}
		}

		return cart;
	}

	private void removeFromCart(HttpServletRequest request, HttpServletResponse response, String productId) {
		// Ottenere il carrello corrente dal cookie
		List<String> cart = getCartFromCookie(request);

		// Rimuovere l'ID del prodotto dal carrello
		cart.remove(productId);

		// Salvare il carrello nel cookie
		saveCartToCookie(response, cart);
	}

	private void saveCartToCookie(HttpServletResponse response, List<String> cart) {
		StringBuilder cartValue = new StringBuilder();
		for (String productId : cart) {
			cartValue.append(productId).append(",");
		}

		// Creare un cookie "cart" con il valore del carrello
		Cookie cookie = new Cookie("cart", cartValue.toString());
		cookie.setMaxAge(3600); // Impostare la durata del cookie (in secondi)
		cookie.setPath("/"); // Impostare il percorso del cookie

		// Aggiungere il cookie alla risposta
		response.addCookie(cookie);
	}
}
