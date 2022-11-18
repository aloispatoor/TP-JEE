package tp.jee.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.jee.dao.UserDAO;
import tp.jee.modele.User;

@WebServlet("/signin")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession( true ); 

		
		String email = (String) session.getAttribute("email");
		String login = (String) session.getAttribute("login");
		String password = (String) session.getAttribute("password");
		String confirmation = (String) session.getAttribute("confirmation");
		
		if ( email == null) session.setAttribute("email", "");
		if ( login == null) session.setAttribute("login", "");
		if ( password == null) session.setAttribute("password", "");
		if ( confirmation == null) session.setAttribute("confirmation", "");
		
		request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password =request.getParameter("txtPassword");
		String confirmation = request.getParameter("txtPasswordConfirmation");
		
		if (UserDAO.isValidUser(email, login, password, confirmation)) {			
			User u = new User(email, login, password);
			System.out.println("isValidUser");
			
			if (UserDAO.createUser(u)) {
				request.getRequestDispatcher("/login").forward(request, response);			
			} else {
				request.setAttribute("error", "Connexion Error");
				doGet(request, response);
			}
			
		} else {
			request.setAttribute("error", "Incorrect inputs");
			request.setAttribute("email", email);
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.setAttribute("confirmation", confirmation);
			doGet(request, response);
		}
	}

}
