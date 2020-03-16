package com.aishwaryaa.railwayapp.testclass;
import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.model.BookingDetail;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

import java.util.Scanner;

    public class TestAddBookingDetails {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	public static void main(String[] args) {
		BookingDetail bd=new BookingDetail();
		Scanner sc=new Scanner(System.in);
		LOGGER.debug("Enter trainid");
		bd.setTr_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter passengerid");
		bd.setPn_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter coach type");
		bd.setCoach_type(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter birth type");
		bd.setBirth_type(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter the date of travel");
		bd.setTravel_date(java.sql.Date.valueOf(sc.nextLine()));
		sc.nextLine();
		BookingDAO dao = DAOFactory.getBookingDetailsDAO();
		try {
			dao.AddBookingDetail(bd);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
	}

}
