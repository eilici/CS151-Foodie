package com.foodie.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Component;

public class signUpFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtSignUp;
	private JTextField txtFirstName_1;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtSjsuId;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private JTextField txtLastName_1;
	private JTextField txtSjsuId_1;
	private JPasswordField pwdPassword;
	private JPasswordField pwdPassword_1;
	private JTextField txtSignUp_1;
	private JTextField txtYourPasswordShould;
	private JLabel lblNewLabel;
	
	private Image img_logo = new ImageIcon(main.class.getResource("/com/foodie/resources/SpartanSpirit[2color]_uncoated.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpFrame frame = new signUpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signUpFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setDoubleBuffered(false);
		contentPane.setBackground(new Color(0, 85, 168));
		contentPane.setBorder(new LineBorder(new Color(0, 85, 168)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(600, 0, 300, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 100, 100);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		panel.add(lblNewLabel);
		
		txtSignUp = new JTextField();
		txtSignUp.setBackground(new Color(0, 85, 168));
		txtSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUp.setBorder(null);
		txtSignUp.setForeground(new Color(255, 255, 255));
		txtSignUp.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 30));
		txtSignUp.setText("SPARTAN\r\n SIGN-UP");
		txtSignUp.setBounds(150, 11, 228, 66);
		contentPane.add(txtSignUp);
		txtSignUp.setColumns(10);
		
		txtFirstName_1 = new JTextField();
		txtFirstName_1.setBackground(new Color(229, 229, 229));
		txtFirstName_1.setText("First Name");
		txtFirstName_1.setBounds(150, 100, 250, 30);
		contentPane.add(txtFirstName_1);
		txtFirstName_1.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(0, 85, 168));
		txtFirstName.setBorder(null);
		txtFirstName.setForeground(new Color(255, 255, 255));
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtFirstName.setText("FIRST NAME:");
		txtFirstName.setBounds(10, 105, 130, 30);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBackground(new Color(0, 85, 168));
		txtLastName.setBorder(null);
		txtLastName.setForeground(new Color(255, 255, 255));
		txtLastName.setText("LAST NAME:");
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 155, 130, 30);
		contentPane.add(txtLastName);
		
		txtSjsuId = new JTextField();
		txtSjsuId.setBackground(new Color(0, 85, 168));
		txtSjsuId.setBorder(null);
		txtSjsuId.setText("SJSU ID:");
		txtSjsuId.setHorizontalAlignment(SwingConstants.CENTER);
		txtSjsuId.setForeground(new Color(255, 255, 255));
		txtSjsuId.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtSjsuId.setColumns(10);
		txtSjsuId.setBounds(10, 205, 130, 30);
		contentPane.add(txtSjsuId);
		
		txtPassword = new JTextField();
		txtPassword.setBackground(new Color(0, 85, 168));
		txtPassword.setBorder(null);
		txtPassword.setText("PASSWORD:");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 255, 130, 30);
		contentPane.add(txtPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setBackground(new Color(0, 85, 168));
		txtConfirmPassword.setBorder(null);
		txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmPassword.setText("CONFIRM PASSWORD:");
		txtConfirmPassword.setForeground(new Color(255, 255, 255));
		txtConfirmPassword.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(10, 360, 177, 56);
		contentPane.add(txtConfirmPassword);
		
		txtLastName_1 = new JTextField();
		txtLastName_1.setBackground(new Color(229, 229, 229));
		txtLastName_1.setText("Last Name");
		txtLastName_1.setColumns(10);
		txtLastName_1.setBounds(150, 150, 250, 30);
		contentPane.add(txtLastName_1);
		
		txtSjsuId_1 = new JTextField();
		txtSjsuId_1.setBackground(new Color(229, 229, 229));
		txtSjsuId_1.setText("SJSU ID");
		txtSjsuId_1.setColumns(10);
		txtSjsuId_1.setBounds(150, 200, 250, 30);
		contentPane.add(txtSjsuId_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(229, 229, 229));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(150, 250, 250, 30);
		contentPane.add(pwdPassword);
		
		pwdPassword_1 = new JPasswordField();
		pwdPassword_1.setBackground(new Color(229, 229, 229));
		pwdPassword_1.setText("Password");
		pwdPassword_1.setBounds(199, 365, 250, 30);
		contentPane.add(pwdPassword_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 85, 168));
		panel_1.setBounds(250, 430, 150, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtSignUp_1 = new JTextField();
		txtSignUp_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUp_1.setForeground(new Color(0, 85, 168));
		txtSignUp_1.setBackground(new Color(234, 172, 53));
		txtSignUp_1.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtSignUp_1.setText("SIGN - UP");
		txtSignUp_1.setBounds(0, -18, 150, 75);
		panel_1.add(txtSignUp_1);
		txtSignUp_1.setColumns(10);
		
		txtYourPasswordShould = new JTextField();
		txtYourPasswordShould.setDoubleBuffered(true);
		txtYourPasswordShould.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtYourPasswordShould.setHorizontalAlignment(SwingConstants.TRAILING);
		txtYourPasswordShould.setBounds(150, 291, 250, 66);
		txtYourPasswordShould.setText("Your Password Should Have: \r\n-Atleast 1 Uppercase Letter\r\n-Atleast 1 Lowercase Letter\r\n-1 Special Character\r\n-1 Numerical number\r\n-Minimum 8 characters.");
		contentPane.add(txtYourPasswordShould);
		txtYourPasswordShould.setColumns(10);
	}
}
