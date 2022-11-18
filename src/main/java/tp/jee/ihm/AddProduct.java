package tp.jee.ihm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.jee.dao.ProductDAO;
import tp.jee.dao.UserDAO;
import tp.jee.modele.Product;
import tp.jee.modele.User;

@WebServlet("/add")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.getAttribute("user_id");
		request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in POST");
		try {
			
			int user_id = (int) request.getSession().getAttribute("user_id");
			System.out.println("User id: " + user_id);
			User user = UserDAO.getUserById(user_id);
			
			String name = request.getParameter("txtName");
			String description = request.getParameter("txtDescription");
			Float price = Float.parseFloat(request.getParameter("txtPrice"));
			Date createdAt = new Date(System.currentTimeMillis());
			
			
			Product p = new Product(name, user, description, price, createdAt);
			
			if(ProductDAO.addProduct(p)) {
				System.out.println("Product added");
				request.getRequestDispatcher("/listProducts").forward(request, response);	
			} else {
				request.setAttribute("error", "Error at adding");
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			doGet(request, response);
		}
		
	}

}
