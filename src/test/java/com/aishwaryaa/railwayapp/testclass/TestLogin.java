package com.aishwaryaa.railwayapp.testclass;

import java.util.Scanner;

import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.PassengerDAOimpl;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestLogin {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassengerDAOimpl p=new PassengerDAOimpl();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	    LOGGER.debug("Enter contact_number");
	    long Contact=sc.nextLong();
		LOGGER.debug("Enter password");
		int pass=sc.nextInt();
		PassengerDAO dao=DAOFactory.getPassengerDAO();
		try {
			dao.login(Contact,pass);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
