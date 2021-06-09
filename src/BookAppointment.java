import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
import com.toedter.calendar.JDateChooser;

public class BookAppointment extends JFrame {

	public static Connection myConn;
	JFrame frame = new JFrame();
	private static ArrayList<ResultSet> rs;

	private String d_email = "haha";
	
	private String sel_date;
	
	ArrayList<Integer> booked_hours;
	
	//Setter for selected date
	public void setSelDate(String d) {
		this.sel_date = d;
	}
	
	
	// Setter for doctor email
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
	/*
	public static void main(String[] args) {
		try {
			BookAppointment window = new BookAppointment();
			window.frame.setVisible(true);
			//window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	private void initialize() {
		
		Appointment ap = new Appointment(); // Create empty Appointment
		
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
		
		
		JLabel lblNewLabel_1 = new JLabel("<html>\u0397\u03BC/\u03BD\u03AF\u03B1</html>");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 270, 91, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		/* Date - old version
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
		*/
		
		//initilize timeSlots
		ArrayList<Integer> timeSlots = new ArrayList<Integer>();
		for(int i=9;i<21;i++) {
			timeSlots.add(i);			
		}
		
		// Choose Date

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(120, 271, 92, 19);
		frame.getContentPane().add(dateChooser);
		
		// ComboBox Hours
		JComboBox cb = new JComboBox();
		cb.setBounds(121, 310, 91, 25);
		cb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(cb);		
		((JLabel)cb.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cb.addActionListener(new ActionListener() {//add Actionlistener to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String s = (String)cb.getSelectedItem();//get the selected item
		        System.out.println("s: "+s);
		        if(s!=null) {
		        	String [] s2= s.split(":");
			        String h;
			        if(s2[0].toString().equals("9")) {
			        	h= "09:00:00";
			        }
			        else {
			        	h= s2[0].toString()+":00:00";
			        }
			        ap.setHour(h);
		        }		        
		    }
		});
		
		
		
		//Action click ChooseDate
		dateChooser.getDateEditor().addPropertyChangeListener(
		    new PropertyChangeListener() {		    	
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		            //action
		        	if(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()==false) {
		        		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");				
						String sel_date=sdf.format(dateChooser.getDate());
						ap.setDate(sel_date); // Set Date for Appointment
						//System.out.println(ap.getDate());		
						
						booked_hours = Appointment.getHours(getEmail(), sel_date);
						//System.out.println("bh: "+booked_hours);
						timeSlots.removeAll(booked_hours);
						//System.out.println("After remove"+timeSlots);						
						
						cb.removeAllItems();
						for(int i=0; i<timeSlots.size();i++) {
							cb.addItem(timeSlots.get(i)+":00");			
						}
						//clear & initialization timeSlots
						timeSlots.clear();
						for(int i=9;i<21;i++) {
							timeSlots.add(i);			
						}
		    		}
					
		        }
		    });	

			

		///////////////////////
		
		JLabel lblNewLabel_2 = new JLabel("<html>\u038F\u03C1\u03B1</html>");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 310, 91, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		///////////////////////
		
		JLabel lblNewLabel_3 = new JLabel("<html>\u039B\u03CC\u03B3\u03BF\u03C2<br/>\u0395\u03C0\u03AF\u03C3\u03BA\u03B5\u03C8\u03B7\u03C2</html>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 350, 91, 35);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cb1.setBounds(121, 360, 91, 25);
		frame.getContentPane().add(cb1);
		cb1.addItem("Non-disclosed");
		cb1.addItem("Check Up");
		cb1.addItem("Emergency");
		cb1.addItem("None");
		///////////////////////
		
		JButton btnNewButton_1 = new JButton("\u039A\u03BB\u03B5\u03AF\u03C3\u03B9\u03BC\u03BF \u03A1\u03B1\u03BD\u03C4\u03B5\u03B2\u03BF\u03CD");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(60, 411, 120, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		((JLabel)cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// doc patient reasonO duration hoursO daysO id
							//String day = textField.getText();
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
