import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class patient_menu {

	public JFrame frame_patient_menu;
	public static PatientsDiary diar;


	/**
	 * Create the application.
	 */
	public patient_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_patient_menu = new JFrame();
		frame_patient_menu.setResizable(false);
		frame_patient_menu.getContentPane().setBackground(SystemColor.control);
		frame_patient_menu.setBounds(100, 100, 280, 484);
		frame_patient_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_patient_menu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 69, 69);
		frame_patient_menu.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logo_small.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(230, 5, 29, 29);
		frame_patient_menu.getContentPane().add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame_patient_menu.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(189, 5, 34, 30);
		frame_patient_menu.getContentPane().add(btnNewButton_1);
		Image img3 = new ImageIcon(this.getClass().getResource("/chat.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_2.setBounds(150, 5, 30, 30);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		frame_patient_menu.getContentPane().add(btnNewButton_2);
		Image img4 = new ImageIcon(this.getClass().getResource("/notification.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1.setBounds(0, 0, 274, 38);
		frame_patient_menu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u039A\u03B1\u03BB\u03C9\u03C3\u03CC\u03C1\u03B9\u03C3\u03B5\u03C2 "+login.name+"!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 68, 254, 29);
		frame_patient_menu.getContentPane().add(lblNewLabel_2);
		
		JLabel btnNewButton_3 = new JLabel("");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_3.setBounds(25, 100, 224, 157);
		frame_patient_menu.getContentPane().add(btnNewButton_3);
		Image img5 = new ImageIcon(this.getClass().getResource("/calendar_patient.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img5));
		
		JButton btnNewButton_4 = new JButton("      \u0392\u03C1\u03B5\u03C2 \u03B9\u03B1\u03C4\u03C1\u03CC             ");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_4.setForeground(new Color(47, 79, 79));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_4.setBackground(new Color(220, 220, 220));
		btnNewButton_4.setBounds(30, 276, 215, 35);
		frame_patient_menu.getContentPane().add(btnNewButton_4);
		Image img6 = new ImageIcon(this.getClass().getResource("/doc_sch.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(img6));
		
		
		JButton btnNewButton_5 = new JButton("      \u03A4\u03BF \u03B9\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC \u03BC\u03BF\u03C5      ");
		btnNewButton_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		btnNewButton_5.setBackground(new Color(211, 211, 211));
		btnNewButton_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_5.setBounds(30, 310, 215, 35);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setForeground(new Color(47, 79, 79));
		frame_patient_menu.getContentPane().add(btnNewButton_5);
		Image img7 = new ImageIcon(this.getClass().getResource("/file.png")).getImage();
		btnNewButton_5.setIcon(new ImageIcon(img7));
		
		JButton btnNewButton_6 = new JButton("<html>&nbsp;&nbsp;&nbsp;&nbsp;      \u0397\u03BC\u03B5\u03C1\u03BF\u03BB\u03CC\u03B3\u03B9\u03BF<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\u03A3\u03C5\u03BC\u03C0\u03C4\u03C9\u03BC\u03B1\u03C4\u03BF\u03BB\u03BF\u03B3\u03AF\u03B1\u03C2                     </html>");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_6.setBackground(new Color(192, 192, 192));
		btnNewButton_6.setBounds(30, 344, 215, 35);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setForeground(new Color(47, 79, 79));
		frame_patient_menu.getContentPane().add(btnNewButton_6);
		Image img8 = new ImageIcon(this.getClass().getResource("/notebook.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon(img8));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							java.sql.Statement Stmt = login.myConn.createStatement();
							ResultSet myRs1 = Stmt.executeQuery("select * from PatientsDiaryEntry where '" + login.email + "'= patient" );
							ArrayList<DiaryEntry> entr = new ArrayList<DiaryEntry>();
							while (myRs1.next()) {
								DiaryEntry entry = new DiaryEntry(myRs1.getString("title"),LocalDate.parse(myRs1.getString("dat")), LocalTime.parse(myRs1.getString("timeOfEntry")),myRs1.getString("notes"), false );
								entr.add(entry);
							
						       }
							
							diar = new PatientsDiary(entr);
							DiaryMain window = new DiaryMain();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton btnNewButton_7 = new JButton("      \u039F\u03B9 \u03B9\u03B1\u03C4\u03C1\u03BF\u03AF \u03BC\u03BF\u03C5          ");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_7.setBackground(new Color(169, 169, 169));
		btnNewButton_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_7.setBounds(30, 378, 215, 35);
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setForeground(new Color(47, 79, 79));
		frame_patient_menu.getContentPane().add(btnNewButton_7);
		Image img9 = new ImageIcon(this.getClass().getResource("/hearth.png")).getImage();
		btnNewButton_7.setIcon(new ImageIcon(img9));

	}

}
