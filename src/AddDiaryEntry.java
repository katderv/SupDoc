import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddDiaryEntry {

	public JFrame frame;
	private JTextField textField;

	
	/**
	 * Create the application.
	 */
	public AddDiaryEntry() {
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
		
		JLabel lblNewLabel = new JLabel("\u03A4\u03AF\u03C4\u03BB\u03BF\u03C2:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setBounds(10, 30, 244, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u03A3\u03B7\u03BC\u03B5\u03B9\u03CE\u03C3\u03B5\u03B9\u03C2:");
		lblNewLabel_1.setBounds(10, 56, 82, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u03A3\u03B7\u03BC\u03B1\u03BD\u03C4\u03B9\u03BA\u03CC");
		chckbxNewCheckBox.setBounds(6, 384, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 74, 244, 303);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					java.sql.Statement Stmt = login.myConn.createStatement();
					int myRs1 = Stmt.executeUpdate("insert into PatientsDiaryEntry values('"+textField.getText()+"','"+textArea.getText()+"','"+chckbxNewCheckBox.isSelected()+"','"+login.email+"',TIME(),DATE())" );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				patient_menu window = new patient_menu();
				window.frame_patient_menu.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(165, 411, 89, 23);
		frame.getContentPane().add(btnNewButton);
	
	}
}
