package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Material;
import db.DBPool1;

public class MaterialService {
	
	public static void addMaterial(Material m) throws SQLException{
/**	INSERT INTO materials(location, author, publisher, year, tags, 
		status, availabilityDate) VALUES() **/
		
		String sql = "INSERT INTO " + Material.TABLE_NAME + " (" + Material.COLUMN_TITLE + ", "
				+ Material.COLUMN_LOCATION + ", "+ Material.COLUMN_AUTHOR + ", " 
				+ Material.COLUMN_PUBLISHER + ", "	+ Material.COLUMN_YEAR + ", " 
				+ Material.COLUMN_TAGS + ", " 
				+ Material.COLUMN_STATUS + ", " + Material.COLUMN_AVAILDATE + ") "
				+ "VALUES (?,?,?,?,?,?,?, CURDATE());";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getLocation());
			pstmt.setString(3, m.getAuthor());
			pstmt.setString(4,  m.getPublisher());
			pstmt.setString(5,  m.getYear());
			pstmt.setString(6,  m.getTags());
			pstmt.setString(7,  m.getStatus());
			
			pstmt.executeUpdate();
			
			System.out.println("ADD MATERIAL SERVICE::SUCCESS!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
	
	public static Material getMaterial(int materialID) throws SQLException{
		Material material = new Material();
		
		/*SELECT *
		 *FROM event_service
		 *WHERE userID = ?;
		*/
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME + " WHERE " + Material.COLUMN_MATERIALID + "=? ";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, materialID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				
			}
			System.out.println("VIEW-BOOKMAT-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return material;
	}
	
	public static boolean updateMaterial(Material material) throws SQLException{
		boolean isUpdateSuccess = false;
		

//id_material, title, location, author, publisher, year, tags, status, availabilityDate, returnDate, reservationDate, user_id
		
		/** Get all new info of the user**/
		String newTitle = material.getTitle();
		String newLocation = material.getLocation();
		String newAuthor = material.getAuthor();
		String newPublisher = material.getPublisher();
		String newYear = material.getYear();
		String newTags = material.getTags();
		String newStatus = material.getStatus();
		String newAvailDate = material.getAvailableDate();
		String newReturnDate = material.getReturnDate();
		String newReserveDate = material.getReservationDate();
		
		String sql = "UPDATE "+ Material.TABLE_NAME + " SET " + Material.COLUMN_TITLE + "=?, " +
				Material.COLUMN_LOCATION + "=?, " +
				Material.COLUMN_AUTHOR + "=?, " + 
				Material.COLUMN_PUBLISHER + "=?, " + 
				Material.COLUMN_YEAR + "=?, " +
				Material.COLUMN_TAGS + "=?, "+
				Material.COLUMN_STATUS + "=?, " +
				Material.COLUMN_AVAILDATE + "=?, " +
				Material.COLUMN_RETURNDATE + "=?, " +
				Material.COLUMN_RESERVEDATE + "=?"+ " WHERE " +
				Material.COLUMN_MATERIALID + "=? ";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, newTitle);
			pstat.setString(2, newLocation);
			pstat.setString(3, newAuthor);
			pstat.setString(4, newPublisher);
			pstat.setString(5, newYear);
			pstat.setString(6, newTags);
			pstat.setString(7, newStatus);
			pstat.setString(8, newAvailDate);
			pstat.setString(9, newReturnDate);
			pstat.setString(10, newReserveDate);			
			pstat.setString(11, material.getMaterialID());
			
			pstat.executeUpdate();
			
			System.out.println("UPDATE IN DB::SUCCESS!");
			isUpdateSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isUpdateSuccess;
		
	}

	public static boolean reserveMaterial(int materialID) throws SQLException{
		boolean isUpdateSuccess = false;
				
				String newStatus = "Not Available";
				
				String sql = "UPDATE "+ Material.TABLE_NAME + " SET " +
						Material.COLUMN_STATUS + "=?"+ " WHERE " +
						Material.COLUMN_MATERIALID + "=? ";
				
				Connection conn = DBPool1.getInstance().getConnection();
				PreparedStatement pstat = null;
				
				try {
					pstat = conn.prepareStatement(sql);
					pstat.setString(1, newStatus);		
					pstat.setInt(2, materialID);
					
					pstat.executeUpdate();
					
					System.out.println("UPDATE IN DB::SUCCESS!");
					isUpdateSuccess = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						pstat.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return isUpdateSuccess;
	}
	public static boolean deleteMaterial(int materialID) throws SQLException{
		boolean isDeleteSuccess = false;
		
		String sql = "DELETE FROM " + Material.TABLE_NAME
				+ " WHERE " + Material.COLUMN_MATERIALID + " =?;";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, materialID);
			
			pstat.executeUpdate();
			
			System.out.println("DELETE IN DB::SUCCESS!");
			isDeleteSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isDeleteSuccess;
		
	}
	
