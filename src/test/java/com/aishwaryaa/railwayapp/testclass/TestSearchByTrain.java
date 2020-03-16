package com.aishwaryaa.railwayapp.testclass;

import com.aishwaryaa.railwayapp.dao.impl.TrainsDAOimpl;
import com.aishwaryaa.railwayapp.exception.DbException;

//import comrailway.Trains;

public class TestSearchByTrain {

	public static void main(String[] args) {
		TrainsDAOimpl searchByTrainName1 = new TrainsDAOimpl();
		String trainname = "yercard_express";
		try {
			searchByTrainName1.searchByTrainName1(trainname);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
