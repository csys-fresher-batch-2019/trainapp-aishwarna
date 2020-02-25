package com.railwayimple.railwayreservationproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingDetails implements Bookingdao {
	private static final Logger LOGGER = Logger.getInstance();
	
	private int tr_id;
	private int trainid;
	private int pn_id;
	private String compartment_no;
	private String coach_type;
	private String birth_type;
	private String status;
	private int  passengerid;
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
		this.travel_date=travel_date;
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

	public static Connection conMethod() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120", "Aishwaryaa", "Aishwaryaa");
		LOGGER.debug("connected");
		return con;

	}

	@Override
	public String toString() {
		return "BookingDetails [tr_id=" + tr_id + ", trainid=" + trainid + ", pn_id=" + pn_id + ", compartment_no="
				+ compartment_no + ", coach_type=" + coach_type + ", birth_type=" + birth_type + ", status=" + status
				+ ", passengerid=" + passengerid + ", travel_date=" + travel_date + "]";
	}

	public List<BookingDetails>searchByPassengerid(int passengerid) {
		String sql6 = "select tr_id,pn_id,compartment_no,coach_type,birth_type from booking_detail";
		List<BookingDetails> list = new ArrayList<BookingDetails>();
		try(Connection con = conMethod();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql6)){
			while (rs.next()) {
				int TrainId = rs.getInt("tr_id");
				int passengerId = rs.getInt("pn_id");
				String CompartmentNumber = rs.getString("compartment_no");
				String CoachType = rs.getString("coach_type");
				String BirthType = rs.getString("birth_type");
				BookingDetails bd=new BookingDetails();
				bd.setTr_id(TrainId);
				bd.setPn_id(passengerId);
				bd.setCompartment_no(CompartmentNumber);
				bd.setCoach_type(CoachType);
				bd.setBirth_type(BirthType);
				list.add(bd);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public void deletebookingdetail(BookingDetails bd) {
		String sql9 = "delete from booking_detail where payment_status='"+status+"'";
		try(Connection con = conMethod();Statement stmt = con.createStatement())
				{
			LOGGER.debug(sql9);
			int rows = stmt.executeUpdate(sql9);
			LOGGER.debug(rows + "deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public void AddBookingDetail(BookingDetails bd) {
			String sql16 = "insert into booking_detail(tr_id,pn_id,coach_type,birth_type,travel_date)values(?,?,?,?,?)";
			try(Connection con = conMethod();
			PreparedStatement pst = con.prepareStatement(sql16)) {
				LOGGER.debug(sql16);
				pst.setInt(1, bd.getTr_id());
				pst.setInt(2,bd.getPn_id());
				pst.setString(3,bd.getCoach_type());
				pst.setString(4,bd.getBirth_type());
				pst.setDate(5,(java.sql.Date)bd.getTravel_date());
				int rows=pst.executeUpdate();
				LOGGER.debug(rows+"Rows updated");
			}
			catch(Exception e)
			{
				e.printStackTrace();
		
			}
						
		}

		

		public void updatebookingdetail(String status, int passengerid) {
			String sql8 = "update  booking_detail set payment_status='" + status + "'  where pn_id="+ passengerid;
			try(Connection con = conMethod();
				Statement stmt = con.createStatement()) {
				LOGGER.debug(sql8);
				int rows = stmt.executeUpdate(sql8);
				LOGGER.debug(rows + "updated");

			} catch (Exception e) {
				e.printStackTrace();
			}			
			
		}
 public void AmountCalculation(int passengerid) 
		 {
			// TODO Auto-generated method stub
		String sql ="update booking_detail set amount=(select (b.seat_count*t.amount_per_passenger) amounts from booking_detail b,trains t where b.tr_id=t.train_id and b.pn_id=?)where pn_id=?";
			try( Connection con = conMethod();
					PreparedStatement pst = con.prepareStatement(sql)) {
				//System.out.println(sql);
				pst.setInt(1,passengerid);
				pst.setInt(2,passengerid);
				int rows=pst.executeUpdate();
				LOGGER.debug(rows+"Rows updated");
	 		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 }
}
			
		
				
		
		
		

