package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import beans.Room;
import beans.RoomReservation;
import beans.User;
import db.DBPool1;

public class RoomService {
	public static final String RESERVATION_TABLE = "room_reservation";
	
	public void reserveRoom(User u, String timeStart, String timeEnd, Date dateReserved, String roomNumber) throws SQLException{
		String sql = "INSERT INTO " + RESERVATION_TABLE + "`room_id`," + "`startTimeReserved`," + "`endTimeReserved`,"
				+ "+ `dateReserved`," + "`user_id`) VALUES (?,?,?,?,?);";
		PreparedStatement pstmt = null;
		Connection con = DBPool1.getInstance().getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,roomNumber);
			pstmt.setString(2, timeStart);
			pstmt.setString(3, timeEnd);
			pstmt.setDate(4, dateReserved);
			pstmt.setInt(5, Integer.parseInt(u.getEsNumber()));
			
			pstmt.executeUpdate();
			System.out.println("User has succesfully reserved room: "+ roomNumber);
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
	
	public ArrayList<RoomReservation> getAllReservations() throws SQLException{
		
		ArrayList<RoomReservation> reservations = new ArrayList<RoomReservation>();
		String sql = "SELECT * FROM room_reservation;";
		PreparedStatement pstmt = null;
		ResultSet r = null;
		Connection con = DBPool1.getInstance().getConnection();
		try {
			
			pstmt = con.prepareStatement(sql);
			r = pstmt.executeQuery();
			RoomReservation room = null;
			while(r.next()){
				room = new RoomReservation(r.getString(room.COLUMN_ROOMID),
						r.getString(room.COLUMN_TIMESTART),
						r.getString(room.COLUMN_TIMEEND),
						r.getDate(room.COLUMN_DATERESERVED),
						Integer.parseInt(r.getString(room.COLUMN_USERID))
						);
				reservations.add(room);
			}
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
		return reservations;
	}
	
	public ArrayList<RoomReservation> getReservedByUser(User u) throws SQLException{
		ArrayList<RoomReservation> reservations = new ArrayList<RoomReservation>();
		String sql = "SELECT * FROM room_reservation WHERE user_id = ?";
		PreparedStatement pstmt = null;
		ResultSet r = null;
		Connection con = DBPool1.getInstance().getConnection();
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getEsNumber());
			r = pstmt.executeQuery();
			RoomReservation room = null;
			while(r.next()){
				room = new RoomReservation(r.getString(room.COLUMN_ROOMID),
						r.getString(room.COLUMN_TIMESTART),
						r.getString(room.COLUMN_TIMEEND),
						r.getDate(room.COLUMN_DATERESERVED),
						Integer.parseInt(r.getString(room.COLUMN_USERID))
						);
				reservations.add(room);
			}
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
		return reservations;
	}
	
	public void deleteRoomReservation(RoomReservation r) throws SQLException{
		String sql = "DELETE FROM `librarysystem`.`room_reservation` WHERE startTimeReserved = ?"
				+ " AND endTimeReserved = ? AND dateReserved = ?;";
		PreparedStatement pstmt = null;
		Connection con = DBPool1.getInstance().getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getTimeStart());
			pstmt.setString(2, r.getTimeEnd());
			pstmt.setDate(3, r.getDateReserved());
			
			pstmt.executeUpdate();
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
	
	public RoomReservation updateRoomReservation(RoomReservation r, String newUserID, String newStartTime, String newEndTime, String newDate){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		String sql = "UPDATE `librarysystem`.`room_reservation` SET `startTimeReserved` = ?, `endTimeReserved` = ?, "
				+ "`dateReserved` = ?, `user_id` = ? WHERE `startTimeReserved` = ? AND `endTimeReserved` = ? AND "
				+ "`dateReserved` = ? AND `user_id` = ? AND room_id = ?;";
		PreparedStatement pstmt = null;
		try {
			date = (Date) df.parse(newDate);
			
			Connection con = DBPool1.getInstance().getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newStartTime);
			pstmt.setString(2, newEndTime);
			pstmt.setDate(3, date);
			pstmt.setInt(4, Integer.parseInt(newUserID));
			pstmt.setString(5,r.getTimeStart());
			pstmt.setString(6, r.getTimeEnd());
			pstmt.setDate(7, r.getDateReserved());
			pstmt.setInt(8, r.getUserID());
			pstmt.setString(9, r.getRoomID());
			
			pstmt.executeUpdate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.setTimeStart(newStartTime);
		r.setTimeEnd(newEndTime);
		r.setUserID(Integer.parseInt(newUserID));
		r.setDateReserved(date);
		
		return r;
		
	}
}
