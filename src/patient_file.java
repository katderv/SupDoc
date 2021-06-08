import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class patient_file {

	public JFrame frame;

	

	/**
	 * Create the application.
	 */
	public patient_file() {
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
		
		JLabel lblNewLabel_1 = new JLabel("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD");
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(SystemColor.inactiveCaption);
		lblNewLabel_1.setBounds(0, 0, 274, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel() {
			
			
			@Override
		    public Dimension getPreferredSize() {
		        return new Dimension(1000, 700);
		    };
		};
		
		frame.getContentPane().add(panel);
		
		for(int i=0; i<10; i++) {
			JButton btnNewButton = new JButton("<html>Όνομα Επώνυμο<br/>38 ετών<br/>Αθήνα<br/>Γυναίκα</html>");
			btnNewButton.setBackground(SystemColor.control);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setForeground(SystemColor.textInactiveText);
			//btnNewButton.setForeground();
			btnNewButton.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
			btnNewButton.setBounds(0, 0+i*70, 262, 70);
			panel.add(btnNewButton);
			Image img = new ImageIcon(this.getClass().getResource("/avatar1.png")).getImage();
			btnNewButton.setIcon(new ImageIcon(img));
			}
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setLayout(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(1, 38, 263, 406);
		frame.getContentPane().add(scrollPane);
		
	
	}
}
