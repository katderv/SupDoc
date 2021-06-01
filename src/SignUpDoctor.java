import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SignUpDoctor {

	public JFrame frame_SignUpDoctor;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpDoctor window = new SignUpDoctor();
					window.frame_SignUpDoctor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpDoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_SignUpDoctor = new JFrame();
		frame_SignUpDoctor.setResizable(false);
		frame_SignUpDoctor.setBounds(100, 100, 280, 484); // **change height from 484 to 820 to see the whole Frame
		frame_SignUpDoctor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_SignUpDoctor.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(0, 0, 270, 484); // **change height from 484 to 820 to see the whole Frame
		frame_SignUpDoctor.getContentPane().add(scrollPane_1);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setPreferredSize(new Dimension(20, 820));
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(16, 10, 74, 71);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/logo_signup.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE");
		lblNewLabel_1.setBounds(87, 24, 146, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(153, 89, 65, 43);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		Image img2 = new ImageIcon(this.getClass().getResource("/photo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		
		
		JButton btnNewButton = new JButton("upload");
		btnNewButton.setBounds(153, 137, 65, 23);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textInactiveText);
		
		JLabel lblNewLabel_3 = new JLabel("<html>\u03A0\u03C1\u03BF\u03C3\u03B8\u03AD\u03C3\u03C4\u03B5<br/>\u03A6\u03C9\u03C4\u03BF\u03B3\u03C1\u03B1\u03C6\u03AF\u03B1</html>");
		lblNewLabel_3.setBounds(16, 103, 127, 40);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(34, 182, 184, 20);
		panel.add(textField);
		textField.setForeground(SystemColor.textInactiveText);
		textField.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(SystemColor.control);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(34, 213, 182, 20);
		panel.add(textField_1);
		textField_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		textField_1.setForeground(SystemColor.textInactiveText);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBackground(SystemColor.control);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_1.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(34, 244, 182, 20);
		panel.add(txtEmail);
		txtEmail.setText("Email");
		txtEmail.setForeground(SystemColor.textInactiveText);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBackground(SystemColor.control);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
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
		passwordField.setBounds(34, 275, 182, 20);
		panel.add(passwordField);
		passwordField.setText("password");
		passwordField.setForeground(SystemColor.textInactiveText);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		
		textField_2 = new JTextField();
		textField_2.setBounds(34, 306, 182, 20);
		panel.add(textField_2);
		textField_2.setText("--/--/--");
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
		textField_3.setBounds(34, 337, 182, 20);
		panel.add(textField_3);
		textField_3.setText("\u03A6\u03CD\u03BB\u03BF");
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
		textField_4.setBounds(34, 368, 182, 20);
		panel.add(textField_4);
		textField_4.setText("\u03A0\u03CC\u03BB\u03B7");
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
		btnNewButton_1.setBounds(73, 739, 104, 27);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textInactiveText);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u0399\u03B1\u03C4\u03C1\u03BF\u03CD");
		lblNewLabel_3_1.setBounds(34, 409, 184, 27);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(34, 435, 184, 2);
		panel.add(lblNewLabel_4);
		Image img3 = new ImageIcon(this.getClass().getResource("/signUpDoc_bar.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		
		textField_5 = new JTextField();
		textField_5.setBounds(34, 458, 184, 20);
		panel.add(textField_5);
		textField_5.setText("\u0395\u03B9\u03B4\u03B9\u03BA\u03CC\u03C4\u03B7\u03C4\u03B1");
		textField_5.setForeground(SystemColor.textInactiveText);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_5.setBackground(SystemColor.menu);
		
		textField_6 = new JTextField();
		textField_6.setBounds(34, 494, 184, 20);
		panel.add(textField_6);
		textField_6.setText("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		textField_6.setForeground(SystemColor.textInactiveText);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_6.setBackground(SystemColor.menu);
		
		textField_7 = new JTextField();
		textField_7.setBounds(34, 534, 109, 20);
		panel.add(textField_7);
		textField_7.setText("\u03A0\u03B5\u03C1\u03B9\u03BF\u03C7\u03AE");
		textField_7.setForeground(SystemColor.textInactiveText);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_7.setBackground(SystemColor.menu);
		
		textField_8 = new JTextField();
		textField_8.setBounds(153, 534, 65, 20);
		panel.add(textField_8);
		textField_8.setText("\u03A4.\u039A.");
		textField_8.setForeground(SystemColor.textInactiveText);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_8.setBackground(SystemColor.menu);
		
		textField_9 = new JTextField();
		textField_9.setBounds(34, 571, 184, 20);
		panel.add(textField_9);
		textField_9.setText("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF \u0399\u03B1\u03C4\u03C1\u03B5\u03AF\u03BF\u03C5");
		textField_9.setForeground(SystemColor.textInactiveText);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_9.setBackground(SystemColor.menu);
		
		textField_10 = new JTextField();
		textField_10.setBounds(34, 609, 184, 20);
		panel.add(textField_10);
		textField_10.setText("\u039A\u03B9\u03BD\u03B7\u03C4\u03CC");
		textField_10.setForeground(SystemColor.textInactiveText);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
		textField_10.setBackground(SystemColor.menu);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(34, 657, 5, 5);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_5.setIcon(new ImageIcon(img3));
		
		lblNewLabel_6 = new JLabel("<html>\u0391\u03BD\u03B5\u03B2\u03AC\u03C3\u03C4\u03B5 \u03C4\u03BF \u03B1\u03C0\u03B1\u03C1\u03B1\u03AF\u03C4\u03B7\u03C4\u03BF<br/>\u03AD\u03B3\u03B3\u03C1\u03B1\u03C6\u03BF \u03B2\u03B5\u03B2\u03B1\u03AF\u03C9\u03C3\u03B7\u03C2 \u03C4\u03B7\u03C2<br>\u03B5\u03C0\u03B1\u03B3\u03B3\u03B5\u03BB\u03BC\u03B1\u03C4\u03B9\u03BA\u03AE\u03C2 \u03C3\u03B1\u03C2<br>\u03BA\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7\u03C2.</html>");
		lblNewLabel_6.setBounds(34, 650, 143, 59);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JButton btnNewButton_2 = new JButton("upload");
		btnNewButton_2.setBounds(153, 686, 88, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(SystemColor.textInactiveText);
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
		
		
	}
}
