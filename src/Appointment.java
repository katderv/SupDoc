import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Appointment extends JFrame {



	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String reason = "";
	Doctor doc;
	Patient patient;
	int duration = 0;
	
	
	public static Connection myConn;
	
	public Appointment () {
		initialize();
	}
	
	public static void getDay () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select days from Appointment" ); /////////////////////where user = "++++++";
		
			while (myRs1.next()) {
				//display to test
				System.out.println("Day of Appointment: " + myRs1.getString("days"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getHour () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select hours from Appointment" ); /////////////////////where user = "++++++";
		
			while (myRs1.next()) {
				//display to test
				System.out.println("Hour of Appointment: " + myRs1.getString("hours"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public static void getReason () {
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			ResultSet myRs1 = Stmt.executeQuery("select reason from Appointment" ); /////////////////////where user = "++++++";
		
			while (myRs1.next()) {
				//display to test
				System.out.println("Reason of Appointment: " + myRs1.getString("reason"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment frame = new Appointment();
					Appointment ap = new Appointment();
					ap.getReason();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {

		
		
	}

}
