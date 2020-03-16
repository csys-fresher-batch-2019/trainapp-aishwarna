package com.aishwaryaa.railwayapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.List;

import com.aishwaryaa.railwayapp.dao.PassengerDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.Passenger;
import com.aishwaryaa.railwayapp.exception.DbException;

import java.util.ArrayList;

public class PassengerDAOimpl implements PassengerDAO {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		LOGGER.debug("connected");
		return con;

	}

	@Override

	public List<Passenger> searchByPassengerName(String passengername)throws DbException{
		String sql4 = "select passenger_id,train_id from passenger details where passenger_name='" + passengername
				+ "'";
		List<Passenger> list = new ArrayList<Passenger>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql4)) {
			while (rs.next()) {
				int passengerId = rs.getInt("passenger_id");
				int TrainId = rs.getInt("train_id");
				Passenger p = new Passenger();
				p.setPassengerId(passengerId);
				p.setTrainId(TrainId);
				list.add(p);
			}
		} catch (Exception e) {
			throw new DbException("unable to search by passengername");	
		}
		return list;
	}

	public void addpassenger(Passenger p)throws DbException {
		// TODO Auto-generated method stub
		String sql8 = "insert into passenger(passenger_id,passenger_name,gender,contact_number,adhar_number,password)values(passenger_id_seq.nextval,?,?,?,?,?)";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql8)) {
			LOGGER.debug(sql8);

			pst.setString(1, p.getPassengerName());
			pst.setString(2, p.getGender());
			pst.setLong(3, p.getContactNumber());
			pst.setLong(4, p.getAdharNumber());
			pst.setInt(5, p.getPassword());
			int rows = pst.executeUpdate();
			LOGGER.debug(rows + "Rows updated");
		} catch (Exception e) {
			throw new DbException("unable to add new Passengers");	
		}

	}

	public List<Passenger> viewPassengerNames()throws DbException {

		String sql12 = "select p.passenger_name,c.payment_status from passenger p ,booking_detail c where p.train_id=c.tr_id and c.payment_status='paid'";
		List<Passenger> list = new ArrayList<Passenger>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql12)) {
			while (rs.next()) {
				String passengerName = rs.getString("passenger_name");
				String paymentstatus = rs.getString("payment_status");
				Passenger p = new Passenger();
				p.setPassengerName(passengerName);
				p.setStatus(paymentstatus);
				list.add(p);
			}
		} catch (Exception e) {
			throw new DbException("unable to view passengernames");	
		}
		return list;
	}
	
	public String login(long Contact, int pass)throws DbException {
		String sql = "select contact_number,password from passenger where contact_number=" + Contact + " and password="
				+ pass;
		String st = null;
		LOGGER.debug(sql);
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {

				long contact = rs.getLong("contact_number");

				int Password = rs.getInt("password");
				if (Contact == contact && pass == Password) {
					st = "success";
					LOGGER.debug("Logged in successfully");

				}

			} else {
				st = "failure";
				LOGGER.debug("Login failed");
			}
			
		} catch (Exception e) {
			throw new DbException("Login failed ,please verify your contact number and password");
		}
		return st;
	}
}
