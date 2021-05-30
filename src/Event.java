import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter;
public class Event {
	private LocalDateTime daytime;
	private String title;
	
	public Event(String daytime, String title) { // Constructor with all String arguments
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.daytime=LocalDateTime.parse(daytime, formatter);
		this.title=title;
	}
	public Event() { // Constructor with no arguments get current date & time and title is null
		this.daytime=LocalDateTime.now();
		this.title=null;
	}
	public void printEvent() { //prints details of Event
		//DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    //String formatDateTime = this.daytime.format(format);  
		System.out.println("Day & Time: "+ this.daytime+" | Title: "+ this.title);
	}
	
	public void addReminder() { // Adds a notification for the Event
		
	}
	/*Getters */
	public LocalDateTime getDayTime() {
		return this.daytime;
	}
	public String getTitle() {
		return this.title;
	}
	/*Setters */
	public void setDay(String daytime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.daytime=LocalDateTime.parse(daytime, formatter);
	}		
	public void setTitle(String title) {
		this.title=title;
	}
}

