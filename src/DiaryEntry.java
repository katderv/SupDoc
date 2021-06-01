import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DiaryEntry extends PatientsDiary {

	String title;
	LocalDate date = LocalDate.now();
	LocalTime timeOfEntry = LocalTime.now();
	String notes;
	boolean important = false;
	
	
	public DiaryEntry (ArrayList<DiaryEntry> entry, String title, LocalDate date, LocalTime time, String notes, boolean imp) {
		super(entry);
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
	
}