	public static ArrayList<Material> getAllMaterials() throws SQLException{
		ArrayList<Material> materials = new ArrayList<Material>();
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME + " ORDER BY " + Material.COLUMN_MATERIALID + " desc;";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				materials.add(material);
			}
			System.out.println("VIEW-BOOKMAT-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return materials;
	}

//	SELECT * FROM librarysystem.materials
//	WHERE tags = "Magazine";
	public static ArrayList<Material> getBookMaterial() throws SQLException{
		ArrayList<Material> books = new ArrayList<Material>();
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME 
				+ " WHERE " +  Material.COLUMN_TAGS + " = 'Book';";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				books.add(material);
			}
			System.out.println("VIEW-BOOKMAT-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}

	public static ArrayList<Material> getMagazineMaterial() throws SQLException{
		ArrayList<Material> magazines = new ArrayList<Material>();
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME 
				+ " WHERE " +  Material.COLUMN_TAGS + " = 'Magazine';";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				magazines.add(material);
			}
			System.out.println("VIEW-MAGMAT-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return magazines;
	}
	
	public static ArrayList<Material> getThesisMaterial() throws SQLException{
		ArrayList<Material> theses = new ArrayList<Material>();
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME 
				+ " WHERE " +  Material.COLUMN_TAGS + " = 'Thesis';";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				theses.add(material);
			}
			System.out.println("VIEW-THESISMAT-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return theses;
	}
	
	public static ArrayList<Material> getMaterialByTitle(String name) throws SQLException{
		ArrayList<Material> materials = new ArrayList<>();
		
		String searchName = "\""+ "%" + name+ "%" + "\"";
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME + " WHERE " + Material.COLUMN_TITLE + " LIKE " + searchName;
		
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				materials.add(material);
			}
			System.out.println("VIEW-MATBYAUTHOR-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return materials;
	}
	
	public static ArrayList<Material> getMaterialByAuthor(String name) throws SQLException{
		ArrayList<Material> materials = new ArrayList<>();
		
		String searchName = "\""+ "%" + name+ "%" + "\"";
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME + " WHERE " + Material.COLUMN_AUTHOR + " LIKE " + searchName;
		
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				materials.add(material);
			}
			System.out.println("VIEW-MATBYAUTHOR-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return materials;
	}
	
	public static ArrayList<Material> getMaterialByPublisher(String name) throws SQLException{
		ArrayList<Material> materials = new ArrayList<>();
		
		String searchName = "\""+ "%" + name+ "%" + "\"";
		
		String sql = "SELECT * FROM " + Material.TABLE_NAME + " WHERE " + Material.COLUMN_PUBLISHER + " LIKE " + searchName;
		
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Material material = new Material();
				material.setMaterialID(rs.getString(Material.COLUMN_MATERIALID));
				material.setTitle(rs.getString(Material.COLUMN_TITLE));
				material.setLocation(rs.getString(Material.COLUMN_LOCATION));
				material.setAuthor(rs.getString(Material.COLUMN_AUTHOR));
				material.setPublisher(rs.getString(Material.COLUMN_PUBLISHER));
				material.setYear(rs.getString(Material.COLUMN_YEAR));
				material.setTags(Material.COLUMN_TAGS);
				material.setStatus(Material.COLUMN_STATUS);
				material.setAvailableDate(Material.COLUMN_AVAILDATE);
				material.setReturnDate(Material.COLUMN_RETURNDATE);
				material.setReservationDate(Material.COLUMN_RESERVEDATE);
	
				materials.add(material);
			}
			System.out.println("VIEW-MATBYPUB-SERVICE::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return materials;
	}
	
	
}
