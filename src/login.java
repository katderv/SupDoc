import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowFocusListener;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 11, 186, 165);
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		txtEmail = new JTextField();	
		txtEmail.setCaretColor(Color.LIGHT_GRAY);
		txtEmail.setForeground(SystemColor.textInactiveText);
		txtEmail.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		txtEmail.setText("email");
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		txtEmail.setBackground(SystemColor.control);
		txtEmail.setBounds(34, 216, 186, 24);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (txtEmail.getText().equals("email")) {
                	txtEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail.getText().isEmpty()) {
                	txtEmail.setText("email");
                }
            }
        });
		
		 
		
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.textInactiveText);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBounds(34, 254, 186, 24);
		passwordField.setText("password");
		frame.getContentPane().add(passwordField);
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
            }
        });

		
		JButton btnNewButton = new JButton("\u03A3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// -> We need a condition here when the database is ready <-
				// If User is Doctor
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							doctor_menu window = new doctor_menu();
							window.frame.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				/*
				// If User is Patient
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							patient_menu window = new patient_menu();
							window.frame_patient_menu.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				//
				 */
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textInactiveText);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(64, 298, 126, 29);
		frame.getContentPane().add(btnNewButton);
		frame.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		    	btnNewButton.requestFocus();
		    }
		});
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("-\u03AE-");
		lblNewLabel_1.setForeground(SystemColor.textInactiveText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 338, 126, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE \u03C9\u03C2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(SystemColor.textInactiveText);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 377, 186, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\u0391\u03C3\u03B8\u03B5\u03BD\u03AE\u03C2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUpPatient window = new SignUpPatient();
							window.frame.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(20, 405, 106, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0399\u03B1\u03C4\u03C1\u03CC\u03C2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUpDoctor window = new SignUpDoctor();
							window.frame_SignUpDoctor.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_2.setBackground(SystemColor.textInactiveText);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBounds(138, 405, 106, 29);
		frame.getContentPane().add(btnNewButton_2);
	}
}
