import java.io.File;
import java.sql.SQLException;

public class Doctor extends User{

	private String specialty;
	private String phoneNum;
	private File certOfWork;
	//private DoctorSchedule docSched; //gotta create Doctor Schedule
	
	public Doctor(){ //constructor
		super();
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
		//will be called in bookAppointment() if total num of appointments between
		//doctor A and patient B is equal or more than 3
		java.sql.Statement Stmt2;
		
		try {
			Stmt2 = login.myConn.createStatement();
			String ins ="INSERT INTO isRegularOf (pat_email, doc_email) VALUES ('"+"patient email"+ "', '"+ "doctor email" + "');";
			 "email = '" + login.email + "';");
			Stmt2.execute(ins);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//create query to pass patient in the
		//regular Patients table in the DB
	}
}
