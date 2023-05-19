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

	import model.Composizione;
	import model.Cliente;

	@WebServlet("/AddToCart")
	public class ServletCarrello extends HttpServlet {

		private static final long serialVersionUID = 6L;

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Get the product ID and quantity from the request parameters
			String referer = request.getHeader("referer");

			int productId = Integer.parseInt(request.getParameter("productId"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			// Get the current cliente from the session
			HttpSession session = request.getSession();
			Cliente cliente = ((Cliente) session.getAttribute("cliente"));

			@SuppressWarnings("unchecked")
			List<Composizione> carrello = (List<Composizione>) session.getAttribute("carrello");
			if (carrello == null) {
				carrello = new ArrayList<>();
				session.setAttribute("carrello", carrello);
			}
			boolean productExists = false;
			for (Composizione composizione : carrello) {
				
				if (composizione.getIdProdotto() == productId) {
					// Update the quantity of the existing carrello item
					//composizione.setQuantity(composizione.getQuantity() + quantity);
					productExists = true;
					
					break;
				}
			}

			// If the product does not exist in the carrello, create a new carrello item
			if (!productExists) {
				// Create a new carrello item with the specified product and quantity
				Composizione newComposizione = new Composizione();
				newComposizione.setIdProdotto(productId);
				newComposizione.setUsername(cliente.getUsername());
				newComposizione.setEmail(cliente.getEmail());
				//newComposizione.setQuantity(quantity);
				carrello.add(newComposizione);

			}
			System.out.println(carrello);
			session.setAttribute("carrello", carrello);
			response.sendRedirect(referer);
		}

	}

