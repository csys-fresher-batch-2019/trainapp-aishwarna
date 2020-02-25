package com.railwayimple.railwayreservationproject;
import java.util.List;

public interface traindao  {
	//@SqlQuery("select train_name,journey_starts,journey_ends from trains order by train_name")
	public List<Trains>searchByTrainName1(String trainname);

	//@SqlQuery("select train_name from trains")
	public List<Trains> displayTrainNames();
	
	//@SqlUpdate("insert into trains(train_id,train_name,journey_starts, journey_ends, arrival_time, depature_time,birth_type)values(?,?,?,?,?,?,?)";)
	public void insertTrains(Trains t);
	
	//@SqlQuery("select count(journey_starts) from trains where journey_starts='chennai");
	public int  displayCountOfTrains();
	
	public List<Trains>  displayTrainDetails(String trainname);
	
}
