import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class transition_screen {

	public JFrame frame;


	/**
	 * Create the application.
	 */
	public transition_screen() {
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
		
		JButton btnNewButton = new JButton("Νέος Ιατρός");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 59, 246, 171);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FindDoctor window = new FindDoctor();
							window.frame.setVisible(true);
							frame.dispose();
							
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		
		
		JButton btnNewButton_1 = new JButton("Οι Ιατροί μου");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 240, 246, 171);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() { //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MyDoctors window1 = new MyDoctors();
							window1.frame.setVisible(true);
							frame.dispose();
							
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
