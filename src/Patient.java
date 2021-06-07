import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.LinkedList;

public class Patient extends User{

	private boolean firstLogin= false;
	
	public Patient(String email, String password, String name, String surname, String dateOfBirth, Gender gender, String city, File profPhot, Boolean firstLogin) {
		super(email, password, name, surname, dateOfBirth, gender, city, profPhot);
		this.firstLogin = firstLogin;
	}
	public Patient() {
		super();
	}
	
	public boolean getFirstLogin() {
		return firstLogin;
	}
	

	
	public ArrayList<ArrayList<String>> getMyDoctors(){
		//needs to build DB
		ArrayList<ArrayList<String>> bl = new ArrayList<ArrayList<String>>();
		java.sql.Statement Stmt;
		try {
			Stmt = login.myConn.createStatement();
			ResultSet myDoctors = Stmt.executeQuery("Select doc_email, nam, surname, specialty from isFaveOf Inner join doctor on isFaveOf.doc_email == Doctor.email where pat_email = '" + login.email + "';");
			//ArrayList<ArrayList<String>> bl = new ArrayList<ArrayList<String>>();
			while(myDoctors.next()) {
				
				ArrayList<String> l = new ArrayList<String>();
				String d_email = myDoctors.getString("doc_email");
				l.add(d_email);
				String d_name = myDoctors.getString("nam");
				l.add(d_name);
				String d_sur = myDoctors.getString("surname");
				l.add(d_sur);
				String d_special = myDoctors.getString("specialty");
				l.add(d_special);
				//System.out.println(l);
				bl.add(l);
				//System.out.println(bl);

			}//System.out.println(bl);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return bl;
	}

	
	
	public ArrayList<ArrayList<String>> getNearByDoctors(){
		//needs to build DB
				ArrayList<ArrayList<String>> nearDocs = new ArrayList<ArrayList<String>>();
				java.sql.Statement Stmt;
				try {
					Stmt = login.myConn.createStatement();
					ResultSet myRegion = Stmt.executeQuery("SELECT region FROM Patient WHERE email = '" + login.email + "';");
					ResultSet nearDoctors = Stmt.executeQuery("Select email, nam, surname, specialty from Doctor where region = '" + myRegion.getString("region") + "';");
					//ArrayList<ArrayList<String>> bl = new ArrayList<ArrayList<String>>();
					while(nearDoctors.next()) {
						
						ArrayList<String> lnb = new ArrayList<String>();
						String d_email = nearDoctors.getString("email");
						lnb.add(d_email);
						String d_name = nearDoctors.getString("nam");
						lnb.add(d_name);
						String d_sur = nearDoctors.getString("surname");
						lnb.add(d_sur);
						String d_special = nearDoctors.getString("specialty");
						lnb.add(d_special);
						//System.out.println(l);
						nearDocs.add(lnb);
						//System.out.println(bl);

					}//System.out.println(bl);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				return nearDocs;
	}
	
	public ArrayList<String> getCharacteristics(){
		ArrayList<String> pat_chars = new ArrayList<String>();
		int age;
		//pat_chars.add(null)
		
		//calculating the age of the patient
		LocalDate today = LocalDate.now(); //Today's date
		Month tm = today.getMonth();
		int td = today.getDayOfMonth();
		
		LocalDate birthday = dateOfBirth;  //Birth date
		Month bm = birthday.getMonth(); 
		int bd = birthday.getDayOfMonth();
		Period p = Period.between(birthday, today);
		
		int  y = p.getYears();
		
		if ((tm == bm) && (td == bd)) {		
			age = y +1;	
		}
		else {
			age = y;
		}
		
		String s_age=String.valueOf(age);
		String gend = gender.toString();
		pat_chars.add(s_age);
		pat_chars.add(gend);
		
		return pat_chars; //returned to String type
		
	}
}
