package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.User;
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Username entered:" + email);
		System.out.println("Password entered:" + password);
		
		try {
			if(UsersService.validateUser(email, password)){
				Cookie usernameCookie = new Cookie("email", email);
				usernameCookie.setMaxAge(60*60*24);
				usernameCookie.setHttpOnly(true);
				response.addCookie(usernameCookie);
				
				HttpSession session = request.getSession();
				
				//put the user's info into session's attributes
				User user = UsersService.getUser(email);
				System.out.println(user.getUserID());
				if(session.getAttribute("email") == null){
					session.setAttribute("email", email);
					
					session.setAttribute("userID", user.getUserID());

					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("emailAddress", user.getEmailAddress());
				}
				
				System.out.println("Log-In::SUCCESS");
				//session.setAttribute("getAlert", "login");
				request.getRequestDispatcher("main.html").forward(request, response);
			}
			else{
				System.out.println("Log-In::FAILED");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
