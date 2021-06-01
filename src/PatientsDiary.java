import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PatientsDiary {
	
	ArrayList<DiaryEntry> entry = new ArrayList<DiaryEntry>();
	
	
	public PatientsDiary (ArrayList<DiaryEntry> entr) {
		this.entry = entr;
		
	}
	
	
	
	ArrayList<DiaryEntry> getDiaryEntries(){
		ArrayList<DiaryEntry> entries = new ArrayList<DiaryEntry>();
		return entries;
	}

}
