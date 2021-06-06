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
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setBounds(10, 30, 244, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Notes:");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Important");
		chckbxNewCheckBox.setBounds(6, 384, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 74, 244, 303);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					java.sql.Statement Stmt = login.myConn.createStatement();
					int myRs1 = Stmt.executeUpdate("insert into PatientsDiaryEntry values('"+textField.getText()+"','"+textArea.getText()+"','"+chckbxNewCheckBox.isSelected()+"','"+login.email+"',TIME(),DATE())" );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(165, 411, 89, 23);
		frame.getContentPane().add(btnNewButton);
	
	}
}
