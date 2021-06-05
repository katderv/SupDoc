import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PatientsDiary {
	
	private ArrayList<DiaryEntry> entry = new ArrayList<DiaryEntry>();
	
	
	public PatientsDiary (ArrayList<DiaryEntry> entr) {
		this.entry = entr;
		
	}
	
	
	
	public ArrayList<DiaryEntry> getDiaryEntries(){
		//ArrayList<DiaryEntry> entries = new ArrayList<DiaryEntry>();
		return entry;
	}

}
