package com.aishwaryaa.railwayapp.testclass;

import java.util.List;

import com.aishwaryaa.railwayapp.dao.impl.BookingDetailsDAOImpl;
import com.aishwaryaa.railwayapp.dao.impl.model.BookingDetail;

public class TestBooking {

	public static void main(String[] args) {
		BookingDetailsDAOImpl bd=new BookingDetailsDAOImpl();
		int passengerid=1111;
		List<BookingDetailsDAOImpl> list= bd.searchByPassengerid(passengerid);
		for(BookingDetailsDAOImpl book:list) {
			System.out.println(book);
		}

	}

}
