 package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.BookingDetails;
import com.railwayimple.railwayreservationproject.Logger;

public class TestUpdateBooking {

	private static final Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingDetails bd=new BookingDetails();
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter the status");
	      String status=s.nextLine();
		LOGGER.debug("Enter the passenger_id:");
		  int passengerid=s.nextInt();
		bd.updatebookingdetail (status,passengerid);
	}

}
