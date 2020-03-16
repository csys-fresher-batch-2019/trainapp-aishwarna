package com.aishwaryaa.railwayapp.dao.impl.model;

import java.util.Date;

public class BookingDetail {

	private int tr_id;
	private int trainid;
	private int pn_id;
	private String compartment_no;
	private String coach_type;
	private String birth_type;
	private String status;
	private int passengerid;
	private Date travel_date;

	public int getTr_id() {
		return tr_id;
	}

	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}

	public int getTrainid() {
		return trainid;
	}

	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}

	public Date getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}

	public int getPn_id() {
		return pn_id;
	}

	public void setPn_id(int pn_id) {
		this.pn_id = pn_id;
	}

	public String getCompartment_no() {
		return compartment_no;
	}

	public void setCompartment_no(String compartment_no) {
		this.compartment_no = compartment_no;
	}

	public String getCoach_type() {
		return coach_type;
	}

	public void setCoach_type(String coach_type) {
		this.coach_type = coach_type;
	}

	public String getBirth_type() {
		return birth_type;
	}

	public void setBirth_type(String birth_type) {
		this.birth_type = birth_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPassengerid() {
		return passengerid;
	}

	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}

	public String toString() {
		return "BookingDetails [tr_id=" + tr_id + ", trainid=" + trainid + ", pn_id=" + pn_id + ", compartment_no="
				+ compartment_no + ", coach_type=" + coach_type + ", birth_type=" + birth_type + ", status=" + status
				+ ", passengerid=" + passengerid + ", travel_date=" + travel_date + "]";
	}

}
