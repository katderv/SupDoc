import java.io.File;

public class Doctor extends User{

	String specialty;
	String phoneNum;
	File certOfWork;
	DoctorSchedule docSched; //gotta create Doctor Schedule
	
	public Doctor(){ //constructor
		//will we put as parameters the attributes from user?
	}
	
	public File getLicence() {
		return certOfWork;
	}
	
	public String getDocName() {
		//return Name from User
		return name;
	}
	
	public void addRegular() {
		//create query to pass patient in the
		//regular Patients table in the DB
	}
}
