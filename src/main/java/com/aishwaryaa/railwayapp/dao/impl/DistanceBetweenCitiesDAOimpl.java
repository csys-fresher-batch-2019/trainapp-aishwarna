package com.aishwaryaa.railwayapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DistanceBetweenCitiesDAOimpl {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	private String starting_place;
	private String destination_place;
	private int distancebetweencitiesinkms;

	public String getStarting_place() {
		return starting_place;
	}

	public void setStarting_place(String starting_place) {
		this.starting_place = starting_place;
	}

	public String getDestination_place() {
		return destination_place;
	}

	public void setDestination_place(String destination_place) {
		this.destination_place = destination_place;
	}

	public int getDistancebetweencitiesinkms() {
		return distancebetweencitiesinkms;
	}

	public void setDistancebetweencitiesinkms(int distancebetweencitiesinkms) {
		this.distancebetweencitiesinkms = distancebetweencitiesinkms;
	}

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		LOGGER.debug("connected");
		return con;

	}

	@Override
	public String toString() {
		return "DistanceBetweenCity [starting_place=" + starting_place + ", destination_place=" + destination_place
				+ ", distancebetweencitiesinkms=" + distancebetweencitiesinkms + "]";
	}

	// method definition
	public void distancebetweencities() {
		String sql = "insert into distancebetweencity(starting_place,destination_place,distance_between_cities_inkms)values('chennai','hyderabad',626)";
		try (Connection con = conMethod(); Statement stmt = con.createStatement()) {
			LOGGER.debug(sql);
			int rows = stmt.executeUpdate(sql);
			LOGGER.debug(rows + "Rows updates");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public int distance() {
		String sql = "select distance_between_cities_inkms from distancebetweencity where starting_place='chennai' and destination_place='bangalore'";
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			LOGGER.debug(sql);
			if (rs.next()) {
				int distancebetweenplaces = rs.getInt("distance_between_cities_inkms");
				LOGGER.debug(distancebetweenplaces);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
