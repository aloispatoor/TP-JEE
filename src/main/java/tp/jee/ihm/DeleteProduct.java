package tp.jee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.jee.dao.ProductDAO;

@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt( request.getParameter("id") );
		
		if (ProductDAO.deleteProduct(id)) {
			System.out.println("Product removed");
		} else {
			request.setAttribute("error", "Error at deleting");
		}
		
		request.getRequestDispatcher("/listProducts").forward(request, response);
	}


}
