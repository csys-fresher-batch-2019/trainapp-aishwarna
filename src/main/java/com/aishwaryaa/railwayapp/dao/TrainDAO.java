package com.aishwaryaa.railwayapp.dao;

import java.util.List;

import com.aishwaryaa.railwayapp.dao.impl.model.Trains;
import com.aishwaryaa.railwayapp.exception.DbException;

public interface TrainDAO {

	public List<Trains> searchByTrainName1(String trainname) throws DbException;

	public List<Trains> displayTrainNames()throws DbException;

	public void insertTrains(Trains t)throws DbException;

	public int displayCountOfTrains(String journeystarts) throws DbException;

	public List<Trains> displayTrainDetails(String trainname)throws DbException;

}
