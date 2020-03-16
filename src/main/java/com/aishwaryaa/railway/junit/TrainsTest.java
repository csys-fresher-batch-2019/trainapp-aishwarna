package com.aishwaryaa.railway.junit;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.daofactory.DAOFactory;

public class TrainsTest {
	TrainDAO t=DAOFactory.getTrainDAO();

	@Test
	public void testInsertTrains()throws Exception{
		int trainid=9191;
		String trainname="sathapthi express";
		String journeystarts="tanjore";
		String journeyends="chennai";
		LocalDateTime arrivaltime="2020-03-1909:00:00";
		LocalDateTime depaturetime="2020-03-1915:00:00";
		String birthtype="sleeper";
		TrainsDAOimpl obj=new TrainsDAOimpl(trainid,trainname,journeystarts,journeyends,arrivaltime,depaturetime,
				birthtype);
		
		
	}
	{
		fail("Not yet implemented");
	}

}
