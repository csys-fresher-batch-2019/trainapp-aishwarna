package com.railwayimple.railwayreservationproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
public interface passengerdao {
	//select passenger name,passenger id,gender from passenger
	List <Passenger>searchByPassengerName(String passengername);
	//"insert into passenger(passenger_id,passenger_name,train_id,gender,contact_number,adhar_number)values(?,?,?,?,?,?)";
public void addpassenger(Passenger p);

//select p.passenger_name,c.payment_status from passenger p ,booking_detail c where p.train_id=c.tr_id and c.payment_status='paid';

 List<Passenger>viewPassengerNames();
 
 //select p.passenger_name,t.train_name from passenger p ,trains t where p.train_id=t.train_id and p.gender='female';
 public List<Passenger> viewFemalePassengers();
 //select passenger_name,(select train_name from trains where trains.train_id=passenger.train_id) from passenger where trains.train_id=passenger.train_id;select passenger_name,(select train_name from trains where trains.train_id=passenger.train_id) from passenger where trains.train_id=passenger.train_id;
 public List<Passenger> viewPassengerAndTrains();
 
 
 //	select passenger_id,password from passenger where passenger_id=?";

 public void login(int pId,int pass) ;

 

}
