package db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBPool1 {
	
	public static final String schema = "librarysystem";
	public static final String username = "root";
	public static final String password = "root";
	public static final String url = "jdbc:mysql://localhost:3306/";
	public static final String driver = "com.mysql.jdbc.Driver";
	
	// an instance of itself
	private static DBPool1 singleton = null;
	private static BasicDataSource basicDataSource;
	
	//private constructor
	private DBPool1(){
		basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		basicDataSource.setUrl(url + schema);
		basicDataSource.setDriverClassName(driver);
	}
	
	//get instance
	public static DBPool1 getInstance(){
		if(singleton == null){
			singleton = new DBPool1();
				}
				
		return singleton;

	}
	
	public Connection getConnection() throws SQLException{
		try{
			return basicDataSource.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
