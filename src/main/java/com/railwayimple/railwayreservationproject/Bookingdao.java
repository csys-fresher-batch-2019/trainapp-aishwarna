package com.railwayimple.railwayreservationproject;

import java.sql.SQLException;
import java.util.List;

public interface Bookingdao {
	//select tr_id,pn_id,compartment_no,coach_type,birth_type from booking_details";
	List<BookingDetails> searchByPassengerid(int passengerid);

//update  booking_detail set payment_status='paid' where tr_id=1234;
public void updatebookingdetail(String status,int passengerid );

//"delete  payment_status='" + status + "' from booking_detail where tr_id="+ trainid ;
public void deletebookingdetail(BookingDetails bd);

public void AddBookingDetail(BookingDetails bd);


// "update booking_detail set amount=(select (b.seat_count*t.amount_per_passenger) amounts from booking_detail b,trains t where b.tr_id=t.train_id and b.pn_id=?)where pn_id=?)";

public void AmountCalculation(int passengerid);
}

