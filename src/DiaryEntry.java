import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DiaryEntry {

	private String title;
	private LocalDate date;
	private LocalTime timeOfEntry;
	private String notes;
	boolean important = false;
	
	public DiaryEntry() {
	}
	
	public DiaryEntry (String title, LocalDate date, LocalTime time, String notes, boolean imp) {
		this.title = title;
		this.date = date;
		this.timeOfEntry = time;
		this.notes = notes;
		this.important = imp;
	}
	
	 public void setTitle(String titl) {
		    this.title = titl;
	 }
	 
	 public void setContent(String txt) {
		    this.notes = txt;
	 }
	 
	 public void markAsImportant(boolean imp) {
		    this.important = true;
	 }
	 
	 public String getTitle() {
		    return title;
		  }
	 
	 public String getNotes() {
		    return notes;
		  }
	 
	 public boolean getImp() {
		    return important;
		  }
	
}
