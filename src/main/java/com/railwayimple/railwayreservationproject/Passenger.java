  package com.railwayimple.railwayreservationproject;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.time.LocalDate;
	import java.time.LocalDateTime;
     import java.util.List;

import oracle.sql.DATE;

import java.util.ArrayList;
import java.util.Date;

	public class Passenger implements passengerdao {
		private static final Logger LOGGER = Logger.getInstance();
	    private int passenger_id;
		private String  passenger_name; 
		 private int train_id; 
		 private String gender; 
		 private long  contact_number; 
		private long  adhar_number;
		private int password;
		private String status;
		private String train_name;

		public int getPassenger_id() {
			return passenger_id;
		}

		public void setPassenger_id(int passenger_id) {
			this.passenger_id = passenger_id;
		}

		public String getPassenger_name() {
			return passenger_name;
		}

		public void setPassenger_name(String passenger_name) {
			this.passenger_name = passenger_name;
		}

		public int getTrain_id() {
			return train_id;
		}

		public void setTrain_id(int train_id) {
			this.train_id = train_id;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public long getContact_number() {
			return contact_number;
		}

		public void setContact_number(long contact_number) {
			this.contact_number = contact_number;
		}

		public long getAdhar_number() {
			return adhar_number;
		}

		public void setAdhar_number(long adhar_number) {
			this.adhar_number = adhar_number;
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

		public String getTrain_name() {
			return train_name;
		}

		public void setTrain_name(String train_name) {
			this.train_name = train_name;
		}

		public static Logger getLogger() {
			return LOGGER;
		}

		public static Connection conMethod() throws Exception
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120", "Aishwaryaa", "Aishwaryaa");
			LOGGER.debug("connected");
			return con;
			
		}
		
		@Override
		public String toString() {
			return "Passenger [passenger_id=" + passenger_id + ", passenger_name=" + passenger_name + ", train_id="
					+ train_id + ", gender=" + gender + ", contact_number=" + contact_number + ", adhar_number="
					+ adhar_number + ", password=" + password + ", status=" + status + ", train_name=" + train_name
					+ "]";
		}
		
		
		public String toString11() {
			return "Passenger [passenger_id=" + passenger_id + ", train_id="
					+ train_id +"]";
		}
		
		public List<Passenger>searchByPassengerName(String passengername) {
			String sql4="select passenger_id,train_id from passenger details where passenger_name='"+passengername+"'";
			List<Passenger>list=new ArrayList<Passenger>();
			try(Connection con=conMethod();
					Statement stmt=con.createStatement();
			        ResultSet rs=stmt.executeQuery(sql4)) {
		        while(rs.next())
		        {
		        	int passengerId=rs.getInt("passenger_id");
		        	int TrainId=rs.getInt("train_id");
		        	Passenger p=new Passenger();
		        	p.setPassenger_id(passengerId);
		        	p.setTrain_id(TrainId);
		        	list.add(p);
		        }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
			public void addpassenger(Passenger p) {
				// TODO Auto-generated method stub
				String sql8="insert into passenger(passenger_id,passenger_name,gender,contact_number,adhar_number,password)values(passenger_id_seq.nextval,?,?,?,?,?)";
				try(Connection con=conMethod();
					PreparedStatement pst =con.prepareStatement(sql8)){
					LOGGER.debug(sql8);
					
					pst.setString(1,p.getPassenger_name());
					pst.setString(2,p.getGender());
					pst.setLong(3,p.getContact_number());
					pst.setLong(4, p.getAdhar_number());
					pst.setInt(5, p.getPassword());
					int rows=pst.executeUpdate();
					LOGGER.debug(rows+"Rows updated");
		 		}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
			public String toString1() {
				return "Passenger [ passenger_name=" + passenger_name+" ,status=" + status + "]";
			}
			public List<Passenger> viewPassengerNames() {
				
				String sql12="select p.passenger_name,c.payment_status from passenger p ,booking_detail c where p.train_id=c.tr_id and c.payment_status='paid'";
				List<Passenger>list=new ArrayList<Passenger>();
				try(Connection con=conMethod();
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(sql12)) {
					 while(rs.next())
				        {
				        	String passengerName=rs.getString("passenger_name");
				        	String paymentstatus=rs.getString("payment_status");
				    Passenger p=new Passenger();
				    p.setPassenger_name(passengerName);
				    p.setStatus(paymentstatus);
				    list.add(p);
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			
			public String toString2() {
				return "Passenger [ passenger_name=" + passenger_name + ", train_name=" + train_name
						+ "]";
			}
			
			public List<Passenger> viewFemalePassengers() {
				String sql13="select p.passenger_name,t.train_name from passenger p ,trains t where p.train_id=t.trainid and p.gender='female'"; 	
				List<Passenger>list=new ArrayList<Passenger>();
				try(Connection con=conMethod();
					Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(sql13)){
					 while(rs.next())
				        {
				       	String passengerName=rs.getString("passenger_name");
				        String trainName=rs.getString("train_name");
				        Passenger p=new Passenger();
					    p.setPassenger_name(passengerName);
					    p.setTrain_name(trainName);
					    list.add(p);
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			public List<Passenger> viewPassengerAndTrains() {
				String sql15="select passenger_name,(select train_name from trains where trains.train_id=passenger.train_id) from passenger where trains.train_id=passenger.train_id";
				List<Passenger>list=new ArrayList<Passenger>();
				try(Connection con=conMethod();
					Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(sql15)) {	
					 while(rs.next())
				        {
				        	String passengerName=rs.getString("passenger_name");
				        	LOGGER.debug(passengerName);
				        	String TrainName=rs.getString("train_name");
				        	LOGGER.debug(TrainName);
				        	Passenger p=new Passenger();
						    p.setPassenger_name(passengerName);
						    p.setTrain_name(TrainName);
						    list.add(p);
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			public String login(long Contact,int pass) {
				String sql="select contact_number,password from passenger where contact_number="+Contact+" and password="+pass;
				LOGGER.debug(sql);
				try(Connection con=conMethod();
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(sql))
						{
					String st=null;
					 if(rs.next()) {
						 
								 long contact=rs.getLong("contact_number");
						        	
						        int Password=rs.getInt("password");
						        	if(Contact==contact && pass==Password)
						        	{
						        		st="success";
						        		LOGGER.debug("Logged in successfully");
						        		
						        	}
						        	 
						        	
						        }else 
								 {
					        		 st="failure";
									 LOGGER.debug("Login failed");
								 }return st;
						}catch(Exception e)	
				{
				LOGGER.debug(e);
				}
				return null;
			}	
			}
			
		
			
		
					 	

	

