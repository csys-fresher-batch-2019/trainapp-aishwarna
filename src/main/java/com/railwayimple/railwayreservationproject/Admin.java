package com.railwayimple.railwayreservationproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin implements AdminDAO {
	private static final Logger LOGGER = Logger.getInstance();
	private String user_name;
	private int password;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public static Logger getLogger() {
		return LOGGER;
	}
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		LOGGER.debug("connected");
		return con;
		
	}
	@Override
	public String toString() {
		return "Admin [user_name=" + user_name + ", password=" + password + "]";
	}
	public String Userlogin(String username,int pass) {
		String sql="select user_name,password from Admin";
		try(Connection con=conMethod();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql)) {
			LOGGER.debug(sql);
			String str=null;
			if(rs.next())
		        {
				str="success";
		        	String userName=rs.getString("user_name");
		        	int password=rs.getInt("password");
		        	if(userName.equals(username) && password==pass)
		        	{
		        		LOGGER.debug("Logged in successfully");
		        		return str;
		        	}else
		        	{
		        		str="failure";
		        		LOGGER.debug("Login failed");
		        		return str;
		        	}
		        	
		        }
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
		