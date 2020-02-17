package comrailwayimple.railwayreservationproject;

import java.util.List;

import com.railwayimple.railwayreservationproject.Passenger;

public class TestDisplayFemalePassengers {

	public static void main(String[] args) {
		Passenger p=new Passenger();
		List<Passenger> list=p.viewFemalePassengers();
		for (Passenger passenger:list) {
			System.out.println(passenger.toString2());
			
		}
	}
}
