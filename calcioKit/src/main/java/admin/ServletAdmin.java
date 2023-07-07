package admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComposizioneDAO;
import dao.DBConnection;
import dao.ProdottoDAO;
import model.Cliente;
import model.Prodotto;

@WebServlet({ "/Update", "/Remove" })
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 15L;
	private ComposizioneDAO cartItemDAO;
	private ProdottoDAO productDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		HttpSession session = request.getSession();

		Cliente cliente = (Cliente) session.getAttribute("cliente");
		String sessionToken = ((String) session.getAttribute("sessionToken"));
		String clientToken = (request.getParameter("clientToken"));
		if (cliente != null) {
			if (!sessionToken.equals(clientToken)) {
				String errorMessage = "You are not logged in, please login";
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			if (!(cliente.getRuolo_cliente().equals("admin"))) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are not an admin.");
				return;
			}
		} else {
			String errorMessage = "You are not logged in, please login";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;

		}

		int productId = Integer.parseInt(request.getParameter("prodottoId"));

		if (servletPath.equals("/Remove")) {
			try {
				productDAO.toggleProductDeleted(productId);
				cartItemDAO.removeAllDeletedItems(productId);

			} catch (SQLException e) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						"An error occurred while removing product.");
				return;
			}
		}

		else if (servletPath.equals("/Update")) {
			try {
				String name = request.getParameter("name");
				String description = request.getParameter("description");
				BigDecimal price = new BigDecimal(request.getParameter("price"));
				double iva = Double.parseDouble(request.getParameter("iva"));
				String imagePath = request.getParameter("imagePath");
				boolean recommended = request.getParameter("recommended") != null;
				Prodotto existingProdotto = productDAO.getOrderProduct(productId);
				existingProdotto.setNomeProdotto(name);
				existingProdotto.setDescrizione(description);
				existingProdotto.setPrezzo(price);
				existingProdotto.setIva(iva);
				existingProdotto.setPath_immagine(imagePath);
				existingProdotto.setRaccomandato(recommended);
				
				productDAO.updateProdotto(existingProdotto);

			}

			catch (SQLException e) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						"An error occurred while updating product." + e);
				return;
			}
		}
		response.sendRedirect("AdminCatalogPage");

	}

	@Override
	public void init() {
		productDAO = new ProdottoDAO(DBConnection.getDataSource());
		cartItemDAO = new ComposizioneDAO(DBConnection.getDataSource());
	}

}
