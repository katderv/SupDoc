import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
public class Event {
	protected LocalDate day;
	protected LocalTime time;
	private String title;
	//private int id;
	
	/*
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
	*/
	
	public Event() { // Constructor with no arguments get current date & time and title is null
		this.day=LocalDate.now();
		this.time=LocalTime.now();
		this.title=null;
		
	}
	/*
	public void printEvent() { //prints details of Event
		System.out.println("day: "+ this.day+" time:"+ this.time+ " title: "+ this.title);
	}
	*/

	public void addReminder(String d_name) { // Adds a notification for the Event
		LocalTime notif_time=this.time.minusHours(2); // notification time is 2 hours before the Event
		LocalDate notif_day=this.day;
		if(this.time.getHour()<notif_time.getHour()) // notification time is about the previous day
			notif_day=this.day.minusDays(1);
		try {
			//login.myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement st = login.myConn.createStatement();			
			String q="INSERT INTO Notification VALUES('Ραντεβού με "+d_name+"','"+notif_day+"','"+notif_time.getHour()+"','Ραντεβού με ιατρό',NULL,'"+login.email+"');";
			st.execute(q);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setDate(String day) {
		this.day=LocalDate.parse(day);
	}
	
	public LocalDate getDate() {
		return this.day;
	}
	
	public void setHour (String lt) {			
		this.time = LocalTime.parse(lt);
		//System.out.println(this.hour);
		//System.out.println("hour: "+this.hour.getHour());
	}
	public int getHour () {			
		return this.time.getHour();
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}

}