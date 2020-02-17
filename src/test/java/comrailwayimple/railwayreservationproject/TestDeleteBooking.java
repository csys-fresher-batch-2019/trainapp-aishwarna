package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.BookingDetails;
import com.railwayimple.railwayreservationproject.Logger;

public class TestDeleteBooking {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		BookingDetails bd=new BookingDetails();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		bd.setStatus(sc.nextLine());
		bd.deletebookingdetail(bd);
		LOGGER.debug("deleted");
	}
}
