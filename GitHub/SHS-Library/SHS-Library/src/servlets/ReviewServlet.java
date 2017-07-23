package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Material;
import beans.Review;
import beans.User;
import services.MaterialService;
import services.ReviewService;
import services.UsersService;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
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
		
		try {
			User user = UsersService.getUser(request.getParameter("email"));
			
			Material material = MaterialService.getMaterial(Integer.parseInt(request.getParameter("materialID")));
			
			
			String message = request.getParameter("message");
			int rating = 0;
			if(request.getParameter("rating") != null){ //if may rating iparse
				rating = Integer.parseInt(request.getParameter("rating"));
			}
			
			Review review = new Review();
			review.setMessage(message);
			review.setRating(rating);
			
			if(message != "" || rating > 0){
				ReviewService.addReview(review, material, user);
			}

			request.setAttribute("materialID", request.getParameter("materialID"));
			request.getRequestDispatcher("ViewMaterialServlet").forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("event id from add review servlet " + request.getParameter("eventID"));
		
	}
}
