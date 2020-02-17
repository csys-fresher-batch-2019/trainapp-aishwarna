package comrailwayimple.railwayreservationproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.railwayimple.railwayreservationproject.Logger;
import com.railwayimple.railwayreservationproject.Trains;

public class TestInsertTrAINS {
		private static final Logger LOGGER = Logger.getInstance();
		public static void main(String[] args) {
			Trains t=new Trains();
			Scanner sc=new Scanner(System.in);
		    LOGGER.debug("Enter trainid:");
			t.setTrainid(sc.nextInt());
			sc.nextLine();
			LOGGER.debug("Enter trainname:");
			t.setTrainname(sc.nextLine());
			sc.nextLine();
			LOGGER.debug("Enter journeystarts:");
			t.setJourneystarts(sc.nextLine());
			sc.nextLine();
			LOGGER.debug("Enter journeyends:");
			t.setJourneyends(sc.nextLine());
			sc.nextLine();
			LOGGER.debug("Enter arrivaltime");
			String adate=sc.next();
			  DateTimeFormatter formatter = DateTimeFormatter
		                .ofPattern("yyyy-MM-ddHH:mm:ss");
		    LocalDateTime arrival =  LocalDateTime.parse(adate,formatter);
		    t.setArrivaltime(arrival);
		    
			//LocalDate arrival=LocalDate.parse(adate);
			//Date rd=Date.valueOf(arrival);
			LOGGER.debug("Enter depaturetime");
			String ddate=sc.next();
			LocalDateTime depature =  LocalDateTime.parse(ddate,formatter);
			t.setDepaturetime(depature);
			//Timestamp dt=Timestamp.valueOf(depature);
			sc.nextLine();
			LOGGER.debug("Enter birthtype");
			t.setBirthtype(sc.nextLine());
			System.out.println(t);
			sc.nextLine();
			
			t.insertTrains(t);
			System.out.println("Inserted");
		}
		
		

	}

			