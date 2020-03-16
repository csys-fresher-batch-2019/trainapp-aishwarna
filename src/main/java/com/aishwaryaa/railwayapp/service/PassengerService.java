package com.aishwaryaa.railwayapp.service;
import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.Passenger;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;
import com.aishwaryaa.railwayapp.exception.ServiceConstant;
import com.aishwaryaa.railwayapp.exception.ServiceException;

public class PassengerService {
	PassengerDAO dao = DAOFactory.getPassengerDAO();
	public void addpassenger(Passenger p)throws DbException, ServiceException {
		try {
			dao.addpassenger(p);
		} catch(DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
		}
		}		
