import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class Notification {
	
	private String title = "test";
	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String info = "yes";
	
	public static Connection myConn;
	public String information;
	
	public String getTitle () {
		return title;
	}
	
	
	public ArrayList<String> getNotifications() {
		ArrayList<String> not = new ArrayList<String>();
		
		try {
			myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
			java.sql.Statement Stmt = myConn.createStatement();
			
			String user_email = login.email;
			//String user_email = "johnny@email.com";
			ResultSet myRs1 = Stmt.executeQuery("select info from Notification where '" + user_email + "' = user_email" );

			while (myRs1.next()) {
				information = myRs1.getString("info");
				not.add(information);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(not);
		return not;
	}
}