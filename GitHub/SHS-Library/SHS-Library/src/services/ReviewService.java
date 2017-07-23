package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Material;
import beans.Review;
import beans.User;
import db.DBPool1;

public class ReviewService {
	
/*INSERT INTO reviews (reviewed_by, material_id, rating, message, review_date)
	VALUES ( (SELECT CONCAT(U.first_name , " ", U.last_name) 
	FROM user U WHERE U.id_user = 1), 1, 4, "Amazing book! I was so hooked", NOW());*/

	public static void addReview(Review r, Material m, User u) throws SQLException{
		String sql = "INSERT INTO " + Review.TABLE_NAME +
				" (" + Review.COLUMN_REVIEWEDBY + ", " + Review.COLUMN_MATERIALID + ", "
				+ Review.COLUMN_RATING + ", " + Review.COLUMN_MESSAGE + ", "
				+ Review.COLUMN_REVIEWDATE + ")" 
				+ " VALUES ( (SELECT CONCAT(?,' ',?) FROM " + User.TABLE_NAME + " WHERE "
				+ User.COLUMN_USERID + " = ?), ?,?,?,CURDATE());";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Patrick");
			pstmt.setString(2, "Arceo");
			pstmt.setString(3, "1");
			pstmt.setString(4, m.getMaterialID());
			pstmt.setInt(5, r.getRating());
			pstmt.setString(6, r.getMessage());
			pstmt.executeUpdate();
			
			System.out.println("ADD REVIEW:: SUCCESS!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Review> getAllReviews(int materialID) throws SQLException{
			ArrayList<Review> reviewList = new ArrayList<>();
			
			String sql = "SELECT * FROM " + Review.TABLE_NAME + " WHERE material_id = ? ORDER BY " 
							+ Review.COLUMN_REVIEWDATE + " DESC";
			
			Connection conn = DBPool1.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, materialID);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Review r = new Review();
					r.setReviewedBy(rs.getString(Review.COLUMN_REVIEWEDBY));
					r.setRating(rs.getInt(Review.COLUMN_RATING));
					r.setMessage(rs.getString(Review.COLUMN_MESSAGE));
					r.setMaterialID(rs.getInt(Review.COLUMN_MATERIALID));
					r.setReviewDate(rs.getString(Review.COLUMN_REVIEWDATE));
					reviewList.add(r);
					System.out.println(r.getMessage());
				}
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
			
			
			return reviewList;
		}
		
		
	}

