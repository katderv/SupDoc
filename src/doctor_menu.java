import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doctor_menu {

	public JFrame frame;

	
	public doctor_menu() {
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
		lblNewLabel.setBounds(0, 0, 69, 69);
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logo_small.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(230, 5, 29, 29);
		frame.getContentPane().add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBounds(189, 5, 34, 30);
		frame.getContentPane().add(btnNewButton_1);
		Image img3 = new ImageIcon(this.getClass().getResource("/chat.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_2.setBounds(150, 5, 30, 30);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(btnNewButton_2);
		Image img4 = new ImageIcon(this.getClass().getResource("/notification.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							NotificationList window1 = new NotificationList();
							window1.frame.setVisible(true);
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1.setBounds(0, 0, 274, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u039A\u03B1\u03BB\u03C9\u03C3\u03CC\u03C1\u03B9\u03C3\u03B5\u03C2 "+login.name+"!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 68, 254, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel btnNewButton_3 = new JLabel("");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_3.setBounds(25, 100, 224, 157);
		frame.getContentPane().add(btnNewButton_3);
		Image img5 = new ImageIcon(this.getClass().getResource("/doctor_schedule.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img5));
		
		JButton btnNewButton_4 = new JButton("   \u03A4\u03BF \u03C0\u03C1\u03CC\u03B3\u03C1\u03B1\u03BC\u03BC\u03AC \u03BC\u03BF\u03C5      ");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_4.setForeground(new Color(47, 79, 79));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_4.setBackground(new Color(220, 220, 220));
		btnNewButton_4.setBounds(30, 276, 215, 35);
		frame.getContentPane().add(btnNewButton_4);
		Image img6 = new ImageIcon(this.getClass().getResource("/doc_sch.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(img6));
		
		
		JButton btnNewButton_5 = new JButton("    \u0391\u03C1\u03C7\u03B5\u03AF\u03BF \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD        ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							patients_file window = new patients_file();
							window.frame.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_5.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_5.setBackground(new Color(211, 211, 211));
		btnNewButton_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_5.setBounds(30, 310, 215, 35);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setForeground(new Color(47, 79, 79));
		frame.getContentPane().add(btnNewButton_5);
		Image img7 = new ImageIcon(this.getClass().getResource("/file.png")).getImage();
		btnNewButton_5.setIcon(new ImageIcon(img7));
		
		JButton btnNewButton_6 = new JButton("    \u03A4\u03B1\u03BA\u03C4\u03B9\u03BA\u03BF\u03AF \u0391\u03C3\u03B8\u03B5\u03BD\u03B5\u03AF\u03C2       ");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_6.setBackground(new Color(192, 192, 192));
		btnNewButton_6.setBounds(30, 344, 215, 35);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_6.setForeground(new Color(47, 79, 79));
		frame.getContentPane().add(btnNewButton_6);
		Image img8 = new ImageIcon(this.getClass().getResource("/tactical_patients.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon(img8));
		
		JButton btnNewButton_7 = new JButton("         \u03A1\u03C5\u03B8\u03BC\u03AF\u03C3\u03B5\u03B9\u03C2             ");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_7.setBackground(new Color(169, 169, 169));
		btnNewButton_7.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton_7.setBounds(30, 378, 215, 35);
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setForeground(new Color(47, 79, 79));
		frame.getContentPane().add(btnNewButton_7);
		Image img9 = new ImageIcon(this.getClass().getResource("/settings.png")).getImage();
		btnNewButton_7.setIcon(new ImageIcon(img9));

		
		
		
		
		
	}
}
