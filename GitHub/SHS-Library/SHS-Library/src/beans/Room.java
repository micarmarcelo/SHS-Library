package beans;

public class Room {
	private String roomName;
	private String availability;
	
	
	public Room(String roomName, String availability) {
		super();
		this.roomName = roomName;
		this.availability = availability;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
