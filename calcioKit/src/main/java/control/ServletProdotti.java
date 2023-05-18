package control;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Prodotto;

@WebServlet("/Catalogo")
public class ServletProdotti extends HttpServlet {
    private static final long serialVersionUID = 2L;
    private ProdottoDAO prodottoDAO;
    public void init() {
        // Initialize the UserDAO instance
    	
    	prodottoDAO = new ProdottoDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source
    	
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	// Recupera tutti i prodotti dal database
        	
        	List<Prodotto> prodotti = prodottoDAO.getAllProdotti();

        	// Passa i prodotti alla pagina catalogo.jsp
        	request.setAttribute("prodotti", prodotti);
        	request.getRequestDispatcher("/Catalogo.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately or display an error page
        }
    }

}