package com.aishwaryaa.railwayapp.service;

import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.BookingDetail;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;
import com.aishwaryaa.railwayapp.exception.DbException;
import com.aishwaryaa.railwayapp.exception.ServiceConstant;
import com.aishwaryaa.railwayapp.exception.ServiceException;

public class BookingService {
	BookingDAO dao = DAOFactory.getBookingDetailsDAO();
	public void AddBookingDetail(BookingDetail bd)throws DbException, ServiceException{
		try
		{
			dao.AddBookingDetail(bd);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}
}
