 package com.aishwaryaa.railwayapp.testclass;

import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.dao.impl.TrainsDAOimpl;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;

public class TestDisplayTrains {

	public static void main(String[] args) {
		
				TrainsDAOimpl ts=new TrainsDAOimpl();
				TrainDAO dao=DAOFactory.getTrainDAO();
				try {
					dao.displayTrainNames();
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ts.displayTrainNames();
}
}