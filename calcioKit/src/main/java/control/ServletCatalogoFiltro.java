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

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Prodotto;

@WebServlet({ "/FilterCatalog", "/FilterCatalogAdmin" })
public class ServletCatalogoFiltro extends HttpServlet {
	private static final long serialVersionUID = 11L;
	private ProdottoDAO prodottoDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();

		String minPriceParam = request.getParameter("minPrice");
		String maxPriceParam = request.getParameter("maxPrice");
		List<Prodotto> filteredProdottos;
		try {
			if (servletPath.equals("/FilterCatalog")) {
				if (minPriceParam != null && maxPriceParam != null) {
					BigDecimal minPrice = new BigDecimal(minPriceParam);
					BigDecimal maxPrice = new BigDecimal(maxPriceParam);
					filteredProdottos = prodottoDAO.getAllProdotti(minPrice, maxPrice);
				} else {
					filteredProdottos = prodottoDAO.getAllProdotti();
				}

				request.setAttribute("prodotti", filteredProdottos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.jsp");
				dispatcher.forward(request, response);

			} else if (servletPath.equals("/FilterCatalogAdmin")) {
				if (minPriceParam != null && maxPriceParam != null) {
					BigDecimal minPrice = new BigDecimal(minPriceParam);
					BigDecimal maxPrice = new BigDecimal(maxPriceParam);
					filteredProdottos = prodottoDAO.getAllProdottiZoccolame(minPrice, maxPrice);
				} else {
					filteredProdottos = prodottoDAO.getAllProdottiZoccolame();
				}

				request.setAttribute("prodotti", filteredProdottos);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin/AdminCatalogPage.jsp");
				dispatcher.forward(request, response);

			}

		} catch (NumberFormatException e) {
			String errorMessage = "There was an error in filtering your catalog, invalid number found, try again";
			response.sendError(500, errorMessage);
		} catch (SQLException e) {
			String errorMessage = "There was an error in filtering your catalog, try again";
			response.sendError(500, errorMessage);

		}
	}

	@Override
	public void init() {
		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource());
	}

}
