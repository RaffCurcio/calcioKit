package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComposizioneDAO;
import dao.DBConnection;
import model.Composizione;

@WebServlet({ "/logout", "/forceLogout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
	private ComposizioneDAO composizioneDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); // Retrieve the session (if it exists)
		String servletPath = request.getServletPath();

		if (servletPath.equals("/logout")) {
			if (session != null) {
				// Get the composiziones from the session
				@SuppressWarnings("unchecked")
				List<Composizione> composiziones = (List<Composizione>) session.getAttribute("carrello");

				// Save the composiziones to the database
				if (composiziones != null && !composiziones.isEmpty()) {
					try {
						// Assuming you have a method in ComposizioneDAO to save multiple cart items at once
						composizioneDAO.saveAllComposizioni(composiziones);
					} catch (SQLException e) {
						String errorMessage = "There was an error during the logout, your items in the cart didn't make it to the database\n"
								+ e;
						response.sendError(500, errorMessage);
						return;

					}
				}

			}

		} else if (servletPath.equals("forceLogout")) {
			session.invalidate();
			response.sendRedirect("Homepage.jsp");

			return;
		}
		session.invalidate(); // Invalidate the session

		response.sendRedirect("Homepage.jsp");

	}

	@Override
	public void init() throws ServletException {
		// Initialize the ComposizioneDAO instance
		composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource());
	}
}
