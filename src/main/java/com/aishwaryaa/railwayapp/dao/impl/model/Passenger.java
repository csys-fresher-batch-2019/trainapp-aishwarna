package com.aishwaryaa.railwayapp.dao.impl.model;

import java.util.List;

public class Passenger {

	private int passengerId;
	private String passengerName;
	private int trainId;
	private String gender;
	private long contactNumber;
	private long adharNumber;
	private int password;
	private String status;
	private String trainName;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContact_number(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAdharNumber() {
		return adharNumber;
	}

	public void setAdhar_number(long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrain_name(String trainName) {
		this.trainName = trainName;
	}

	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", trainId=" + trainId
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", adharNumber=" + adharNumber
				+ ", password=" + password + ", status=" + status + ", trainName=" + trainName + "]";
	}

}
