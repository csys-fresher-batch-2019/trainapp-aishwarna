package com.aishwaryaa.railwayapp.testclass;

import java.util.Scanner;

import com.aishwaryaa.railwayapp.dao.AdminDAO;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestAdmin {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	    LOGGER.debug("Enter username");
	    String username=sc.nextLine();
		LOGGER.debug("Enter password");
		int pass=sc.nextInt();
		AdminDAO dao = DAOFactory.getadminDAO();
		try {
			dao.Userlogin(username, pass);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
