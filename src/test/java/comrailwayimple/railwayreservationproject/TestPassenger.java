package comrailwayimple.railwayreservationproject;

import java.util.List;

import com.railwayimple.railwayreservationproject.Passenger;

public class TestPassenger {

	public static void main(String[] args) {
		Passenger p=new Passenger();
		String  passengername="sound";
		List<Passenger> list=p.searchByPassengerName(passengername);
		for(Passenger passenger:list) {
			System.out.println(passenger.toString11());
	}
		//p.searchByPassenger(passengername);
}
}
