import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
public class Event {
	private LocalDate day;
	private LocalTime time;
	private String title;

	public Event(String day, String time, String title) { // Constructor with all String arguments
		this.day=LocalDate.parse(day);
		this.time=LocalTime.parse(time);
		this.title=title;
	}
	public Event() { // Constructor with no arguments get current date & time and title is null
		this.day=LocalDate.now();
		this.time=LocalTime.now();
		this.title=null;
	}
	public void printEvent() { //prints details of Event
		System.out.println("day: "+ this.day+" time:"+ this.time+ " title: "+ this.title);
	}

	public void addReminder() { // Adds a notification for the Event

	}
	/*Getters */
	public LocalDate getDay() {
		return this.day;
	}
	public LocalTime getTime() {
		return this.time;
	}
	public String getTitle() {
		return this.title;
	}
	/*Setters */
	public void setDay(String day) {
		this.day=LocalDate.parse(day);
	}	
	public void setTime(String time) {
		this.time=LocalTime.parse(time);
	}	
	public void setTitle(String title) {
		this.title=title;
	}
}