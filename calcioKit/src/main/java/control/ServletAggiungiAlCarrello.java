package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Composizione;

@WebServlet("/AggiungiAlCarrello")
public class ServletAggiungiAlCarrello extends HttpServlet {

	private static final long serialVersionUID = 6L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the product ID and quantita from the request parameters
		String referer = request.getHeader("referer");

		int productId = Integer.parseInt(request.getParameter("idProdotto"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));

		// Get the current cliente from the session
		HttpSession session = request.getSession();

		if (quantita <= 0) {
			String errorMessage = "invalid quantita";
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, errorMessage);
			return;
		}

		Cliente cliente = null;

		List<Composizione> carrello = null;
		if (((Cliente) session.getAttribute("cliente")) == null) {
			carrello = (List<Composizione>) session.getAttribute("guestCart");

			session.setAttribute("guestCart", carrello);
		} else {
			carrello = (List<Composizione>) session.getAttribute("carrello");
			cliente = ((Cliente) session.getAttribute("cliente"));

		}

		if (carrello == null) {
			carrello = new ArrayList<>();
		}

		boolean productExists = false;
		for (Composizione composizione : carrello) {
			if (composizione.getIdProdotto() == productId) {
				// Update the quantita of the existing carrello item
				productExists = true;

				if(composizione.getQuantita_prodotto() + quantita > 10)
					break;
				composizione.setQuantita_prodotto(composizione.getQuantita_prodotto() + quantita);

				break;
			}
		}

		// If the product does not exist in the carrello, create a new carrello item

		if (((Cliente) session.getAttribute("cliente")) == null) {
			if (!productExists) {
				// Create a new carrello item with the specified product and quantita
				Composizione newComposizione = new Composizione();
				newComposizione.setIdProdotto(productId);
				newComposizione.setQuantita_prodotto(quantita);
				carrello.add(newComposizione);

			}
			session.setAttribute("guestCart", carrello);
		} else {
			if (!productExists) {
				// Create a new carrello item with the specified product and quantita
				Composizione newComposizione = new Composizione();
				newComposizione.setIdProdotto(productId);
				newComposizione.setEmail(cliente.getEmail());
				newComposizione.setUsername(cliente.getUsername());

				newComposizione.setQuantita_prodotto(quantita);
				carrello.add(newComposizione);

			}
			session.setAttribute("carrello", carrello);

		}
		response.sendRedirect(referer);
	}

}
