import java.util.ArrayList;

public class Patient extends User{

	boolean firstLogin;
	
	public Patient(){ //constructor
		//will we put as parameters the attributes from user?
	}
	
	public boolean getFirstLogin() {
		return firstLogin;
	}
	
	
	public ArrayList<Doctor> getMyDoctors(){
		//needs to build DB
	}
	
	public ArrayList<Doctor> getNearByDoctors(){
		//needs to build DB and create DoctorsOffice
	}
	
	public ArrayList<String> getCharacteristics(){
		//needs tp create User to get the attributes from it
	}
}
