package com.aishwaryaa.railwayapp.testclass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.model.Trains;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;
public class TestInsertTrAINS {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static void main(String[] args) {
		Trains t = new Trains();
		Scanner sc = new Scanner(System.in);
		LOGGER.debug("Enter trainid:");
		t.setTrainid(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter trainname:");
		t.setTrainname(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter journeystarts:");
		t.setJourneystarts(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter journeyends:");
		t.setJourneyends(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter arrivaltime");
		String adate = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime arrival = LocalDateTime.parse(adate, formatter);
		t.setArrivaltime(arrival);
		LOGGER.debug("Enter depaturetime");
		String ddate = sc.next();
		LocalDateTime depature = LocalDateTime.parse(ddate, formatter);
		t.setDepaturetime(depature);
		sc.nextLine();
		LOGGER.debug("Enter birthtype");
		t.setBirthtype(sc.nextLine());
		System.out.println(t);
		TrainDAO dao = DAOFactory.getTrainDAO();
		
		try {
			dao.insertTrains(t);
		} catch (DbException e) {
			
			e.printStackTrace();
		}
		
		sc.close();
	}

}
