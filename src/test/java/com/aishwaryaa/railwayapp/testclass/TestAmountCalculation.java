package com.aishwaryaa.railwayapp.testclass;

import java.util.Scanner;

import com.aishwaryaa.railwayapp.dao.impl.BookingDetailsDAOImpl;
import com.aishwaryaa.railwayapp.dao.impl.LoggerDAOimpl;

public class TestAmountCalculation {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static void main(String[] args) {
		BookingDetailsDAOImpl bd = new BookingDetailsDAOImpl();
		Scanner sc = new Scanner(System.in);
		LOGGER.debug("Enter passengerid");

		int passengerid = sc.nextInt();

		bd.AmountCalculation(passengerid);
		sc.close();

	}

}
