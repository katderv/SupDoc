import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiaryMain {

	public JFrame frame;
	public static  double height;

	
	/**
	 * Create the application.
	 */
	public DiaryMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddDiaryEntry window = new AddDiaryEntry();
							window.frame.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_1.setBounds(213, 0, 51, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BB\u03CC\u03B3\u03B9\u03BF \u03A3\u03C5\u03BC\u03C0\u03C4\u03C9\u03BC\u03B1\u03C4\u03BF\u03BB\u03BF\u03B3\u03AF\u03B1\u03C2           ");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setBounds(0, 0, 264, 38);
		frame.getContentPane().add(lblNewLabel);
		
	

		 for(int i=0; i<patient_menu.diar.getDiaryEntries().size(); i++) {
			JButton btnNewButton = new JButton(patient_menu.diar.getDiaryEntries().get(i).getTitle());
			btnNewButton.setBackground(SystemColor.control);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setForeground(SystemColor.textInactiveText);
			btnNewButton.setBounds(0, 37+i*37, 264, 38);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {		
								height = btnNewButton.getHeight();
								System.out.println(height);
								height = (height-37)/37;
								
								SeeDiaryEntry window = new SeeDiaryEntry();
								window.frame.setVisible(true);
								frame.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			frame.getContentPane().add(btnNewButton);
			}
		
	}
}
