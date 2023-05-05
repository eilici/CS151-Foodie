package foodie;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

//edit 4-30-2023 Elena Ilic - remove no decoration declaration
//                          - set text to not editable
// edit 5-2-2023 Elena Ilic - replace labels with buttons
//                          - write actionlistener for buttons
public class LoginFrame extends JFrame implements ActionListener {

	private Image img_logo = new ImageIcon("src/foodie/SpartanSpirit[2color]_4cp.png").getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	private JButton sign;
	private JButton log;
	
	private DataBase data;

	private static ArrayList<User> users = Foodie.foodieUsers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LoginFrame() throws IOException {
		data = new DataBase();
		
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

		log = new JButton("LOG IN");
		log.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 20));
		log.setForeground(new Color(0, 85, 168));
		log.setBackground(new Color(234, 172, 53));
		log.setSize(110, 41);
		log.setLocation(107, 306);
		log.addActionListener(this);
		this.add(log);

		JTextArea txtrSjsuFoodieApp = new JTextArea();
		txtrSjsuFoodieApp.setForeground(new Color(0, 85, 168));
		txtrSjsuFoodieApp.setEditable(false);
		txtrSjsuFoodieApp.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 28));
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
		txtrWelcomeSpartanTo.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 28));
		txtrWelcomeSpartanTo.setForeground(new Color(255, 255, 255));
		txtrWelcomeSpartanTo.setText("Welcome, Spartan\r\nTo the SJSU Foodie App!");
		txtrWelcomeSpartanTo.setBackground(new Color(0, 85, 168));
		txtrWelcomeSpartanTo.setBounds(54, 168, 339, 76);
		panel_2.add(txtrWelcomeSpartanTo);

		JTextArea txtrFirstTime = new JTextArea();
		txtrFirstTime.setText("First time?");
		txtrFirstTime.setEditable(false);
		txtrFirstTime.setForeground(Color.WHITE);
		txtrFirstTime.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtrFirstTime.setBackground(new Color(0, 85, 168));
		txtrFirstTime.setBounds(170, 270, 141, 30);
		panel_2.add(txtrFirstTime);

		sign = new JButton("SIGN UP");
		sign.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 20));
		sign.setForeground(new Color(0, 85, 168));
		sign.setBackground(new Color(234, 172, 53));
		sign.setSize(120, 41);
		sign.setLocation(164, 306);
		sign.addActionListener(this);
		panel_2.add(sign);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == log) {
			if (txtUsername.getText().equals("Username") || txtUsername.getText().equals("")) {
				showMessageDialog(null, "Please enter a valid username.");
				return;
			}
			if (new String(pwdPassword.getPassword()).equals("Password")
					|| new String(pwdPassword.getPassword()).equals("")) {
				showMessageDialog(null, "Please enter a valid password.");
				return;
			} else {
				for (User u : users) {
					if (u.getUserName().equals(txtUsername.getText())
							&& u.getPassword().equals(new String(pwdPassword.getPassword()))) {
						HomeFrame h = new HomeFrame((Spartan) u);
						this.dispose();
						return;
					}
				}
				showMessageDialog(null, "User not found.");
			}
		}

		if (e.getSource() == sign) {
			try {
				SignupFrame s = new SignupFrame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}