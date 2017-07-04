package beans;

public class Review {
	public static final String TABLE_NAME = "reviews";
	public static final String COLUMN_REVIEWEDBY = "reviewed_by";
	public static final String COLUMN_MATERIALID = "material_id";
	public static final String COLUMN_RATING = "rating";
	public static final String COLUMN_MESSAGE = "message";
	public static final String COLUMN_REVIEWDATE = "review_date";
	
	private String reviewedBy;
	private int rating;
	private String message;	
	private int materialID;
	private String reviewDate;
	
	public Review(String reviewedBy, int rating, String message, int materialID, String reviewDate) {
		super();
		this.reviewedBy = reviewedBy;
		this.rating = rating;
		this.message = message;
		this.materialID = materialID;
		this.reviewDate = reviewDate;
	}
	
	public Review(){}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}


	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMaterialID() {
		return materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
	

}
