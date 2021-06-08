import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;
import java.awt.Dimension;

public class FindDoctor {

	public JFrame frame;

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
		
		JLabel btnNewButton_3 = new JLabel("");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_3.setBounds(22, 10, 224, 180);
		frame.getContentPane().add(btnNewButton_3);
		//Image img1 = new ImageIcon(this.getClass().getResource("/map.png")).getImage();
		//btnNewButton_3.setIcon(new ImageIcon(img1));
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/map.png"));
		Image image = icon.getImage().getScaledInstance(btnNewButton_3.getWidth(), btnNewButton_3.getHeight(), Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);
		btnNewButton_3.setIcon(icon);
		
		JPanel panel = new JPanel() {
			public Dimension getPreferredSize() {
				return new Dimension(700, 700);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			}
		};
		
		
		ArrayList<ArrayList<String>> nearD = Patient.getNearByDoctors();
		for(int i=0; i<nearD.size(); i++) {
			//JButton btn1 = new JButton("<html>Όνομα Ειδοποίησης<br/>Λεπτομέρειες</html>");
			String docInfo = "<html>"+(i+1) +  ". "+nearD.get(i).get(1) + " "+ nearD.get(i).get(2) +"<br>"+ nearD.get(i).get(3)+"</html>";
			JButton btn1 = new JButton(docInfo);
			btn1.setBackground(SystemColor.control);
			btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			btn1.setForeground(SystemColor.textInactiveText);
			btn1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
			btn1.setBounds(0, 0+i*70, 262, 70);
			panel.add(btn1);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			
			btn1.addActionListener(new ActionListener() { //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								String b_text = btn1.getText();
								String[] dem = b_text.split(">|\\.");
								//System.out.println(dem[1]);
								int indx= Integer.parseInt(dem[1]) -1;
								BookAppointment window = new BookAppointment(nearD.get(indx).get(0));
								
								//System.out.println(dem[0]);
								//window.setEmail(dem[0]); //<<<<<<<<<<<<<<<<<<<
								//System.out.println("<3"+window.getEmail());
								window.frame.setVisible(true);
								frame.dispose();
								
							
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
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
