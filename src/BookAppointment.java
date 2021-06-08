import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class BookAppointment extends JFrame {

	public static Connection myConn;
	JFrame frame = new JFrame();
	private static ArrayList<ResultSet> rs;

	private String d_email = "haha";
	
	
	
	public void setEmail(String em) {
		this.d_email = em;
		
	}
	
	public String getEmail() {
		return this.d_email;
	}
	
	
	
	public BookAppointment() {
		initialize();
	}
	
	public BookAppointment (String email) {
		setEmail(email);
		initialize();
	}
	
	public static void main(String[] args) {
		try {
			BookAppointment window = new BookAppointment();
			window.frame.setVisible(true);
			//window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void initialize() {

		
		System.out.println(getEmail());
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
		lblNewLabel.setIcon(new ImageIcon(img));
		
		
		JLabel lblNewLabel_1 = new JLabel("<html>Ημ/νια</html>");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 270, 91, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JTextField textField = new JTextField();
		textField.setForeground(SystemColor.textInactiveText);
		textField.setText("15/03/2020");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(SystemColor.control);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField.setBounds(121, 270, 91, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);

		///////////////////////
		
		JLabel lblNewLabel_2 = new JLabel("<html>Ώρα</html>");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 310, 91, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox cb = new JComboBox();
		cb.setBounds(121, 310, 91, 25);
		cb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(cb);
		cb.addItem("9:00");
		cb.addItem("10:00");
		cb.addItem("11:00");
		cb.addItem("12:00");
		cb.addItem("13:00");
		((JLabel)cb.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		///////////////////////
		
		JLabel lblNewLabel_3 = new JLabel("<html>Λόγος<br/> Επίσκεψης</html>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 350, 91, 35);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setBounds(121, 360, 91, 25);
		frame.getContentPane().add(cb1);
		cb1.addItem("Check Up");
		cb1.addItem("None");
		///////////////////////
		
		JButton btnNewButton_1 = new JButton("Κλείσιμο Ραντεβού");
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(60, 420, 120, 20);
		frame.getContentPane().add(btnNewButton_1);
		((JLabel)cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// doc patient reasonO duration hoursO daysO id
							String day = textField.getText();
							String hour = (String) cb.getSelectedItem();
							String reason = (String) cb1.getSelectedItem();

							//myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
							//java.sql.Statement Stmt = myConn.createStatement();
							
							//ResultSet myRs1 = Stmt.executeQuery("insert into Appointment(doc,patient,reason,duration,hours,days) values ('kate@email.com','johnny@email.com', '" +reason+ "',	20 , '" +hour+"', '" +day+"'	");
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
	}
}
