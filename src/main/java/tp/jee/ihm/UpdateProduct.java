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

@WebServlet("/update")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int productId = Integer.parseInt(request.getParameter("productId"));

		User user = UserDAO.getUserById(userId);
		Product prod = ProductDAO.getProdById(productId);
		
		if(user != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("currentUser", user);
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
		} else {
			System.out.println("session issue");
			request.setAttribute("error", "You're not logged in");
		}
		
		if(prod != null) {
			System.out.println("product added to attribute");

			request.setAttribute("prod", prod);
			request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/listProducts").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("txtName");
		String description = request.getParameter("txtDescription");
		Float price = Float.parseFloat(request.getParameter("txtPrice"));
		Date updatedAt = new Date();
		
		int id = Integer.parseInt( request.getParameter("id") );
		User user = UserDAO.getUserById(id);
		
		Product p = new Product(name, user, description, price, updatedAt);
		
		if(ProductDAO.addProduct(p)) {
			System.out.println("Product added");
			request.getRequestDispatcher("/listProducts").forward(request, response);	
		} else {
			request.setAttribute("error", "Error at adding");
			doGet(request, response);
		}
	}

}
