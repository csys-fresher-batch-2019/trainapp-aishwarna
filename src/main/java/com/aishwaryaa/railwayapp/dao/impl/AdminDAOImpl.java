package com.aishwaryaa.railwayapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aishwaryaa.railwayapp.dao.AdminDAO;
import com.aishwaryaa.railwayapp.exception.DbException;

public class AdminDAOImpl implements AdminDAO {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		LOGGER.debug("connected");
		return con;

	}

	@Override

	public String Userlogin(String username, int pass)throws DbException{
		String sql = "select user_name,password from Admin where user_name='" + username + "' and password=" + pass;
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			LOGGER.debug(sql);
			String str = null;
			if (rs.next()) {
				str = "success";
				String userName = rs.getString("user_name");
				int password = rs.getInt("password");
				if (userName.equals(username) && password == pass) {
					LOGGER.debug("Logged in successfully");
				}

			} else {
				str = "failure";
				LOGGER.debug("Login failed");

			}
			return str;

		} catch (Exception e) {
			throw new DbException("Login failed .please verify the username and password");
		}

	}
}
