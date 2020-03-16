package com.aishwaryaa.railwayapp.testclass;

import java.util.Scanner;

import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.model.Passenger;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestAddPassenger {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Passenger p = new Passenger();
		LOGGER.debug("Enter passenger name");
		p.setPassengerName(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter gender");
		p.setGender(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter contact number");
		p.setContact_number(sc.nextLong());
		sc.nextLine();
		LOGGER.debug("Enter Adharnumber");
		p.setAdhar_number(sc.nextLong());
		sc.nextLine();
		LOGGER.debug("Enter password");
		p.setPassword(sc.nextInt());
		sc.nextLine();
		PassengerDAO dao = DAOFactory.getPassengerDAO();
		try {
			dao.addpassenger(p);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();

	}

}
