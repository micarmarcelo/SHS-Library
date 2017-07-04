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
		
		String sql = "INSERT INTO " + Material.TABLE_NAME + " (" + Material.COLUMN_LOCATION
				+ Material.COLUMN_AUTHOR + ", " + Material.COLUMN_PUBLISHER + ", "
				+ Material.COLUMN_YEAR + ", " + Material.COLUMN_TAGS + ", " 
				+ Material.COLUMN_STATUS + ", " + Material.COLUMN_AVAILDATE + ") "
				+ "VALUES (?,?,?,?,?,?,?);";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getLocation());
			pstmt.setString(2, m.getAuthor());
			pstmt.setString(3,  m.getPublisher());
			pstmt.setString(4,  m.getYear());
			pstmt.setString(5,  m.getTags());
			pstmt.setString(6,  m.getStatus());
			pstmt.setString(7, m.getAvailableDate());
			pstmt.executeUpdate();
			
			System.out.println("ADVERTISE EVENT SERVICE::SUCCESS!");
			
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
			System.out.println("VIEW-EVENT-SERVICE::SUCCESS");
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
			System.out.println("VIEW-EVENT-SERVICE::SUCCESS");
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
	
	
}
