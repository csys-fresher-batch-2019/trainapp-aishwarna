package comrailwayimple.railwayreservationproject;
import com.railwayimple.railwayreservationproject.Logger;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.BookingDetails;

    public class TestAddBookingDetails {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		BookingDetails bd=new BookingDetails();
		Scanner sc=new Scanner(System.in);
		LOGGER.debug("Enter trainid");
		bd.setTr_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter passengerid");
		bd.setPn_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter coach type");
		bd.setCoach_type(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter birth type");
		bd.setBirth_type(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter the date of travel");
		bd.setTravel_date(java.sql.Date.valueOf(sc.nextLine()));
		sc.nextLine();
		bd.AddBookingDetail(bd);
		sc.close();
		
	}

}
