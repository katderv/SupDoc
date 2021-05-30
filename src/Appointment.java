import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

	LocalDate day = LocalDate.now();
	LocalTime hour = LocalTime.now();
	String reason = "";
	//Doctor doc;
	//Patient patient;
	int duration = 0;
	
	LocalDate getDay () {
		return day;
	}
	
	LocalTime getHour () {
		return hour;
	}
	
	String getReason () {
		return reason;
	}
	
	void setReason () {
		reason = "Check Up";
	}
	
}