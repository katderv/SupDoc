import java.util.*;
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
	
	
  public static void main(String[] args) {	
	
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
	
  }

}