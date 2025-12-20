package org.example.hospitalmanagementsystem.dbConfig;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DbConfiguration {
	
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	
	public DbConfiguration() {
		try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("db.properties");
		Properties p = new Properties();
		p.load(is);
		
		String userName = p.getProperty("username"); 
		String password = p.getProperty("password");
		String driver = p.getProperty("driver");
		String url = p.getProperty("url");

		Class.forName(driver);
		connection = DriverManager.getConnection(url,userName,password);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error is : "+e);
		}
		
	}
}
