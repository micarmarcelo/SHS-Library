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
 * Servlet implementation class EditMaterialServlet
 */
@WebServlet("/EditMaterialServlet")
public class EditMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMaterialServlet() {
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
		//get the input of the user
				//create Registered User from the input
				
			int materialID = Integer.parseInt(request.getParameter("materialID"));
			
			try {
				Material material;
				
				material = MaterialService.getMaterial(materialID);
				request.setAttribute("materialID", material.getMaterialID());
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
			
				request.getRequestDispatcher("editMaterial.jsp").forward(request, response);
				
				System.out.println(title);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
