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
		bd.setTrainid(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter passenger id");
		bd.setPassengerid(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter compartment no");
		bd.setCompartment_no(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter coach type");
		bd.setCoach_type(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter birth type");
		bd.setBirth_type(sc.nextLine());
		sc.nextLine();
	     LOGGER.debug("Enter payment status");
		bd.setStatus(sc.nextLine());
		sc.nextLine();
		bd.AddBookingDetail(bd);
		sc.close();
		
	}

}
