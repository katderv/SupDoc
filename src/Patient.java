import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
					ResultSet myDoctors = Stmt.executeQuery("Select doc_email, nam, surname, specialty from isFaveOf Inner join doctor on isFaveOf.doc_email == Doctor.email where pat_email = '" + login.email + "';");
					//ArrayList<ArrayList<String>> bl = new ArrayList<ArrayList<String>>();
					while(myDoctors.next()) {
						
						ArrayList<String> lnb = new ArrayList<String>();
						String d_email = myDoctors.getString("doc_email");
						lnb.add(d_email);
						String d_name = myDoctors.getString("nam");
						lnb.add(d_name);
						String d_sur = myDoctors.getString("surname");
						lnb.add(d_sur);
						String d_special = myDoctors.getString("specialty");
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
	/*
	public ArrayList<String> getCharacteristics(){
		//needs tp create User to get the attributes from it
	}*/
}
