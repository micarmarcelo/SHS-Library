package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Material;
import services.MaterialService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		ArrayList<Material> materials = new ArrayList<Material>();
		
		String searchInput = request.getParameter("search");
		System.out.println("FILTER BY: " + request.getParameter("filter"));
		int filter = Integer.parseInt(request.getParameter("filter"));
		System.out.println("SEARCH: " + searchInput);
		System.out.println("FILTER BY: " + filter);
		
		// 1 - Author 2 - Title 3 - Publisher
		
		
			try {
				if(filter == 1){
					System.out.println("WEW");
					materials = MaterialService.getMaterialByAuthor(searchInput);
					System.out.println("WEW SIZE: " + materials.size());
				}else if(filter == 2){
					System.out.println("WEW");
					materials = MaterialService.getMaterialByTitle(searchInput);
					System.out.println("WEW SIZE: " + materials.size());
				}
				else if(filter == 3){
					System.out.println("WEW");
					materials = MaterialService.getMaterialByPublisher(searchInput);
					System.out.println("WEW SIZE: " + materials.size());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("materials", materials);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
