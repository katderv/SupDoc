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
		
		JButton btnNewButton = new JButton("\u039D\u03AD\u03BF\u03C2 \u0399\u03B1\u03C4\u03C1\u03CC\u03C2");
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
		
		
		
		
		JButton btnNewButton_1 = new JButton("\u0399\u03B1\u03C4\u03C1\u03CC\u03C2 \u03BC\u03BF\u03C5");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 240, 246, 171);
		frame.getContentPane().add(btnNewButton_1);
	}
}
