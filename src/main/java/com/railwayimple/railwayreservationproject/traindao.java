package com.railwayimple.railwayreservationproject;
import java.util.List;
public interface traindao  {
	//select train_name,journey_starts,journey_ends from trains order by train_name";
	public List<Trains>searchByTrainName1(String trainname);

	//select train_name from trains;	
	public List<Trains> displayTrainNames();
	
	//inserting new values
	public void insertTrains(Trains t);
	
	//select count(journey_starts) from trains where journey_starts='chennai;
	
	public void displayCountOfTrains();
	
}
