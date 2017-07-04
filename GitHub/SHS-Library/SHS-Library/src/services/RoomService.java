package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
