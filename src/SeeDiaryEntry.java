import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class SeeDiaryEntry {

	public JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public SeeDiaryEntry() {
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
		
		DiaryEntry DiaryEntry = patient_menu.diar.getDiaryEntries().get((int) DiaryMain.height);
		textField = new JTextField(DiaryEntry.getTitle());
		textField.setEditable(false);
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setBounds(10, 30, 244, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Notes:");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Important");
		chckbxNewCheckBox.setSelected(DiaryEntry.getImp());		
		chckbxNewCheckBox.setBounds(6, 384, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		
		JTextArea textArea = new JTextArea(DiaryEntry.getNotes());
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(10, 74, 244, 303);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(165, 411, 89, 23);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton);
	}
}
