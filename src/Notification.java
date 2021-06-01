import java.util.*;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Notification {
	
	String title = "a";
	LocalDate day = LocalDate.now();
	LocalTime hour = LocalTime.now();
	String info = "yes";
	
	public Notification () {	
	}
	
	public Notification (String t, LocalDate d, LocalTime h, String inf) {
		this.title = t;
		this.day = d;
		this.hour = h;
		this.info = inf;
	}
	
	String getTitle () {
		return title;
	}
	
	static void addNotifications(ArrayList<Notification> a, Notification obj) {
		a.add(obj);
	  	//System.out.println("Its me! Your favorite notification!\n");
	}
	
	static void getNotifications(ArrayList<Notification> a) {
		//System.out.println(a);
		for(Notification x:a)
			System.out.println(x.getTitle());
	}
	
	
  /*public static void main(String[] args) {	
	
	Notification n1 = new Notification();
	Notification n2 = new Notification("aspa",null,null,"money");
	
	ArrayList<Notification> notif = new ArrayList<Notification>();
	
	//notif.add(n1);
	//notif.add(n2);
	//System.out.println(n.day);
	//System.out.println(n.hour);
	
	addNotifications(notif, n1);
	addNotifications(notif, n2);
	
	getNotifications(notif);
	
  }*/

}