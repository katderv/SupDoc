import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime;
import java.io.File;  // Import the File class

enum Gender {
	  Female,
	  Male,
	  Other
	}

public class User {
	private String email;
	private String password;
	protected String name;
	private String surname;
	protected LocalDate dateOfBirth;
	protected Gender gender;
	private String city;
	private File profPhoto;
	
	public String getUserType(Object obj) { // Return user's type as a String (Patient or Doctor)
		return obj.getClass().getName();
	}
	
	public User() {
		
	};
	
	public User(String email, String password, String name, String surname, String dateOfBirth, Gender gender, String city, File profPhot) {
		this.email=email;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.dateOfBirth=LocalDate.parse(dateOfBirth);
		this.gender=gender;
		this.city=city;
		this.profPhoto=profPhoto;
	}
	public void printUser() {
		System.out.println("email: "+this.email+"\n password: "+this.password+"\n name: "+this.name+"\n surname: "+this.surname+"\n date of Birth: "+this.dateOfBirth+"\n gender: "+this.gender+"\n city: "+this.city);
		System.out.println("\n File: "+this.profPhoto);
	}
}
