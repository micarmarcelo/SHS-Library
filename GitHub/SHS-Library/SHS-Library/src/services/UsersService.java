package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Review;
import beans.User;
import db.DBPool1;

public class UsersService {
	//this is a service class that contains
	//all the database helper methods for "users" Table
	
	public static final String USERID = "id_user";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String MIDDLE_INITIAL = "middle_initial";
	public static final String PASSWORD = "password";
	public static final String EMAIL_ADDRESS = "email";
	public static final String ES_NUMBER = "es_number";
	public static final String BIRTHDAY = "birthday";
	public static final String SECURITYIDQ1 = "id_question1";
	public static final String SECURITYIDQ2 = "id_question2";
	public static final String ANSWERQ1 = "answer_question1";
	public static final String ANSWERQ2 = "answer_question2";
	public static final String TYPE = "type";
	public static final String BORROW_HISTORY = "borrow_history";
	
	public static final String REVIEWED_BY = "reviewed_by";
	public static final String MATERIAL_ID = "material_id";
	public static final String RATING = "rating";
	public static final String MESSAGE = "message";
	public static final String REVIEW_DATE = "review_date";
	
	//dbhelper method add user
	public static void registerUser(User u) throws SQLException{		
		String sql = "INSERT INTO " + User.TABLE_NAME + "(" + User.COLUMN_USERTYPE + "," +
				  User.COLUMN_FIRSTNAME + "," + User.COLUMN_LASTNAME + "," +
				  User.COLUMN_MIDDLEINITIAL + "," + User.COLUMN_ESNUMBER + "," +
				  User.COLUMN_PASSWORD + "," + User.COLUMN_EMAILADDRESS + "," +
				  User.COLUMN_SECQ1 + "," + User.COLUMN_SECQ2  + "," +
				  User.COLUMN_ANSQ1 + "," + User.COLUMN_ANSQ2  + "," +
				  User.COLUMN_BIRTHDAY + "," + User.COLUMN_STATUS
				  +")" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		PreparedStatement pstmt = null;
		Connection con = DBPool1.getInstance().getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getType());
			pstmt.setString(2, u.getFirstName());
			pstmt.setString(3, u.getLastName());
			pstmt.setString(4, u.getMiddleInitial());
			pstmt.setString(5, u.getEsNumber());
			pstmt.setString(6, u.getPassword());
			pstmt.setString(7, u.getEmailAddress());
			pstmt.setInt(8, u.getSecurityQ1());
			pstmt.setInt(9, u.getSecurityQ2());
			pstmt.setString(10, u.getAnswerQ1());
			pstmt.setString(11, u.getAnswerQ2());
			pstmt.setString(12, u.getBirthday());
			pstmt.setString(13, u.getStatus());

			pstmt.executeUpdate();
			System.out.println("User is added succesfully in DB!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static boolean validateUser(String email, String password) throws SQLException{
		boolean isValid = false;
		
		String sql = "SELECT * FROM user where email = ? and password = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, email);
			pstat.setString(2, password);
			rs = pstat.executeQuery();
			isValid = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValid;
	}
	
