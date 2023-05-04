package foodie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SignupFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtSignUp;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtUsernameEntry;
	private JPasswordField pwdPassword;
	private JTextField txtSignUp_1;
	private JTextField txtYourPasswordShould;
	private JLabel lblNewLabel;

	/*
	 * Change absolute file path to relative file path when editing please
	 */
	private Image img_logo = new ImageIcon("src/Foodie/SpartanSpirit[2color]_4cp.png").getImage().getScaledInstance(100,
			100, Image.SCALE_SMOOTH);
	private JTextField txtFoodieApp;
	private JTextField txtSjsu;
	private JTextField txtIAlreadyHave;
	private JTextField txtCharactersOne;
	private JTextField txtOneNumberAnd;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { signUpFrame frame = new signUpFrame();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 * 
	 * !!!!DELETE THIS AFTER TESTING!!!!
	 * 
	 */
	private HomeFrame homeframe;
	ArrayList<User> users = DataBase.foodieUsers;
	private DataBase data;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public SignupFrame() throws IOException {
		// init data
		data = new DataBase();

		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		lblNewLabel.setBounds(10, 150, 100, 100);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		panel.add(lblNewLabel);

		txtFoodieApp = new JTextField();
		txtFoodieApp.setEditable(false);
		txtFoodieApp.setText("FOODIE APP");
		txtFoodieApp.setHorizontalAlignment(SwingConstants.CENTER);
		txtFoodieApp.setForeground(new Color(0, 85, 168));
		txtFoodieApp.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 30));
		txtFoodieApp.setColumns(10);
		txtFoodieApp.setBorder(null);
		txtFoodieApp.setBackground(new Color(255, 255, 255));
		txtFoodieApp.setBounds(100, 192, 228, 66);
		panel.add(txtFoodieApp);

		txtSjsu = new JTextField();
		txtSjsu.setEditable(false);
		txtSjsu.setText("SJSU");
		txtSjsu.setHorizontalAlignment(SwingConstants.CENTER);
		txtSjsu.setForeground(new Color(0, 85, 168));
		txtSjsu.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 30));
		txtSjsu.setColumns(10);
		txtSjsu.setBorder(null);
		txtSjsu.setBackground(Color.WHITE);
		txtSjsu.setBounds(62, 150, 228, 66);
		panel.add(txtSjsu);

		txtIAlreadyHave = new JTextField();
		/*
		 * EVENT HANDLER FOR GOING BACK TO THE LOGIN PAGE AND EXITING SIGN UP PAGE
		 */
		txtIAlreadyHave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		txtIAlreadyHave.setText("I ALREADY HAVE AN ACCOUNT");
		txtIAlreadyHave.setEditable(false);
		txtIAlreadyHave.setHorizontalAlignment(SwingConstants.CENTER);
		txtIAlreadyHave.setForeground(new Color(0, 85, 168));
		txtIAlreadyHave.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 15));
		txtIAlreadyHave.setColumns(10);
		txtIAlreadyHave.setBorder(null);
		txtIAlreadyHave.setBackground(Color.WHITE);
		txtIAlreadyHave.setBounds(40, 261, 228, 66);
		panel.add(txtIAlreadyHave);

		txtSignUp = new JTextField();
		txtSignUp.setEditable(false);
		txtSignUp.setBackground(new Color(0, 85, 168));
		txtSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUp.setBorder(null);
		txtSignUp.setForeground(new Color(255, 255, 255));
		txtSignUp.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 30));
		txtSignUp.setText("SPARTAN\r\n SIGN-UP");
		txtSignUp.setBounds(150, 91, 228, 66);
		contentPane.add(txtSignUp);
		txtSignUp.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(0, 85, 168));
		txtUsername.setBorder(null);
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setText("USERNAME:");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtUsername.setColumns(10);
		txtUsername.setBounds(10, 208, 130, 30);
		contentPane.add(txtUsername);

		txtPassword = new JTextField();
		txtPassword.setBackground(new Color(0, 85, 168));
		txtPassword.setBorder(null);
		txtPassword.setText("PASSWORD:");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 254, 130, 30);
		contentPane.add(txtPassword);

		txtUsernameEntry = new JTextField();
		txtUsernameEntry.setBackground(new Color(229, 229, 229));
		txtUsernameEntry.setText("Username");
		txtUsernameEntry.setColumns(10);
		txtUsernameEntry.setBounds(150, 203, 250, 30);
		contentPane.add(txtUsernameEntry);

		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(229, 229, 229));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(150, 249, 250, 30);
		contentPane.add(pwdPassword);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 85, 168));
		panel_1.setBounds(230, 383, 150, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtSignUp_1 = new JTextField();
		txtSignUp_1.setEditable(false);
		setVisible(true);
		/*
		 * Action Listener for Sign Up Button Check if password is correct or if user
		 * credentials already exists.
		 */
		txtSignUp_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == txtSignUp_1) {
					PasswordChecker p = new PasswordChecker();

					// check username and password
					if (txtUsername.getText().equals("Username") || txtUsernameEntry.getText().equals("")) {
						showMessageDialog(null, "Please enter a valid username.");
						return;
					}

					for (User u : users) {
						if (u.getUserName().equals(txtUsernameEntry.getText())) {
							showMessageDialog(null, "Username is taken.");
							return;
						}
					}

					try {
						p.checkPassword(new String(pwdPassword.getPassword()));
					} catch (PasswordException ex) {
						ex.printStackTrace();
						showMessageDialog(null, "Password requirements not met: " + ex.getMessage());
						return;
					}

					// create new user from fields and add to list
					Preferences[] defaultPref = {Preferences.NONE};
					User newUser = new Spartan(txtUsernameEntry.getText(), new String(pwdPassword.getPassword()),
							defaultPref);
					users.add(newUser);
					System.out.println(users);
					if (users.contains(newUser)) {
					try {
						data.updateUsers();
					} catch (IOException e1) {
						System.out.println("Data exception");
						e1.printStackTrace();
					}
					}
					try {
						PrefPanel pref = new PrefPanel((Spartan) newUser, new HomeFrame((Spartan) newUser));
					} catch (IOException e1) {
						System.out.println("Data exception");
						e1.printStackTrace();
					}
					SignupFrame.this.dispose();

				}
			}
		});
		txtSignUp_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSignUp_1.setForeground(new Color(0, 85, 168));
		txtSignUp_1.setBackground(new Color(234, 172, 53));
		txtSignUp_1.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		txtSignUp_1.setText("SIGN - UP");
		txtSignUp_1.setBounds(0, -18, 150, 75);
		panel_1.add(txtSignUp_1);
		txtSignUp_1.setColumns(10);

		txtYourPasswordShould = new JTextField();
		txtYourPasswordShould.setBorder(null);
		txtYourPasswordShould.setBackground(new Color(0, 85, 168));
		txtYourPasswordShould.setForeground(new Color(255, 255, 255));
		txtYourPasswordShould.setDoubleBuffered(true);
		txtYourPasswordShould.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtYourPasswordShould.setHorizontalAlignment(SwingConstants.LEFT);
		txtYourPasswordShould.setBounds(150, 280, 118, 30);
		txtYourPasswordShould.setText("Your Password Should Have: \r\n");
		contentPane.add(txtYourPasswordShould);
		txtYourPasswordShould.setColumns(10);

		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(new Color(0, 58, 168));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to close this window?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
					SignupFrame.this.dispose();
				}
			}
		});
		lblExit.setForeground(new Color(0, 85, 168));
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExit.setBounds(287, 0, 13, 27);
		panel.add(lblExit);

		txtCharactersOne = new JTextField();
		txtCharactersOne.setText("8 Characters: one uppercase and lowercase letter");
		txtCharactersOne.setHorizontalAlignment(SwingConstants.LEFT);
		txtCharactersOne.setForeground(Color.WHITE);
		txtCharactersOne.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtCharactersOne.setDoubleBuffered(true);
		txtCharactersOne.setColumns(10);
		txtCharactersOne.setBorder(null);
		txtCharactersOne.setBackground(new Color(0, 85, 168));
		txtCharactersOne.setBounds(150, 302, 216, 30);
		contentPane.add(txtCharactersOne);

		txtOneNumberAnd = new JTextField();
		txtOneNumberAnd.setText("One number and one special character");
		txtOneNumberAnd.setHorizontalAlignment(SwingConstants.LEFT);
		txtOneNumberAnd.setForeground(Color.WHITE);
		txtOneNumberAnd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		txtOneNumberAnd.setDoubleBuffered(true);
		txtOneNumberAnd.setColumns(10);
		txtOneNumberAnd.setBorder(null);
		txtOneNumberAnd.setBackground(new Color(0, 85, 168));
		txtOneNumberAnd.setBounds(150, 321, 216, 30);
		contentPane.add(txtOneNumberAnd);
	}
}