package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Prodotto;

@WebServlet({ "/Catalogo", "/AdminCatalogPage" })
public class ServletProdotti extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private ProdottoDAO prodottoDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String servletPath = request.getServletPath();

			if (servletPath.equals("/AdminCatalogPage")) {
				List<Prodotto> prodotti = prodottoDAO.getAllProdottiZoccolame();

				request.setAttribute("prodotti", prodotti);

				request.getRequestDispatcher("admin/AdminCatalogPage.jsp").forward(request, response);

			} else {
				List<Prodotto> prodotti = prodottoDAO.getAllProdotti();

				request.setAttribute("prodotti", prodotti);
				request.getRequestDispatcher("/Catalogo.jsp").forward(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {

		prodottoDAO = new ProdottoDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data
																		// source

	}

}