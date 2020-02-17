package comrailwayimple.railwayreservationproject;

import java.util.List;

import com.railwayimple.railwayreservationproject.BookingDetails;

public class TestBooking {

	public static void main(String[] args) {
		BookingDetails bd=new BookingDetails();
		int passengerid=1111;
		List<BookingDetails> list=bd.searchByPassengerid(passengerid);
		for(BookingDetails book:list) {
			System.out.println(book);
		}
		
	}

}
