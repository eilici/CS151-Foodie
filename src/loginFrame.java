package Foodie;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//edit 4-30-2023 Elena Ilic - remove no decoration declaration
//                          - set text areas to not editable
//                          - set resizable false


public class loginFrame extends JFrame {
	
	private Image img_logo = new ImageIcon(loginFrame.class.getResource("/com/foodie/resources/SpartanSpirit[2color]_uncoated.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 475);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 208, 200, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 5, 180, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(72, 249, 200, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setEchoChar('*');
		pwdPassword.setBounds(10, 5, 180, 20);
		panel_1.add(pwdPassword);
		
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(10, 50, 100, 100);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JPanel panel_3 = new JPanel();
		panel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel_3.setBackground(new Color(0, 85, 168));
		panel_3.setBounds(107, 306, 110, 41);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 90, 30);
		panel_3.add(lblNewLabel);
		
		JTextArea txtrSjsuFoodieApp = new JTextArea();
		txtrSjsuFoodieApp.setEditable(false);
		txtrSjsuFoodieApp.setForeground(new Color(0, 85, 168));
		txtrSjsuFoodieApp.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 35));
		txtrSjsuFoodieApp.setText("SJSU\r\nFoodie App");
		txtrSjsuFoodieApp.setBounds(120, 62, 152, 88);
		contentPane.add(txtrSjsuFoodieApp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 85, 168));
		panel_2.setBounds(311, 0, 445, 475);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea txtrWelcomeSpartanTo = new JTextArea();
		txtrWelcomeSpartanTo.setEditable(false);
		txtrWelcomeSpartanTo.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 35));
		txtrWelcomeSpartanTo.setForeground(new Color(255, 255, 255));
		txtrWelcomeSpartanTo.setText("Welcome, Spartan\r\nTo the SJSU Foodie App!");
		txtrWelcomeSpartanTo.setBackground(new Color(0, 85, 168));
		txtrWelcomeSpartanTo.setBounds(54, 160, 339, 76);
		panel_2.add(txtrWelcomeSpartanTo);
		
		JTextArea txtrFirstTime = new JTextArea();
		txtrFirstTime.setText("First time?");
		txtrFirstTime.setEditable(false);
		txtrFirstTime.setForeground(Color.WHITE);
		txtrFirstTime.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 30));
		txtrFirstTime.setBackground(new Color(0, 85, 168));
		txtrFirstTime.setBounds(158, 277, 141, 30);
		panel_2.add(txtrFirstTime);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(234, 172, 53));
		panel_4.setBounds(168, 318, 100, 40);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setBounds(18, 11, 72, 30);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 85, 168));
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		lblNewLabel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel lblXexit = new JLabel("X");
		lblXexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblXexit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblXexit.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to close this window?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					loginFrame.this.dispose();
				}
			}
		});
		lblXexit.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblXexit.setForeground(Color.WHITE);
		lblXexit.setBounds(430, 0, 15, 24);
		panel_2.add(lblXexit);
		
		
		
	}
}
