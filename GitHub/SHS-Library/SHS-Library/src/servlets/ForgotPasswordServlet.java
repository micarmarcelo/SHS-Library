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

import beans.AESencrp;
import beans.User;
import services.UsersService;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
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
		String email_idnum = request.getParameter("input_email_idnumber");
		
		try {
			System.out.println(UsersService.validateEmailIDnum(email_idnum));
			
			HttpSession session = request.getSession();
			
			//put the user's info into session's attributes
			User user = UsersService.getUserByEmailIDnum(email_idnum);
			session.setAttribute(User.COLUMN_EMAILADDRESS, user.getEmailAddress());
			session.setAttribute(User.COLUMN_USERID, user.getEsNumber());
			
			if(UsersService.validateEmailIDnum(email_idnum)){
				request.getRequestDispatcher("NewPassword.jsp").forward(request, response);
				System.out.println("VALID USERNAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}