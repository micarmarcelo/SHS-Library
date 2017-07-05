package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Material;
import beans.Review;
import services.MaterialService;
import services.ReviewService;

/**
 * Servlet implementation class ViewMaterialServlet
 */
@WebServlet("/ViewMaterialServlet")
public class ViewMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMaterialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Event's Info
				
				int materialID = Integer.parseInt(request.getParameter("materialID"));
				System.out.println(materialID);
				
				
				try {
					Material material;
					
					material = MaterialService.getMaterial(materialID);
					
					request.setAttribute("title", material.getTitle());
					request.setAttribute("author", material.getAuthor());
					request.setAttribute("publisher", material.getPublisher());
					request.setAttribute("year", material.getYear());
					request.setAttribute("tags", material.getTags());
					request.setAttribute("status", material.getStatus());
					request.setAttribute("location", material.getLocation());
					request.setAttribute("availableDate", material.getAvailableDate());
					request.setAttribute("returnDate", material.getReturnDate());
					request.setAttribute("reservationDate", material.getReservationDate());
					
					request.setAttribute("material", material);
					request.getRequestDispatcher("material-details.jsp").forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
//				//Get Event's Reviews
//				ArrayList<Review> reviewList = ReviewService.getAllReviews(Integer.parseInt(request.getParameter(Review.COLUMN_EVENTID)));
//				
//				System.out.println("reviewlist: " + reviewList);
//				request.setAttribute("reviewList", reviewList);
//				
//				//Get ID and Gender of the currently log in user
//				HttpSession session = request.getSession();
//				int userID = Integer.parseInt((String)session.getAttribute(RegisteredUser.COLUMN_USERID));
//				String gender = (String)session.getAttribute(RegisteredUser.COLUMN_GENDER);
//				
//				
//				request.setAttribute("currUserID", userID);
//				request.setAttribute("currUserGender", gender);
//				request.setAttribute("fullName", UsersService.getUsersFullName(event.getUserID()));
				
	}

}
