package beans;

import java.util.ArrayList;

public class User {
	/** DATABASE INFORMATION **/
	public static final String TABLE_NAME = "user";
	public static final String COLUMN_USERID = "id_user";
	public static final String COLUMN_LASTNAME = "last_name";
	public static final String COLUMN_FIRSTNAME = "first_name";
	public static final String COLUMN_MIDDLEINITIAL = "middle_initial";
	public static final String COLUMN_EMAILADDRESS = "email";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_ESNUMBER = "es_number";
	public static final String COLUMN_BIRTHDAY = "birthday";
	public static final String COLUMN_USERTYPE = "type";
	public static final String COLUMN_SECQ1 = "id_question1";
	public static final String COLUMN_SECQ2 = "id_question2";
	public static final int COLUMN_SECQ1ID = 1;
	public static final int COLUMN_SECQ2ID = 2;
	public static final String COLUMN_ANSQ1 = "answer_question1";
	public static final String COLUMN_ANSQ2 = "answer_question2";
	
	private String userID;
	private String type;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String password;
	private String emailAddress;
	private String esNumber;
	private String birthday;
	private int securityQ1;
	private int securityQ2;
	private int securityQ1ID;
	private int securityQ2ID;
	private String answerQ1;
	private String answerQ2;
	private String reserveIDs;
	private ArrayList<Review> reviews;
	private ArrayList<Integer> materialHistory;
	
	
	public User(String firstName, String middleInitial, String lastName, String password, String emailAddress,
			String esNumber, String birthday, int securityQ1, int securityQ2,String answerQ1, String answerQ2, String type){
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.esNumber = esNumber;
		this.birthday = birthday;
		this.securityQ1 = securityQ1;
		this.securityQ2 = securityQ2;
		this.answerQ1 = answerQ1;
		this.answerQ2 = answerQ2;
		this.type = type;
		
	}

	public User(){}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEsNumber() {
		return esNumber;
	}

	public void setEsNumber(String esNumber) {
		this.esNumber = esNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getSecurityQ1() {
		return securityQ1;
	}

	public void setSecurityQ1(int securityQ1) {
		this.securityQ1 = securityQ1;
	}

	public int getSecurityQ2() {
		return securityQ2;
	}

	public void setSecurityQ2(int securityQ2) {
		this.securityQ2 = securityQ2;
	}
	
	public String getAnswerQ1() {
		return answerQ1;
	}
	
	public void setAnswerQ1(String answerQ1) {
		this.answerQ1 = answerQ1;
	}
	
	public String getAnswerQ2() {
		return answerQ2;
	}
	
	public void setAnswerQ2(String answerQ2) {
		this.answerQ2 = answerQ2;
	}
	
	public void setSecurityQ1ID(int id){
		securityQ1ID = id;
	}
	
	public void setSecurityQ2ID(int id){
		securityQ2ID = id;
	}
	
	public int getSecurityQ1ID(){
		return securityQ1ID;
	}
	
	public int getSecurityQ2ID(){
		return securityQ2ID;
	}
	
	public String getReserveIDs() {
		return reserveIDs;
	}

	public void setReserveIDs(String reserveIDs) {
		this.reserveIDs = reserveIDs;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public ArrayList<Integer> getMaterialHistory() {
		return materialHistory;
	}

	public void setMaterialHistory(ArrayList<Integer> materialHistory) {
		this.materialHistory = materialHistory;
	}
}
