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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		dateChooser.getJCalendar().setMinSelectableDate(new Date());
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
						
						System.out.println("IS VALID");
						ap.setDate(sel_date); // Set Date for Appointment
						//System.out.println(ap.getDate());		
						
						booked_hours = Appointment.getHours(getEmail(), sel_date);
						//System.out.println("bh: "+booked_hours);
						timeSlots.removeAll(booked_hours);
						ArrayList<Integer >previous_hours=isValidHour(LocalDate.parse(sel_date));
						timeSlots.removeAll(previous_hours);
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
		// ComboBox Rason
		ap.setReason((String)cb1.getSelectedItem());/// <-
		cb1.addActionListener(new ActionListener() {//add Actionlistener to listen for change
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String r = (String)cb1.getSelectedItem();//get the selected item		        
		        if(r!=null) {
			        ap.setReason(r);
		        }	
		        System.out.println("r: "+r);
		    }
		});
		((JLabel)cb1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		///////////////////////
		
		JButton btnNewButton_1 = new JButton("\u039A\u03BB\u03B5\u03AF\u03C3\u03B9\u03BC\u03BF \u03A1\u03B1\u03BD\u03C4\u03B5\u03B2\u03BF\u03CD");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(60, 411, 120, 29);
		frame.getContentPane().add(btnNewButton_1);		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						/*
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
						*/
						
						System.out.println("Book Ap: Email_p: "+login.email+" Email_D: "+getEmail()+" Date: "+ap.getDate()+" Hour: "+ap.getHour()+" Reason: "+ap.getReason());
						try {
							//myConn = DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
							java.sql.Statement Stmt = login.myConn.createStatement();
							
							//insert Appointment into DB
							Stmt.execute("INSERT INTO Appointment(doc, patient, reason, duration, hours, days) VALUES ('"+getEmail()+"','"+login.email+"','"+ap.getReason()+"', 60,"+ap.getHour()+", '"+ap.getDate()+"');");
							Stmt.close();
							
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
							java.sql.Statement Stmt2 = login.myConn.createStatement();							
							ResultSet rs = Stmt2.executeQuery("SELECT nam, surname FROM Doctor WHERE email='"+getEmail()+"'; ");										
					        JOptionPane.showMessageDialog(frame,"Appointment booked with Dr. "+rs.getString("nam")+" "+rs.getString("surname")+" on "+formatter.format(ap.getDate())+" at "+ap.getHour()+":00 .");
					        
					        //insert Event into DB
					        java.sql.Statement Stmt3 = login.myConn.createStatement(); 
							String q="INSERT INTO Event_s VALUES('Appointment with "+rs.getString("nam")+" "+rs.getString("surname")+"','"+ap.getDate()+"', '"+ap.getHour()+":00:00', NULL );";			
							Stmt3.execute(q);
							
							//insert Notification into DB
							ap.addReminder(rs.getString("nam")+" "+rs.getString("surname"));
							
							rs.close();
							Stmt3.close();
							
							java.sql.Statement Stmt4 = login.myConn.createStatement(); 
							ResultSet c = Stmt4.executeQuery("SELECT COUNT(id) FROM Appointment WHERE doc = '"+getEmail()+"' AND patient = '"+login.email+"' ");										
					        if (Integer.parseInt(c.getString("COUNT(id)")) >= 3) {
					        	Doctor.addRegular(getEmail());
					        }
					        c.close();
							Stmt4.close();
					        // changing screens to patient menu
					        patient_menu window = new patient_menu();
							window.frame_patient_menu.setVisible(true);
							frame.dispose();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
			}
		});
		
	}
	
	public static ArrayList<Integer> isValidHour(LocalDate day){ // checking if date of appointment is valid
	    LocalTime timenow=LocalTime.now();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    if(day.compareTo(LocalDate.now())==0) {
	    	for(int i=9;i<21;i++) {
				if(timenow.getHour()>=i)
					temp.add(i);					
			}
	    }	
		return temp;
	}
	
	
}
