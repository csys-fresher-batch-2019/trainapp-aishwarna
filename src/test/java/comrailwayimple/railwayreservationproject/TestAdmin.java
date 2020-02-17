package comrailwayimple.railwayreservationproject;

import java.util.Scanner;

import com.railwayimple.railwayreservationproject.Admin;
import com.railwayimple.railwayreservationproject.Logger;
import com.railwayimple.railwayreservationproject.Passenger;

public class TestAdmin {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin a=new Admin();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	    LOGGER.debug("Enter username");
	    String username=sc.nextLine();
		LOGGER.debug("Enter password");
		int pass=sc.nextInt();
		a.Userlogin(username,pass);
		
	}

}
