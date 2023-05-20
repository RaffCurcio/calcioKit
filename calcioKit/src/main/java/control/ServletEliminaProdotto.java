package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import dao.ComposizioneDAO;
import dao.DBConnection;
import model.Cliente;
import model.Composizione;
@WebServlet("/ServletEliminaProdotto")
public class ServletEliminaProdotto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ComposizioneDAO composizioneDAO;

    @Override
    public void init() {
        composizioneDAO = new ComposizioneDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera i parametri dalla richiesta
        String idProdottoString = request.getParameter("idProdotto");

        // Controlla se l'ID del prodotto è stato fornito
        if (idProdottoString != null) {
            int idProdotto = Integer.parseInt(idProdottoString);

            // Recupera il cliente dalla sessione
            HttpSession session = request.getSession();
            Cliente cliente = (Cliente) session.getAttribute("cliente");

            // Rimuovi il prodotto dal carrello nella sessione
            List<Composizione> carrello = (List<Composizione>) session.getAttribute("carrello");
            if (carrello != null) {
                carrello.removeIf(composizione -> composizione.getIdProdotto() == idProdotto);
                session.setAttribute("carrello", carrello);
            }

            // Rimuovi il prodotto dal carrello nel database
            try {
                composizioneDAO.removeComposizione(cliente.getUsername(), cliente.getEmail(), idProdotto);
            } catch (SQLException e) {
                response.sendRedirect("error.jsp");
                return;
            }

            // Reindirizza alla pagina del carrello
            response.sendRedirect("Cart.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
