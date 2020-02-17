package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.BookingDetails;
import com.railwayimple.railwayreservationproject.Logger;

public class TestAmountCalculation {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		BookingDetails bd =new BookingDetails();
		Scanner sc=new Scanner(System.in);
		LOGGER.debug("Enter passengerid");
		
		int passengerid=sc.nextInt();
		//sc.nextLine();
		bd.AmountCalculation(passengerid);
		
	}

}
