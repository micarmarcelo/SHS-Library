package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AESencrp;
import beans.Material;
import beans.User;
import services.MaterialService;
import services.UsersService;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String decryptedPassword = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Email entered:" + email);
		System.out.println("Password entered:" + password);
		
		try {
			decryptedPassword = AESencrp.decrypt(UsersService.validateUserbyEmail(email));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			if(password != null && password.equals(decryptedPassword)){
				Cookie emailCookie = new Cookie("email", email);
				emailCookie.setMaxAge(60*60*24);
				emailCookie.setHttpOnly(true);
				response.addCookie(emailCookie);
				
				HttpSession session = request.getSession();
				
				//put the user's info into session's attributes
				User user = UsersService.getUser(email);
				//System.out.println(user.getUserID());
				if(session.getAttribute("email") == null){
					session.setAttribute("email", email);
					
					session.setAttribute("userID", user.getUserID());

					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("emailAddress", user.getEmailAddress());
					session.setAttribute("type", user.getType());
				}
				
				System.out.println("Log-In::SUCCESS");
				System.out.println("type:" +user.getType());
				//session.setAttribute("getAlert", "login");
				
				ArrayList<Material> material = MaterialService.getAllMaterials();
				request.setAttribute("material", material);

				if(user.getType().equals("admin")){
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}else if(user.getType().equals("manager") || user.getType().equals("staff")){
					System.out.println("type" +user.getType());
					request.getRequestDispatcher("library.jsp").forward(request, response);
				}else if(user.getType().equals("student") || user.getType().equals("employee")){
					System.out.println("type" +user.getType());
					request.getRequestDispatcher("main.jsp").forward(request, response);
				}
			}
			else{
				System.out.println("Log-In::FAILED");
				request.setAttribute("errorMessage","Invalid username or password.");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
