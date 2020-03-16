package com.aishwaryaa.railwayapp.exception;

public class DbException extends Exception {

	public DbException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public DbException(String msg, Exception e) {
		super(msg,e);
	}

}
