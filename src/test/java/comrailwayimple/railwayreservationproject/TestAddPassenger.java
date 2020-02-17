package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.Logger;
import com.railwayimple.railwayreservationproject.Passenger;


public class TestAddPassenger {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		Passenger p=new Passenger();
		Scanner sc=new Scanner(System.in);
	    LOGGER.debug("Enter passengerid");
		p.setPassenger_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter passenger name");
		p.setPassenger_name(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter trainId");
		p.setTrain_id(sc.nextInt());
		sc.nextLine();
		LOGGER.debug("Enter gender");
		p.setGender(sc.nextLine());
		sc.nextLine();
		LOGGER.debug("Enter contact number");
		p.setContact_number(sc.nextLong());
		sc.nextLine();
		LOGGER.debug("Enter Adharnumber");
		p.setAdhar_number(sc.nextLong());
		sc.nextLine();
		LOGGER.debug("Enter password");
		p.setPassword(sc.nextInt());
		sc.nextLine();
		p.addpassenger(p);
		

	}

}
