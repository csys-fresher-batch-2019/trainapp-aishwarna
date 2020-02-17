package com.railwayimple.railwayreservationproject;

//import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trains implements traindao {
	private static final Logger LOGGER = Logger.getInstance();
	private int trainid;
	private String trainname;
	private String journeystarts;
	private String journeyends;
	private LocalDateTime arrivaltime;
	private LocalDateTime depaturetime;
	private String birthtype;

	/*
	 * public Trains(int journeystartcount) { // TODO Auto-generated constructor
	 * stub } public Trains(String trainName2) { // TODO Auto-generated constructor
	 * stub } public Trains(String trainName2, String journeyStarts2, String
	 * journeyEnds2) { // TODO Auto-generated constructor stub } public Trains() {
	 * // TODO Auto-generated constructor stub }
	 */
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

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		LOGGER.debug("connected");
		return con;

	}

	@Override
	public String toString() {
		return "Trains [trainid=" + trainid + ", trainname=" + trainname + ", journeystarts=" + journeystarts
				+ ", journeyends=" + journeyends + ", arrivaltime=" + arrivaltime + ", depaturetime=" + depaturetime
				+ ", birthtype=" + birthtype + "]";
	}

	// method definition for displaying train name ,source,des,arival,depature,birth
	// type
	public List<Trains> searchByTrainName1(String trainname) {
		String sql = "select train_name,journey_starts,journey_ends from trains order by train_name";
		List<Trains> list = new ArrayList<Trains>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			LOGGER.debug(sql);

			while (rs.next()) {
				String trainName = rs.getString("train_name");
				LOGGER.debug(trainName);
				String journeyStarts = rs.getString("journey_starts");
				LOGGER.debug(journeyStarts);
				String journeyEnds = rs.getString("journey_ends");
				LOGGER.debug(journeyEnds);
				Trains t = new Trains();
				t.setTrainname(trainName);
				t.setJourneystarts(journeyStarts);
				t.setJourneyends(journeyEnds);
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Trains> displayTrainNames() {
		// TODO Auto-generated method stub
		String sql1 = "select train_name from trains where train_name like 'k%'";
		List<Trains> list = new ArrayList<Trains>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql1)) {
			LOGGER.debug(sql1);
			while (rs.next()) {
				String trainName = rs.getString("train_name");
				LOGGER.debug(trainName);
				Trains t = new Trains();
				t.setTrainname(trainName);
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertTrains(Trains t) {
		String sql3 = "insert into trains(train_id,train_name,journey_starts, journey_ends, arrival_time, depature_time,birth_type)values(?,?,?,?,?,?,?)";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql3)) {
			LOGGER.debug(sql3);
			pst.setInt(1, t.getTrainid());
			pst.setString(2, t.getTrainname());
			pst.setString(3, t.getJourneystarts());
			pst.setString(4, t.getJourneyends());
			pst.setDate(5, Date.valueOf(arrivaltime.toLocalDate()));
			pst.setDate(6, Date.valueOf(depaturetime.toLocalDate()));
			pst.setString(7, t.getBirthtype());
			// pst.setString(7, t.get);

			int rows = pst.executeUpdate();
			LOGGER.debug("Rows inserted : " + rows);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void displayCountOfTrains() {
		// List<Trains> list = new ArrayList<Trains>();
		String sql10 = "select count(journey_starts) from trains where journey_starts='chennai'";
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql10)) {
			LOGGER.debug(sql10);
			while (rs.next()) {
				int journeystartcount = rs.getInt("count(journey_starts)");
				LOGGER.debug(journeystartcount);
				// Trains t=new Trains(journeystartcount);
				// t.setJourneyStartCount(journeystartcount);
				// list.add(t);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
