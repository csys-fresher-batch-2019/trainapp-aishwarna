 package com.aishwaryaa.railwayapp.testclass;

import java.util.Scanner;

import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.impl.BookingDetailsDAOImpl;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;

public class TestDeleteBooking {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	public static void main(String[] args) {
		BookingDetailsDAOImpl bd=new BookingDetailsDAOImpl();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		bd.setStatus(sc.nextLine());
		BookingDAO dao=DAOFactory.getBookingDetailsDAO();
		dao.deletebookingdetail(bd);
		//bd.deletebookingdetail(bd);
		LOGGER.debug("deleted");
	}
}
