import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JPasswordField;

public class SignUpPatient {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton_1;

	/**
	 * Create the application.
	 */
	public SignUpPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 11, 74, 71);
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logo_signup.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(91, 25, 146, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(157, 90, 65, 43);
		frame.getContentPane().add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		
		JButton btnNewButton = new JButton("upload");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textInactiveText);
		btnNewButton.setBounds(157, 138, 65, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("<html>\u03A0\u03C1\u03BF\u03C3\u03B8\u03AD\u03C3\u03C4\u03B5<br/>\u03A6\u03C9\u03C4\u03BF\u03B3\u03C1\u03B1\u03C6\u03AF\u03B1</html>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 104, 127, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.textInactiveText);
		textField.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(SystemColor.control);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField.setBounds(38, 183, 184, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Όνομα")) {
                	textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().isEmpty()) {
                	textField.setText("Όνομα");
                }
            }
        });
		
		textField_1 = new JTextField();
		textField_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		textField_1.setBounds(38, 214, 182, 20);
		textField_1.setForeground(SystemColor.textInactiveText);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBackground(SystemColor.control);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_1.getText().equals("Επώνυμο")) {
                	textField_1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_1.getText().isEmpty()) {
                	textField_1.setText("Επώνυμο");
                }
            }
        });
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(38, 245, 182, 20);
		txtEmail.setForeground(SystemColor.textInactiveText);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBackground(SystemColor.control);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		frame.getContentPane().add(txtEmail);
		txtEmail.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (txtEmail.getText().equals("Email")) {
                	txtEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail.getText().isEmpty()) {
                	txtEmail.setText("Email");
                }
            }
        });
		txtEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText("password");
		passwordField.setForeground(SystemColor.textInactiveText);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		passwordField.setBounds(38, 276, 182, 20);
		passwordField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("password")) {
                	passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().isEmpty()) {
                	passwordField.setText("password");
                }
            }
        });
		frame.getContentPane().add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setText("--/--/--");
		textField_2.setBounds(38, 307, 182, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setForeground(SystemColor.textInactiveText);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setBackground(SystemColor.control);
		textField_2.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_2.getText().equals("--/--/--")) {
                	textField_2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_2.getText().isEmpty()) {
                	textField_2.setText("--/--/--");
                }
            }
        });
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		
		textField_3 = new JTextField();
		textField_3.setText("\u03A6\u03CD\u03BB\u03BF");
		textField_3.setBounds(38, 338, 182, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setForeground(SystemColor.textInactiveText);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setBackground(SystemColor.control);
		textField_3.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_3.getText().equals("Φύλο")) {
                	textField_3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_3.getText().isEmpty()) {
                	textField_3.setText("Φύλο");
                }
            }
        });
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		
		textField_4 = new JTextField();
		textField_4.setText("\u03A0\u03CC\u03BB\u03B7");
		textField_4.setBounds(38, 369, 182, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setForeground(SystemColor.textInactiveText);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setBackground(SystemColor.control);
		textField_4.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (textField_4.getText().equals("Πόλη")) {
                	textField_4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField_4.getText().isEmpty()) {
                	textField_4.setText("Πόλη");
                }
            }
        });
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		
		btnNewButton_1 = new JButton("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textInactiveText);
		btnNewButton_1.setBounds(77, 405, 104, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
}
