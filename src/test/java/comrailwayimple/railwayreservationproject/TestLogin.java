package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.Logger;
import com.railwayimple.railwayreservationproject.Passenger;

public class TestLogin {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Passenger p=new Passenger();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	    LOGGER.debug("Enter contact_number");
	    long Contact=sc.nextLong();
		LOGGER.debug("Enter password");
		int pass=sc.nextInt();
		p.login(Contact,pass);
		
	}

}
