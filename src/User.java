import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime;
import java.awt.EventQueue;
import java.io.File;  // Import the File class

enum Gender {
	Γυναίκα,
	’νδρας,
	’λλο
}

public class User {
	protected String email;
	protected String password;
	protected String name;
	protected String surname;
	protected LocalDate dateOfBirth;
	protected Gender gender;
	protected String city;
	protected String region;
	protected File profPhoto;
	
	public String getUserType(Object obj) { // Return user's type as a String (Patient or Doctor)
		return obj.getClass().getName();
	}
	
	public User() {
		
	};
	
	public User(String email, String password, String name, String surname, String dateOfBirth, Gender gender, String city,String region, File profPhot) {
		this.email=email;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.dateOfBirth=LocalDate.parse(dateOfBirth);
		this.gender=gender;
		this.city=city;
		this.region=region;
		this.profPhoto=profPhoto;
	}
	/*
	public void printUser() {
		System.out.println("email: "+this.email+"\n password: "+this.password+"\n name: "+this.name+"\n surname: "+this.surname+"\n date of Birth: "+this.dateOfBirth+"\n gender: "+this.gender+"\n city: "+this.city+"region: "+this.region);
		//System.out.println("\n File: "+this.profPhoto);
	}
	*/
	
}
