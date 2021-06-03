import org.eclipse.swt.SWT;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.Statement;
import java.awt.event.WindowFocusListener;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;


public class Notification {
	
	private String title = "a";
	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String info = "yes";
	
	
	public JFrame frame;
	private JScrollPane scrollPane;
	
	public Notification () {
		initialize();
	}
	
	public String getTitle () {
		return title;
	}
	
	public static void addNotifications(ArrayList<Notification> a, Notification obj) {
		a.add(obj);
	  	//System.out.println("Its me! Your favorite notification!\n");
	}
	
	public static void getNotifications(ArrayList<Notification> a) {
		//System.out.println(a);
		for(Notification x:a)
			System.out.println(x.getTitle());
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(230, 5, 29, 29);
		frame.getContentPane().add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		

		JLabel lbl = new JLabel("Notifications");
		lbl.setForeground(new Color(245, 245, 245));
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setOpaque(true);
		lbl.setBackground(SystemColor.inactiveCaption);
		lbl.setBounds(10, 55, 240, 22);
		frame.getContentPane().add(lbl);
		
		JPanel panel = new JPanel() {
			
			@Override
		    public Dimension getPreferredSize() {
		        return new Dimension(700, 700);
		    };
		};
		
		panel.setBounds(20, 88, 220, 346);
		
		frame.getContentPane().add(panel);
		
		for(int i=0; i<20; i++) {
			JButton btn1 = new JButton("<html>Όνομα Ειδοποίησης<br/>Λεπτομέρειες</html>");
			btn1.setBackground(SystemColor.control);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			btn1.setForeground(SystemColor.textInactiveText);
			btn1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
			btn1.setBounds(0, 0+i*70, 262, 70);
			panel.add(btn1);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			}
		
		JScrollPane sp = new JScrollPane(panel);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setLayout(null);
		sp.setBounds(20, 90, 220, 325);
		frame.getContentPane().add(sp);
	}
}