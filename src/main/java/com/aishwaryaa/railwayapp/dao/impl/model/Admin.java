package com.aishwaryaa.railwayapp.dao.impl.model;

import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;

public class Admin {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
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

	public static LoggerDAOimpl getLogger() {
		return LOGGER;
	}

	public String toString() {
		return "Admin [user_name=" + user_name + ", password=" + password + "]";
	}

}
