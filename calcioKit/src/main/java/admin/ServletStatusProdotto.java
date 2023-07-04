package admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnection;
import dao.OrdineDAO;
import model.Cliente;

@WebServlet("/StatusProdotto")
public class ServletStatusProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdineDAO ordiniDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String status = request.getParameter("status");
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

		try {
			ordiniDAO.updateOrdine(status, orderId);
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
					"An error occurred while updating orders.");
			return;
		}
		response.sendRedirect("AdminOrdinePage");

	}

	@Override
	public void init() {
		ordiniDAO = new OrdineDAO(DBConnection.getDataSource());
	}
}
