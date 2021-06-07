import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
public class Event {
	private LocalDate day;
	private LocalTime time;
	private String title;
	private int id;

	public Event(String day, String time, String title) { // Constructor with all String arguments
		this.day=LocalDate.parse(day);
		this.time=LocalTime.parse(time);
		this.title=title;
		
		try { // Adding Event to DB and getting its id
			login.myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement st2 = login.myConn.createStatement();	
			String q="INSERT INTO Event_s VALUES('"+this.title+"','"+this.day+"','"+this.time+"',NULL);";			
			st2.execute(q);
			java.sql.Statement st = login.myConn.createStatement();	
			ResultSet rs = st.executeQuery("select id from Event_s where days='"+this.day+"' AND timing LIKE'"+this.time+"%' AND title='"+this.title+"' ;");

			rs.next();
			int id=rs.getInt("id");
			System.out.println(id);
			this.id=id;

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Event() { // Constructor with no arguments get current date & time and title is null
		this.day=LocalDate.now();
		this.time=LocalTime.now();
		this.title=null;
		
		try {// Adding Event to DB and getting its id
			login.myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement st2 = login.myConn.createStatement();	
			String q="INSERT INTO Event_s VALUES('"+this.title+"','"+this.day+"','"+this.time+"',NULL);";			
			st2.execute(q);
			java.sql.Statement st = login.myConn.createStatement();	
			ResultSet rs = st.executeQuery("select id from Event_s where days='"+this.day+"' AND timing LIKE'"+this.time+"%' AND title='"+this.title+"' ;");
			rs.next();
			int id=rs.getInt("id");
			this.id=id;

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public void printEvent() { //prints details of Event
		System.out.println("day: "+ this.day+" time:"+ this.time+ " title: "+ this.title);
	}
	*/

	public void addReminder() { // Adds a notification for the Event
		LocalTime notif_time=this.time.minusHours(2); // notification time is 2 hours before the Event
		LocalDate notif_day=this.day;
		if(this.time.getHour()<notif_time.getHour()) // notification time is about the previous day
			notif_day=this.day.minusDays(1);
		try {
			login.myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement st = login.myConn.createStatement();			
			String q="INSERT INTO Notification VALUES('Appointment with XX','"+notif_day+"','"+notif_time+"','"+this.title+"',NULL,"+this.id+",'"+login.email+"');";
			st.execute(q); // OTAN EINAI ETOIMH H APPOINTMENT NA BALW KAI TO ONOMA TOY IATROY/AS8ENH
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	//Getters
	public LocalDate getDay() {
		return this.day;
	}
	public LocalTime getTime() {
		return this.time;
	}
	public String getTitle() {
		return this.title;
	}
	//Setters
	public void setDay(String day) {
		this.day=LocalDate.parse(day);
	}	
	public void setTime(String time) {
		this.time=LocalTime.parse(time);
	}	
	public void setTitle(String title) {
		this.title=title;
	}
	*/
}