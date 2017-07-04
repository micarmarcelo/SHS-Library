package beans;

public class Material {	
	private String materialID;
	private String title;
	private String author;
	private String publisher;
	private String year;
	private String tags;
	private String location;
	private String availableDate;
	private String returnDate;
	private String reservationDate;
	
	public Material(String materialID, String title, String author, String publisher, String year, String tags, String location) {
		super();
		this.materialID = materialID;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.tags = tags;
		this.location = location;
	}
	
	public Material(){}

	
	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
	
	
}
