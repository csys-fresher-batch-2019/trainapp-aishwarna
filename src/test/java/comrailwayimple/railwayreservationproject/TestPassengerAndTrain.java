package comrailwayimple.railwayreservationproject;

import java.util.List;

import com.railwayimple.railwayreservationproject.Passenger;

public class TestPassengerAndTrain {

	public static void main(String[] args) {
		Passenger p=new Passenger();
		List<Passenger> list=p.viewPassengerNames();
		for (Passenger passenger:list) {
			System.out.println(passenger);
			
		}
	}

}
