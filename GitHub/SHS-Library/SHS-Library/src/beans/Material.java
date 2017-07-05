package beans;

public class Material {	
	public static final String TABLE_NAME = "materials";
	public static final String COLUMN_MATERIALID = "id_materials";
	public static final String COLUMN_LOCATION = "location";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_PUBLISHER = "publisher";
	public static final String COLUMN_YEAR = "year";
	public static final String COLUMN_TAGS = "tags";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_AVAILDATE = "availabilityDate";
	public static final String COLUMN_RETURNDATE = "returnDate";
	public static final String COLUMN_RESERVEDATE = "reservationDate";
	
	private String materialID;
	private String title;
	private String author;
	private String publisher;
	private String year;
	private String tags;
	private String status;
	private String location;
	private String availableDate;
	private String returnDate;
	private String reservationDate;
	
	public Material(String materialID, String title, String author, String publisher, String year, String tags, String location, String status) {
		super();
		this.materialID = materialID;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.tags = tags;
		this.location = location;
		this.status = status;
	}
	
	public Material(){}

	
	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
