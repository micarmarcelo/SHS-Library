package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AESencrp;
import beans.User;
import services.UsersService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		//tell the service to add user
		try {
			User user = new User();
			user.setType(request.getParameter(User.COLUMN_USERTYPE));
			user.setLastName(request.getParameter(User.COLUMN_LASTNAME));
			user.setMiddleInitial(request.getParameter(User.COLUMN_MIDDLEINITIAL));
			user.setFirstName(request.getParameter(User.COLUMN_FIRSTNAME));
			user.setEmailAddress(request.getParameter(User.COLUMN_EMAILADDRESS));
			user.setPassword(request.getParameter(User.COLUMN_PASSWORD));
			user.setEsNumber(request.getParameter(User.COLUMN_ESNUMBER));
			user.setBirthday(request.getParameter(User.COLUMN_BIRTHDAY));
			user.setSecurityQ1(Integer.parseInt(request.getParameter(User.COLUMN_SECQ1)));
			user.setSecurityQ2(Integer.parseInt(request.getParameter(User.COLUMN_SECQ2)));
			user.setAnswerQ1(request.getParameter(User.COLUMN_ANSQ1));
			user.setAnswerQ2(request.getParameter(User.COLUMN_ANSQ2));
			user.setStatus(request.getParameter(User.COLUMN_STATUS));

			String password = request.getParameter(User.COLUMN_PASSWORD);
			
						
			//Encrypt the password
			try {
				System.out.println("ENCRYPT!");
				user.setPassword(AESencrp.encrypt(password));
				System.out.println("Encryption success!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Encryption failed!");
			}
			
			//Check if username and email is already registered
			if(UsersService.isExisting(user.getEmailAddress()) == false){
				UsersService.registerUser(user);
				System.out.println("USER REGISTERED!!" + user.getEsNumber());
			}
			
			
			User newUser = UsersService.getUser(user.getEmailAddress());

			//make a session
			HttpSession session = request.getSession();
			session.setAttribute("email", newUser.getEmailAddress());
			session.setAttribute("es_number", newUser.getEsNumber());
			session.setAttribute("id_user", newUser.getUserID());
			session.setAttribute("last_name", newUser.getLastName());
			session.setAttribute("first_name", newUser.getFirstName());
			session.setAttribute("middle_initial", newUser.getMiddleInitial());
			session.setAttribute("userType", newUser.getType());
			session.setAttribute("birthday", newUser.getBirthday());
			
			System.out.println("SIGN-UP::SUCCESS");
			
			//redirect to homepage
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOGIN::FAILED");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
			e.printStackTrace();
		}	
		
	}

}
