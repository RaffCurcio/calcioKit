package admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.DBConnection;
import dao.OrdineDAO;
import model.Cliente;
import model.Ordine;

@WebServlet("/AdminOrdinePage")

public class ServletOrdiniAdmin extends HttpServlet {

	private static final long serialVersionUID = 16L;
	private OrdineDAO orderDAO;
	private ClienteDAO userDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if (cliente != null) {

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
		try {
			List<Cliente> userList = userDAO.getAllUsers();
			List<Ordine> orderList = orderDAO.getAllOrdini();
			request.setAttribute("clienteList", userList);
			request.setAttribute("ordineList", orderList);

			request.getRequestDispatcher("admin/AdminOrdinesPage.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"An error occurred while retrieving cliente orders." + e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if (cliente != null) {

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
		try {

			List<Cliente> userList = userDAO.getAllUsers();

			List<Ordine> orderList = null;
			String selectedClienteId = request.getParameter("userId");
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty()
					&& selectedClienteId != null && !selectedClienteId.isEmpty()) {
				int userId = Integer.parseInt(selectedClienteId);

				java.sql.Date fromDateSql = java.sql.Date.valueOf(fromDate);
				java.sql.Date toDateSql = java.sql.Date.valueOf(toDate);
				orderList = orderDAO.getOrdini(fromDateSql, toDateSql, userId);
			} else if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty()) {
				java.sql.Date fromDateSql = java.sql.Date.valueOf(fromDate);
				java.sql.Date toDateSql = java.sql.Date.valueOf(toDate);
				orderList = orderDAO.getOrdini(fromDateSql, toDateSql);
			} else if (selectedClienteId != null && !selectedClienteId.isEmpty()) {


				orderList = orderDAO.getOrdineForUser(cliente.getUsername(),cliente.getEmail());
			} else {
				orderList = orderDAO.getAllOrdini();

			}

			request.setAttribute("clienteList", userList);
			request.setAttribute("ordineList", orderList);

			request.getRequestDispatcher("admin/AdminOrdinesPage.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"An error occurred while retrieving cliente orders." + e);
		}
	}

	@Override
	public void init() {
		userDAO = new ClienteDAO(DBConnection.getDataSource());
		orderDAO = new OrdineDAO(DBConnection.getDataSource());
	}

}
