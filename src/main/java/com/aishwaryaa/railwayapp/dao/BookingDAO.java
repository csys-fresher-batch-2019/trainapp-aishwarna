package com.aishwaryaa.railwayapp.dao;

import java.util.List;

import com.aishwaryaa.railwayapp.dao.impl.model.BookingDetail;
import com.aishwaryaa.railwayapp.exception.DbException;

public interface BookingDAO {

	List<BookingDetail> searchByPassengerid(int passengerid)throws DbException;

	public void updatebookingdetail(String status, int passengerid)throws DbException;

	public void AddBookingDetail(BookingDetail bd)throws DbException;

	public void AmountCalculation(int passengerid)throws DbException;
}
