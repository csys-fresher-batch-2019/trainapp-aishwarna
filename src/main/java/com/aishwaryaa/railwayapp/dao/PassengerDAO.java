package com.aishwaryaa.railwayapp.dao;

import java.util.List;
import com.aishwaryaa.railwayapp.dao.impl.model.Passenger;
import com.aishwaryaa.railwayapp.exception.DbException;

public interface PassengerDAO {

	List<Passenger> searchByPassengerName(String passengername)throws DbException;

	public void addpassenger(Passenger p)throws DbException;

	List<Passenger> viewPassengerNames()throws DbException;

	public String login(long Contact, int pass)throws DbException;

}
