package com.aishwaryaa.railwayapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.aishwaryaa.railwayapp.dao.BookingDAO;
import com.aishwaryaa.railwayapp.dao.impl.model.BookingDetail;
import com.aishwaryaa.railwayapp.exception.DbException;

public class BookingDetailsDAOImpl implements BookingDAO {
	private static final LoggerDAOimpl LOGGER = LoggerDAOimpl.getInstance();

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		
		LOGGER.debug("connected");
		return con;
	}

	public List<BookingDetail> searchByPassengerid(int passengerid)throws DbException{
		String sql6 = "select tr_id,pn_id,compartment_no,coach_type,birth_type from booking_detail";
		List<BookingDetail> list = new ArrayList<BookingDetail>();
		try (Connection con = conMethod();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql6)) {
			while (rs.next()) {
				int TrainId = rs.getInt("tr_id");
				int passengerId = rs.getInt("pn_id");
				String CompartmentNumber = rs.getString("compartment_no");
				String CoachType = rs.getString("coach_type");
				String BirthType = rs.getString("birth_type");
				BookingDetail bd = new BookingDetail();
				bd.setTr_id(TrainId);
				bd.setPn_id(passengerId);
				bd.setCompartment_no(CompartmentNumber);
				bd.setCoach_type(CoachType);
				bd.setBirth_type(BirthType);
				list.add(bd);
			}
		} catch (Exception e) {
			throw new DbException("unable to search passenger by id");
		}
		return list;
	}

	public void AddBookingDetail(BookingDetail bd)throws DbException {
		String sql16 = "insert into booking_detail(tr_id,pn_id,coach_type,birth_type,travel_date)values(?,?,?,?,?)";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql16)) {
			LOGGER.debug(sql16);
			pst.setInt(1, bd.getTr_id());
			pst.setInt(2, bd.getPn_id());
			pst.setString(3, bd.getCoach_type());
			pst.setString(4, bd.getBirth_type());
			pst.setDate(5, (java.sql.Date) bd.getTravel_date());
			int rows = pst.executeUpdate();
			LOGGER.debug(rows + "Rows updated");
		} catch (Exception e) {
			throw new DbException("unable to add the bookingdetail");
		}
	}

	public void updatebookingdetail(String status, int passengerid)throws DbException{
		String sql8 = "update  booking_detail set payment_status='" + status + "'  where pn_id=" + passengerid;
		try (Connection con = conMethod(); Statement stmt = con.createStatement()) {
			LOGGER.debug(sql8);
			int rows = stmt.executeUpdate(sql8);
			LOGGER.debug(rows + "updated");

		} catch (Exception e) {
			throw new DbException("unable to update the bookingdetail");
		}

	}

	public void AmountCalculation(int passengerid)throws DbException {
		// TODO Auto-generated method stub
		String sql = "update booking_detail set amount=(select (b.seat_count*t.amount_per_passenger) amounts from booking_detail b,trains t where b.tr_id=t.train_id and b.pn_id=?)where pn_id=?";
		try (Connection con = conMethod(); PreparedStatement pst = con.prepareStatement(sql)) {
			// System.out.println(sql);
			pst.setInt(1, passengerid);
			pst.setInt(2, passengerid);
			int rows = pst.executeUpdate();
			LOGGER.debug(rows + "Rows updated");
		} catch (Exception e) {
			throw new DbException("unable to calculate the amount");
		}
	}
}
