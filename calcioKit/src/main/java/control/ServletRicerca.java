package control;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Composizione;
import model.Prodotto;
@WebServlet("/ServletRicerca")

public class ServletRicerca extends HttpServlet {
	private ProdottoDAO prodottoDAO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ricerca = request.getParameter("ricerca");
		Prodotto prodotto = null;
		try {
		 prodotto = prodottoDAO.getProdottoByName(ricerca);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("prodotto", prodotto);

		// Reindirizza alla pagina di descrizione del prodotto
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProdottoDescrizione.jsp");
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
