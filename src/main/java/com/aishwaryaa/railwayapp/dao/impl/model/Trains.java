package com.aishwaryaa.railwayapp.dao.impl.model;

import java.time.LocalDateTime;

public class Trains {

	private int trainid;
	private String trainname;
	private String journeystarts;
	private String journeyends;
	private LocalDateTime arrivaltime;
	private LocalDateTime depaturetime;
	private String birthtype;

	public int getTrainid() {
		return trainid;
	}

	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getJourneystarts() {
		return journeystarts;
	}

	public void setJourneystarts(String journeystarts) {
		this.journeystarts = journeystarts;
	}

	public String getJourneyends() {
		return journeyends;
	}

	public void setJourneyends(String journeyends) {
		this.journeyends = journeyends;
	}

	public LocalDateTime getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(LocalDateTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public LocalDateTime getDepaturetime() {
		return depaturetime;
	}

	public void setDepaturetime(LocalDateTime depaturetime) {
		this.depaturetime = depaturetime;
	}

	public String getBirthtype() {
		return birthtype;
	}

	public void setBirthtype(String birthtype) {
		this.birthtype = birthtype;
	}

	public String toString() {
		return "Trains [trainid=" + trainid + ", trainname=" + trainname + ", journeystarts=" + journeystarts
				+ ", journeyends=" + journeyends + ", arrivaltime=" + arrivaltime + ", depaturetime=" + depaturetime
				+ ", birthtype=" + birthtype + "]";
	}

}
