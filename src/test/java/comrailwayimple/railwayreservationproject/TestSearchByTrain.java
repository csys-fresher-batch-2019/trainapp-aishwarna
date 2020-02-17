package comrailwayimple.railwayreservationproject;
import java.util.List;

import com.railwayimple.railwayreservationproject.Trains;
import com.railwayimple.railwayreservationproject.traindao;

//import comrailway.Trains;

public class TestSearchByTrain {



	public static void main(String[] args) {
		Trains searchByTrainName1 = new Trains();
		String  trainname="kovai express";
		List<Trains> list =searchByTrainName1.searchByTrainName1(trainname);
		for (Trains trains:list) {
			System.out.println(trains);
			
		}
		//ts.searchByTrainName(trainname);

}
}
