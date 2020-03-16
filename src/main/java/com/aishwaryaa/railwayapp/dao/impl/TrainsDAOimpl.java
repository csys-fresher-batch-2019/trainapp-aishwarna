package com.aishwaryaa.railwayapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aishwaryaa.railwayapp.dao.TrainDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.Trains;
import com.aishwaryaa.railwayapp.exception.DbException;


public class TrainsDAOimpl implements TrainDAO {

	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();
	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		LOGGER.debug("connected");
		return con;
	}
	@Override
	public List<Trains> searchByTrainName1(String trainname)throws DbException {
		String sql = "select train_name,journey_starts,journey_ends from trains where train_name='" + trainname + "'";
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
			throw new DbException("unable to view traindetails");
		}
		return list;
	}

	public List<Trains> displayTrainNames()throws DbException{
		// TODO Auto-generated method stub
		String sql1 = "select train_id,train_name,journey_starts,journey_ends from trains";
		List<Trains> list = new ArrayList<Trains>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql1)) {
			LOGGER.debug(sql1);
			while (rs.next()) {
				int id = rs.getInt("train_id");
				String trainName = rs.getString("train_name");
				String start = rs.getString("journey_starts");
				String end = rs.getString("journey_ends");
				LOGGER.debug(trainName);
				Trains t = new Trains();
				t.setTrainid(id);
				t.setTrainname(trainName);
				t.setJourneystarts(start);
				t.setJourneyends(end);
				list.add(t);
			}
		} catch( Exception e) {
			throw new DbException("unable to view trainnames");	
		}
		
		return list;
	}

	public void insertTrains(Trains t)throws DbException{
		String sql3 = "insert into trains(train_id,train_name,journey_starts, journey_ends, arrival_time, depature_time,birth_type)values(?,?,?,?,?,?,?)";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql3)) {
			LOGGER.debug(sql3);
			pst.setInt(1, t.getTrainid());
			pst.setString(2, t.getTrainname());
			pst.setString(3, t.getJourneystarts());
			pst.setString(4, t.getJourneyends());
			pst.setDate(5, Date.valueOf(t.getArrivaltime().toLocalDate()));
			pst.setDate(6, Date.valueOf(t.getDepaturetime().toLocalDate()));
			pst.setString(7, t.getBirthtype());
			// pst.setString(7, t.get);
			int rows = pst.executeUpdate();
			LOGGER.debug("Rows inserted : " + rows);

		} catch (Exception e) {
			throw new DbException("unable to insert trains");	
		}

	}

	public List<Trains> displayTrainDetails(String trainname) throws DbException {
		String sql = "select train_id,journey_starts,journey_ends,arrival_time,depature_time from trains where train_name=?";
		List<Trains> list = new ArrayList<>();
		try {
			try (Connection con = conMethod();
				PreparedStatement pst = con.prepareStatement(sql)) {
				LOGGER.debug(sql);
				pst.setString(1, trainname);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("train_id");
					String start = rs.getString("journey_starts");
					String end = rs.getString("journey_ends");
					LocalDateTime arrival = rs.getTimestamp("arrival_time").toLocalDateTime();
					LocalDateTime depature = rs.getTimestamp("depature_time").toLocalDateTime();
					Trains t = new Trains();
					t.setTrainid(id);
					t.setJourneystarts(start);
					t.setJourneyends(end);
					t.setArrivaltime(arrival);
					t.setDepaturetime(depature);
					list.add(t);
				}
			}catch (SQLException e) {
				throw new DbException("unable to insert trains");	
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int displayCountOfTrains(String journeystarts)throws DbException{
		// List<Trains> list = new ArrayList<Trains>();
		String sql10 = "select count(journey_starts)as ct from trains where journey_starts=?";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql10)) {
			pst.setString(1, journeystarts);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int journeystartcount = rs.getInt("ct");
				LOGGER.debug(journeystartcount);
			}
		} catch (Exception e) {
			throw new DbException("unable to display count of trains");	
		}
		return 0;

	}

	public void deletetrain(String tname)throws DbException {
		String sql8 = "delete from trains where train_name='" + tname + "'";
		try (Connection con = conMethod(); Statement stmt = con.createStatement()) {
			LOGGER.debug(sql8);
			int rows = stmt.executeUpdate(sql8);
			LOGGER.debug(rows + "deleted");

		} catch (Exception e) {
			throw new DbException("unable to delete train");	
		}

	}

}
