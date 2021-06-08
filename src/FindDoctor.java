import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;
import java.awt.Dimension;

public class FindDoctor {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FindDoctor window = new FindDoctor();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FindDoctor() {
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
		
		JPanel panel = new JPanel() {
			public Dimension getPreferredSize() {
				return new Dimension(700, 700);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			}
		};
		
		
		ArrayList<ArrayList<String>> nearD = Patient.getNearByDoctors();
		for(int i=0; i<nearD.size(); i++) {
			//JButton btn1 = new JButton("<html>Όνομα Ειδοποίησης<br/>Λεπτομέρειες</html>");
			String docInfo = nearD.get(i).get(1) + " "+ nearD.get(i).get(2) +" "+ nearD.get(i).get(3);
			JButton btn1 = new JButton(docInfo);
			btn1.setBackground(SystemColor.control);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			btn1.setForeground(SystemColor.textInactiveText);
			btn1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
			btn1.setBounds(0, 0+i*70, 262, 70);
			panel.add(btn1);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
		
		JScrollPane sp = new JScrollPane((Component) null);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(22, 211, 220, 226);
		frame.getContentPane().add(sp);
		

		panel.setLayout(null);
		sp.setViewportView(panel);
		
		
	}
}
