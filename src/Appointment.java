import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Appointment extends JFrame {

	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String reason = "";
	Doctor doc;
	Patient patient;
	int duration = 0;
	
	
	public static Connection myConn;
	JFrame frame = new JFrame();
	
	
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
	

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(230, 5, 29, 29);
		frame.getContentPane().add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 55, 220, 195);
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/book_appointment.png")).getImage();
		Image newImage =  img.getScaledInstance(245, 210, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(newImage));
		
		
		JLabel lblNewLabel_1 = new JLabel("<html>Ημ/νια</html>");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 260, 91, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JTextField textField = new JTextField();
		textField.setForeground(SystemColor.textInactiveText);
		textField.setText("15/03/2020");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(SystemColor.control);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField.setBounds(131, 261, 91, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Όνομα")) {
                	textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().isEmpty()) {
                	textField.setText("Όνομα");
                }
            }
        });
		///////////////////////
		
		JLabel lblNewLabel_2 = new JLabel("<html>Ώρα</html>");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 330, 91, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		///////////////////////
		///combo box probably
		///////////////////////
		
		JLabel lblNewLabel_3 = new JLabel("<html>Λόγος<br/> Επίσκεψης</html>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(35, 400, 91, 35);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		///////////////////////
		///combo box probably
		///////////////////////
		
	}

}
