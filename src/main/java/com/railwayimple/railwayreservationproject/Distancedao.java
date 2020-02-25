package com.railwayimple.railwayreservationproject;

public interface Distancedao {
	//SqlUpdate("insert into distancebetweencities(starting_place,destination_place,distance_between_cities_inkms)values('chennai','hyderabad',626)");
	
	public void distancebetweencities();
	
	
	//SqlQuery("select distance_between_cities_inkms from distancebetweencities where starting_place='chennai'and destination_place='bangalore'");
	public int distance();

}