	public static boolean validateEmailIDnum(String email_idnum) throws SQLException{
		boolean isValid = false;
		int userid = 0;
		
		/*SELECT *
		 * FROM users
		 * WHERE username = ? OR idnum = ?
		 */
		
		String sql = "SELECT " + User.COLUMN_USERID + " FROM " + User.TABLE_NAME + " WHERE " 
				+ User.COLUMN_EMAILADDRESS + " = ? OR " + User.COLUMN_ESNUMBER + " = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email_idnum);
			pstmt.setString(2, email_idnum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				userid = rs.getInt(User.COLUMN_USERID);
			}
			
			if(userid != 0){
				isValid = true;
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
		
		return isValid;
	}
	
	public static User getUserByEmailIDnum(String email_idnum) throws SQLException{
		
		/*SELECT *
		 * FROM users
		 * WHERE username = ? OR idnum = ?
		 */
		
		User user = null;
		
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE " 
				+ User.COLUMN_EMAILADDRESS + " = ? OR " + User.COLUMN_ESNUMBER + " = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email_idnum);
			pstmt.setString(2, email_idnum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){				
				user = new User();
				user.setUserID(rs.getString(User.COLUMN_USERID));
				user.setEsNumber(rs.getString(User.COLUMN_ESNUMBER));
				user.setPassword(rs.getString(User.COLUMN_PASSWORD));
				user.setLastName(rs.getString(User.COLUMN_LASTNAME));
				user.setMiddleInitial(rs.getString(User.COLUMN_MIDDLEINITIAL));
				user.setFirstName(rs.getString(User.COLUMN_FIRSTNAME));
				user.setEmailAddress(rs.getString(User.COLUMN_EMAILADDRESS));
				user.setType(rs.getString(User.COLUMN_USERTYPE));
				
//				user.setActive(rs.getInt(RegisteredUser.COLUMN_ACTIVE));
//				user.setBirthday(rs.getString(RegisteredUser.COLUMN_BIRTHDAY));
//				user.setSecretquestion(rs.getString(RegisteredUser.COLUMN_SECRETQUESTION));
//				user.setSecretquestion(rs.getString(RegisteredUser.COLUMN_SECRETANSWER));
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
		
		return user;
	}
	
	public static boolean isExisting(String email) throws SQLException{
		
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE " + 
						 User.COLUMN_EMAILADDRESS + " = '" + email + "'";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idMember = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				idMember = Integer.parseInt(rs.getString(User.COLUMN_USERID));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				pstmt.close();
				conn.close();
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(idMember==0)
			return false;
		else
			return true;	
	}
	
	public static User getUser(String email) throws SQLException{
		User user = null;
		
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE " + User.COLUMN_EMAILADDRESS
					 + " = '" + email + "'";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setUserID(rs.getString(User.COLUMN_USERID));
				user.setPassword(rs.getString(User.COLUMN_PASSWORD));
				user.setLastName(rs.getString(User.COLUMN_LASTNAME));
				user.setFirstName(rs.getString(User.COLUMN_FIRSTNAME));
				user.setEmailAddress(rs.getString(User.COLUMN_EMAILADDRESS));
				user.setType(rs.getString(User.COLUMN_USERTYPE));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return user;
	}
	
	public static String validateUserbyEmail(String email) throws SQLException{
		String password = "";
		
		String sql = "SELECT password FROM user where email = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()){
				password = rs.getString(User.COLUMN_PASSWORD);
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
		return password;
	}
	/****** PUBIES WERRRK 
//	 * @throws SQLException ******/
//	public static User getUser(String emailAdd) throws SQLException{
//		String sql = "SELECT * FROM user WHERE email = ?;";
//		String question = "SELECT * FROM questions WHERE id_questions = ? OR id_questions = ?;";
//		PreparedStatement pstmt = null;
//		PreparedStatement questions = null;
//		Connection con = DBPool1.getInstance().getConnection();
//		ResultSet r = null;
//		ResultSet q = null;
//		User u = null;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, emailAdd);
//			r = pstmt.executeQuery();
//			ArrayList<Integer> secquestions = new ArrayList<Integer>();
//			ArrayList<Review> reviews = new ArrayList<Review>();
//			ArrayList<Integer> materials = new ArrayList<Integer>();
//			int[] ids = new int[2];
//			while(r.next()){
//				questions = con.prepareStatement(question);
//				questions.setString(1, r.getString(SECURITYIDQ1));
//				questions.setString(2, r.getString(SECURITYIDQ2));
//				q = questions.executeQuery();
//				int i = 0;
//				while(q.next()){
//					int temp = q.getInt(2);
//					secquestions.add(temp);
//					ids[i]= q.getInt(1);
//					i++;
//				}
//				u = new User(
//						r.getString(FIRST_NAME),r.getString(MIDDLE_INITIAL),r.getString(LAST_NAME),r.getString(PASSWORD),
//						r.getString(EMAIL_ADDRESS),r.getString(ES_NUMBER),r.getString(BIRTHDAY),secquestions.get(0),
//						secquestions.get(1),r.getString(ANSWERQ1),r.getString(ANSWERQ2),r.getString(TYPE));
//				
//				r.getInt(USERID);
//				String reviewss = "SELECT * FROM reviews WHERE reviewed_by = '" + u.getEsNumber() + "'";
//				PreparedStatement reviewquery = con.prepareStatement(reviewss);
//				ResultSet reviewresults = reviewquery.executeQuery();
//				while(reviewresults.next()){
//					Review result = new Review(
//							reviewresults.getString(REVIEWED_BY),
//							reviewresults.getInt(RATING),
//							reviewresults.getString(MESSAGE),
//							reviewresults.getInt(MATERIAL_ID),
//							reviewresults.getString(REVIEW_DATE));
//					reviews.add(result);
//				}
////				String[] history = r.getString(BORROW_HISTORY).split(",");
////				for(int j = 0; j < history.length; j++){
////					int a = Integer.parseInt(history[j]);
////					materials.add(a);
////				}
////				u.setMaterialHistory(materials);
////				u.setReviews(reviews);
////				u.setSecurityQ1ID(ids[0]);
////				u.setSecurityQ2ID(ids[1]);
////				System.out.println(u.getBirthday());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return u;
//	}
	
	
	public static boolean updateUser(User user) throws SQLException{
		boolean isUpdateSuccess = false;
		//first_name, last_name, middle_initial, es_number, password, email, id_question1, id_question2, answer_question1, answer_question2, birthday
		/** Get all new info of the user**/
		String newFirstName = user.getFirstName();
		String newLastName = user.getLastName();
		String newInitial = user.getMiddleInitial();
		String newESNum = user.getEsNumber();
		String newPassword = user.getPassword();
		String newEmail = user.getEmailAddress();
		int newIDQ1 = user.getSecurityQ1();
		int newIDQ2 = user.getSecurityQ2();
		String newA1 = user.getAnswerQ1();
		String newA2 = user.getAnswerQ2();
		String newBirthday = user.getBirthday();
		
		String sql = "UPDATE "+ User.TABLE_NAME + " SET " + User.COLUMN_FIRSTNAME + "=?, " +
				User.COLUMN_LASTNAME + "=?, " +
				User.COLUMN_MIDDLEINITIAL + "=?, " + 
				User.COLUMN_ESNUMBER + "=?, " + 
				User.COLUMN_PASSWORD + "=?, " +
				User.COLUMN_EMAILADDRESS + "=?, "+
				User.COLUMN_SECQ1 + "=?, " +
				User.COLUMN_SECQ2 + "=?, " +
				User.COLUMN_ANSQ1 + "=?, " +
				User.COLUMN_ANSQ2 + "=?, " +
				User.COLUMN_BIRTHDAY + "=?"+ " WHERE " +
				User.COLUMN_USERID + "=? ";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, newFirstName);
			pstat.setString(2, newLastName);
			pstat.setString(3, newInitial);
			pstat.setString(4, newESNum);
			pstat.setString(5, newPassword);
			pstat.setString(6, newEmail);
			pstat.setInt(7, newIDQ1);
			pstat.setInt(8,  newIDQ2);
			pstat.setString(9, newA1);
			pstat.setString(10, newA2);
			pstat.setString(11, newBirthday);
			pstat.setString(12, user.getUserID());
			
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
	
	
	public static String getUsersFullName(String userID) throws SQLException{
		String fullName = "";
		
		String sql = "SELECT "+ User.COLUMN_FIRSTNAME + ", " + User.COLUMN_LASTNAME 
				 	+ " FROM " + User.TABLE_NAME + " WHERE " + User.COLUMN_USERID  + " = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, userID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				fullName += rs.getString(User.COLUMN_FIRSTNAME) + " ";
				fullName += rs.getString(User.COLUMN_LASTNAME);
			}
			System.out.println("GOT USER'S FULLNAME::SUCCESS");
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
		
		
		return fullName;
	}
	
	public static boolean checkPasswordIfUnique(String password) throws SQLException{
		boolean isUnique = false;
		//SELECT userid
		//FROM users
		//WHERE password = ?
		
		String sql = "SELECT " + User.COLUMN_USERID + " FROM " + User.TABLE_NAME 
				+ " WHERE " + User.COLUMN_PASSWORD + " = ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, password);
			
			rs = pstat.executeQuery();
			
			if(rs.next() == false){
				isUnique = true;
			}
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
		
		return isUnique;
	}
	
	public static boolean changePassword(String email, String password) throws SQLException{
		boolean isUpdateSuccess = false;
		
		String sql = "UPDATE "+ User.TABLE_NAME + " SET " + User.COLUMN_PASSWORD 
					+ "=? WHERE " + User.COLUMN_EMAILADDRESS + "= ?";
		
		Connection conn = DBPool1.getInstance().getConnection();
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, password);
			pstat.setString(2, email);
			
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
}
