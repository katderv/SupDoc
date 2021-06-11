import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;


public class SignUpPatient {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JTextField textField_5;
	
	private boolean passchecker; // check if password is strong
	// Image Path
	private String path=null;
	
	public void setPath(String input) {
		this.path=input;
	}
	public String getPath() {
		return this.path;
	}
	// End Image Path

	/**
	 * Create the application.
	 */
	public SignUpPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 10, 74, 71);
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logo_signup.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(91, 24, 146, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(157, 77, 80, 55);
		frame.getContentPane().add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		
		JButton btnNewButton = new JButton("\u0391\u03BD\u03AD\u03B2\u03B1\u03C3\u03BC\u03B1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
				chooser.addChoosableFileFilter(filter);
				int result=chooser.showOpenDialog(btnNewButton);
				if(result==JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					String filename= f.getAbsolutePath();
					ImageIcon icon= new ImageIcon(filename);
					Image image= icon.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
					icon = new ImageIcon(image);
					lblNewLabel_2.setIcon(icon);
					setPath(filename);
					
					
				}
				else if (result==JFileChooser.CANCEL_OPTION) {
					System.out.println("Δεν έχει επιλεχθεί αρχείο.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textInactiveText);
		btnNewButton.setBounds(157, 137, 80, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("<html>\u03A0\u03C1\u03BF\u03C3\u03B8\u03AD\u03C3\u03C4\u03B5<br/>\u03A6\u03C9\u03C4\u03BF\u03B3\u03C1\u03B1\u03C6\u03AF\u03B1</html>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 103, 127, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.textInactiveText);
		textField.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(SystemColor.control);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField.setBounds(38, 169, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("\u038C\u03BD\u03BF\u03BC\u03B1")) {
                	textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().isEmpty()) {
                	textField.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
                }
            }
        });
		
		textField_1 = new JTextField();
		textField_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		textField_1.setBounds(38, 200, 184, 20);
		textField_1.setForeground(SystemColor.textInactiveText);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBackground(SystemColor.control);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_1.getText().equals("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF")) {
                	textField_1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_1.getText().isEmpty()) {
                	textField_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
                }
            }
        });
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(38, 231, 184, 20);
		txtEmail.setForeground(SystemColor.textInactiveText);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBackground(SystemColor.control);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		frame.getContentPane().add(txtEmail);
		txtEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (txtEmail.getText().equals("Email")) {
                	txtEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail.getText().isEmpty()) {
                	txtEmail.setText("Email");
                }
            }
        });
		txtEmail.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setText("password");
		passwordField.setForeground(SystemColor.textInactiveText);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		passwordField.setBounds(38, 262, 184, 20);
		passwordField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("password")) {
                	passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().isEmpty()) {
                	passwordField.setText("password");
                }
                else { // not Empty Password
                	passchecker= SignUpPatient.strongPassChecker(passwordField.getText());
                	if(passchecker==false) {
                		JOptionPane.showMessageDialog(frame,"Ασθενής κωδικός.\nΠρέπει να περιέχει 1 γράμμα, 1 νούμερα και να έχει τουλάχιστον 8 χαρακτήρες.");
                	}
                }
            }
        });
		frame.getContentPane().add(passwordField);
		
		/*// Date of Birth - Old Version
		textField_2 = new JTextField();
		textField_2.setText("--/--/--");
		textField_2.setBounds(0, 293, 182, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setForeground(SystemColor.textInactiveText);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBackground(SystemColor.control);
		textField_2.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_2.getText().equals("--/--/--")) {
                	textField_2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_2.getText().isEmpty()) {
                	textField_2.setText("--/--/--");
                }
            }
        });
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		*/
		
		textField_4 = new JTextField();
		textField_4.setText("\u03A0\u03CC\u03BB\u03B7");
		textField_4.setBounds(38, 355, 184, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setForeground(SystemColor.textInactiveText);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setBackground(SystemColor.control);
		textField_4.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_4.getText().equals("\u03A0\u03CC\u03BB\u03B7")) {
                	textField_4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_4.getText().isEmpty()) {
                	textField_4.setText("\u03A0\u03CC\u03BB\u03B7");
                }
            }
        });
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		
		textField_5 = new JTextField();
		textField_5.setText("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE");
		textField_5.setForeground(SystemColor.textInactiveText);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_5.setBackground(SystemColor.menu);
		textField_5.setBounds(38, 385, 184, 20);
		frame.getContentPane().add(textField_5);
		textField_5.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_5.getText().equals("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE")) {
                	textField_5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_5.getText().isEmpty()) {
                	textField_5.setText("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE");
                }
            }
        });
		
		
		JComboBox genderBox = new JComboBox();
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Γυναίκα", "’νδρας", "’λλο"}));
		genderBox.setBounds(38, 324, 184, 21);
		frame.getContentPane().add(genderBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(38, 294, 184, 19);
		frame.getContentPane().add(dateChooser);
		
				

		btnNewButton_1 = new JButton("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("\u038C\u03BD\u03BF\u03BC\u03B1")|| textField_1.getText().equals("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF") || passwordField.getText().equals("password")|| textField_4.getText().equals("\u03A0\u03CC\u03BB\u03B7") ||textField_5.getText().equals("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE")|| ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty() ) { //|| getPath()==null 				
					JOptionPane.showMessageDialog(frame,"Συμπληρώστε όλα τα πεδία.");
					return;
				}
				passchecker= SignUpPatient.strongPassChecker(passwordField.getText());
            	if(passchecker==false) {
            		JOptionPane.showMessageDialog(frame,"Δεν μπορεί να γίνει εγγραφή.\nΣυμπληρώστε σωστά τα πεδία.");
            		return;
            	}
				
								
				//Date of Birth
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");				
				String sel_dob=sdf.format(dateChooser.getDate()); //get date of birth
				if(isValidDOB(LocalDate.parse(sel_dob))==false) {
					JOptionPane.showMessageDialog(frame,"Μη αποδεκτή ημ/νία γέννησης.");
					return;
				}
				
				//Text Fields
				String name = textField.getText();
				String surname= textField_1.getText();	
				String password =passwordField.getText();
				String gender = (String)genderBox.getSelectedItem();
				String city = textField_4.getText();
				String region = textField_5.getText();
				
				//Email
				String email=null;
				if(isValid(txtEmail.getText())) {
					email= txtEmail.getText(); // make sure valid email
				}
				else {
					JOptionPane.showMessageDialog(frame,"Μη αποδεκτό email.");
					return;
				}
				
				/* // Date of Birth - Old Version
				String dob= textField_2.getText(); // make sure valid date of birth
				boolean check_dob=false;
				try {
					System.out.println(dob);
					String[] temp=dob.split("/");					
					System.out.println(temp[0]+temp[1]+temp[2]);
					dob=LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0])).toString();
					System.out.println("=="+dob);
					if(isValidDOB(LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0])))) {
						System.out.println("ch");
						check_dob=true;
					}
					else {
						JOptionPane.showMessageDialog(frame,"Invalid date of birth");
					}
				}
		        catch (Exception e2) {
		        	JOptionPane.showMessageDialog(frame,"Invalid date of birth");
		        }	
		        */	
				
				
				// EVERYTHING IS OKAY AND CHECKED
				// INSERT ALL INFO INTO DATABASE
				java.sql.Statement st;
				
				try {// insert patient to database						
					Connection myConn= DriverManager.getConnection("jdbc:sqlite:SupDocDB.db");
					st = myConn.createStatement();
					String q="INSERT INTO Patient VALUES('"+email+"','"+password+"','"+name+"','"+surname+"','"+sel_dob+"','"+gender+"','"+city+"','"+region+"',NULL,'true');";			
					st.execute(q);		
					st.close();
					
					/*
					PreparedStatement ps = myConn.prepareStatement("UPDATE Patient SET profPhoto = ? WHERE email = ?");
					//Image		
					//String p=getPath();
					//p=p.replace("\\", "\\\\");
					//System.out.println(p);
					//InputStream is = new FileInputStream(new File(getPath()));	
					//System.out.println(email);
					BufferedImage image;
					try {
						image = ImageIO.read(new File(getPath()));
						 //convert image to byte[]
		                ByteArrayOutputStream output = new ByteArrayOutputStream();
		                ImageIO.write(image , "jpg" , output);
		                byte[] img = output.toByteArray();
		                Blob blob = new SerialBlob(img);
		                ps.setBlob(1, blob);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}               
					
					//ps.setBlob(1,is);
					ps.setString(2, email);
					ps.executeUpdate();
					*/						
					
				}catch( SQLException e1){
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Ανεπιτυχης εγγραφή.");
					return;
					
				}				
				JOptionPane.showMessageDialog(frame,"Επιτυχής εγγραφή.");
				
				//Going to patient menu
				login.email=email;
				login.name=name;
				patient_menu window = new patient_menu();
				window.frame_patient_menu.setVisible(true);
				frame.dispose();
			
					
					
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1.setBounds(91, 415, 104, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
		
		
	}
	
	public static boolean isValid(String input_email){ // checking if email is valid
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";                              
        Pattern patt = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        if (input_email == null)
            return false;
        return patt.matcher(input_email).matches(); //returns true if correct
    }
	
	public static boolean isValidDOB(LocalDate input_dob){ // checking if date of birth is valid
        LocalDate today=LocalDate.now();  
        if(today.compareTo(input_dob)>=0)
        	return true;
        else
        	return false;
    }
	
	public static boolean strongPassChecker(String password) { // checks if the password is strong enough
		 boolean letter = false;
	     boolean digit = false;
		 if (password.length() >= 8) {
           for (int i = 0; i < password.length(); i++) {
               char x = password.charAt(i);
               if (Character.isLetter(x)) { // checks if there is a letter
                   letter = true;
               }
               else if (Character.isDigit(x)) {// checks if there is a digit
                   digit = true;
               }	                
               if(letter && digit){ // no need to check further, break the loop
                   break;
               }
           }
           if (letter && digit) { // STRONG
               return true;
           } else {// NOT STRONG
               return false;
           }
       }
		else{ // DOES NOT HAVE AT LEST 8 CHARACTERS
           return false;
       }
   } // end strongPassChecker
}
