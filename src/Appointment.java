import java.time.LocalDate;
import java.time.LocalTime;
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

public class Appointment {

	private LocalDate day = LocalDate.now();
	private LocalTime hour = LocalTime.now();
	private String reason = "";
	//Doctor doc;
	//Patient patient;
	int duration = 0;
	
	public LocalDate getDay () {
		return day;
	}
	
	public LocalTime getHour () {
		return hour;
	}
	
	public String getReason () {
		return reason;
	}
	
	public void setReason () {
		reason = "Check Up";
	}
	
}