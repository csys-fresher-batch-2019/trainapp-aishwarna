package com.aishwaryaa.railwayapp.testclass;

import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestDisplayPassengers {

	public static void main(String[] args) {
		PassengerDAO p = DAOFactory.getPassengerDAO();
		try {
			p.viewPassengerNames();
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

}
