package beans;

import java.sql.Date;

public class RoomReservation {
	public static final String COLUMN_ROOMID = "room_id";
	public static final String COLUMN_TIMESTART = "startTimeReserved";
	public static final String COLUMN_TIMEEND = "endTimeReserved";
	public static final String COLUMN_DATERESERVED = "dateReserved";
	public static final String COLUMN_USERID = "user_id";
	
	private String roomID;
	private String timeStart;
	private String timeEnd;
	private Date dateReserved;
	private int userID;
	
	public RoomReservation(String roomID, String timeStart, String timeEnd, Date dateReserved, int userID) {
		this.roomID = roomID;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.dateReserved = dateReserved;
		this.userID = userID;
	}
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Date getDateReserved() {
		return dateReserved;
	}
	public void setDateReserved(Date dateReserved) {
		this.dateReserved = dateReserved;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
