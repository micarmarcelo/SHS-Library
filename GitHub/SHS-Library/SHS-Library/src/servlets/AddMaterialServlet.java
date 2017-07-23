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
import services.MaterialService;

/**
 * Servlet implementation class AddMaterialServlet
 */
@WebServlet("/AddMaterialServlet")
public class AddMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMaterialServlet() {
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
		// TODO Auto-generated method stub
//				HttpSession session = request.getSession();
				//get inputs from the user, make it an Event object
				
				//tell the service to add event service
				try {
					Material material = new Material();
					
					material.setTitle(request.getParameter("title"));
					material.setLocation(request.getParameter("location"));
					material.setAuthor(request.getParameter("author"));
					material.setPublisher(request.getParameter("publisher"));
					material.setYear(request.getParameter("year"));
					material.setTags(request.getParameter("tags"));
					material.setStatus(request.getParameter("status"));
					material.setAvailableDate(request.getParameter("availablilityDate"));
					material.setReturnDate(request.getParameter("returnDate"));
					material.setReservationDate(request.getParameter("reservationDate"));
					MaterialService.addMaterial(material);
					
					ArrayList<Material> materials = MaterialService.getAllMaterials();
					request.setAttribute("material", materials);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//redirect to profile
				//session.setAttribute("getAlert", "advertise");
				request.getRequestDispatcher("library.jsp").forward(request, response);
				
	}

}
