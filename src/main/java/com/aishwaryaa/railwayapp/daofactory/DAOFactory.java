package com.aishwaryaa.railwayapp.daofactory;

import com.aishwaryaa.railwayapp.dao.AdminDAO;
import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.dao.impl.AdminDAOImpl;
import com.aishwaryaa.railwayapp.dao.impl.BookingDetailsDAOImpl;
import com.aishwaryaa.railwayapp.dao.impl.PassengerDAOimpl;
import com.aishwaryaa.railwayapp.dao.impl.TrainsDAOimpl;

public class DAOFactory {
	public static TrainDAO getTrainDAO() {
		return (new TrainsDAOimpl());
	}

	public static PassengerDAO getPassengerDAO() {
		return (new PassengerDAOimpl());
	}

	public static BookingDAO getBookingDetailsDAO() {
		return (new BookingDetailsDAOImpl());
	}

	public static AdminDAO getadminDAO() {
		return (new AdminDAOImpl());
	}

}
