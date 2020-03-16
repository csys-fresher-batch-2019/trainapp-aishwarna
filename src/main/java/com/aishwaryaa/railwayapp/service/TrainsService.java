package com.aishwaryaa.railwayapp.service;
import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.Trains;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;
import com.aishwaryaa.railwayapp.exception.ServiceConstant;
import com.aishwaryaa.railwayapp.exception.ServiceException;

public class TrainsService {
	TrainDAO dao = DAOFactory.getTrainDAO();
	public void insertTrains(Trains t)throws DbException, ServiceException {
	
try {
	dao.insertTrains(t);
} catch (DbException e) {
	throw new ServiceException(ServiceConstant.INVALID_SAVE);
}
	}
public void displayTrainNames() throws DbException, ServiceException {
	try
	{
		dao.displayTrainNames();
	}catch(DbException e) {
		throw new ServiceException(ServiceConstant.INVALID_FIND);
	}
	
	}
}
			
