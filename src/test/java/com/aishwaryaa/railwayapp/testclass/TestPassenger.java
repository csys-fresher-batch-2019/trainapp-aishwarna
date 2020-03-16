package com.aishwaryaa.railwayapp.testclass;

import java.util.List;

import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.impl.PassengerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.model.Passenger;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestPassenger {

	public static void main(String[] args) {
		Passenger p=new Passenger();
		PassengerDAO dao = DAOFactory.getPassengerDAO();
		String  passengername="sound";
		try {
			List<Passenger> list=dao.searchByPassengerName(passengername);
		} catch (DbException e) {
			e.printStackTrace();
		}
		
	}
		
}
