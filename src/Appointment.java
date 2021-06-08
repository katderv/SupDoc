import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Appointment {

	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String reason = "";
	Doctor doc;
	Patient patient;
	int duration = 0;
	private String d_email = "haha";
	
	
	
	public void setEmail(String em) {
		this.d_email = em;
		
	}
	
	public String getEmail() {
		return this.d_email;
	}
	
	
	public static Connection myConn;
	private static ArrayList<ResultSet> rs;
	
	public Appointment (String email) {
		setEmail(email);
		initialize();
	}
	
	public Appointment () {
	}
	
	public ArrayList<ResultSet> getDay () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select days from Appointment inner join Patient on Patient.email = Appointment.patient" );
			
			ArrayList<ResultSet> rs= new ArrayList<ResultSet>();
			
			while (myRs1.next()) {
				//display to test
				System.out.println("Day of Appointment: " + myRs1.getString("days"));
				rs.add(myRs1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void setDate (LocalDate ld) {
		this.day = ld;
	}
	
	public ArrayList<ResultSet> getHour () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select hours from Appointment inner join Patient on Patient.email = Appointment.patient" );
		
			ArrayList<ResultSet> rs= new ArrayList<ResultSet>();
			
			while (myRs1.next()) {
				//display to test
				System.out.println("Hour of Appointment: " + myRs1.getString("hours"));
				rs.add(myRs1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void setHour (LocalTime lt) {
			this.hour = lt;
	}
	
	public ArrayList<ResultSet> getReason () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select reason from Appointment inner join Patient on Patient.email = Appointment.patient");
		
			ArrayList<ResultSet> rs= new ArrayList<ResultSet>();
			
			while (myRs1.next()) {
				//display to test
				System.out.println("Reason of Appointment: " + myRs1.getString("reason"));
				rs.add(myRs1);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void setReason (String st) {
		this.reason = st;
	}


}
