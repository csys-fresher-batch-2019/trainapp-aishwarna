package com.aishwaryaa.railwayapp.dao.impl;

public class LoggerDAOimpl {
	public static LoggerDAOimpl getInstance() {
		LoggerDAOimpl loggerDAOimpl = new LoggerDAOimpl();
		return loggerDAOimpl;
	}

	public void debug(Object message) {
		System.out.println(message);
	}
}
