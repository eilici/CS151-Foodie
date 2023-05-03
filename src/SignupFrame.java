package foodie;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import hw4.PasswordChecker;
import hw4.PasswordException;

//Created 5-2-2023 by Elena Ilic
public class SignupFrame extends JFrame implements ActionListener {

	private Container c;

	private JTextField username;
	private JPasswordField password;
	private JTextArea info;

	private JButton done;

	private JLabel desc;

	// connect back to main frame
	private HomeFrame homeframe;
	ArrayList<User> users = Foodie.foodieUsers;

	public SignupFrame() {

		setTitle("Foodie App");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 356, 375);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);

		// username field
		username = new JTextField();
		username.setText("Username");
		username.setBounds(70, 100, 180, 20);
		username.setColumns(10);
		c.add(username);

		// password field
		password = new JPasswordField();
		password.setText("Password");
		password.setEchoChar('*');
		password.setBounds(70, 130, 180, 20);
		password.setColumns(10);
		c.add(password);

		// create description
		desc = new JLabel("Please fill out all forms");
		desc.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		desc.setForeground(new Color(0, 85, 168));
		desc.setSize(300, 35);
		desc.setLocation(65, 60);
		c.add(desc);

		info = new JTextArea(
				"Passwords must be 8 characters,\nhave one capital and lowercase letter,\none number, and one special character.");
		info.setEditable(false);
		info.setLineWrap(true);
		info.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 10));
		info.setSize(230, 70);
		info.setLocation(70, 150);
		c.add(info);

		// create user
		done = new JButton("Done");
		done.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		done.setForeground(new Color(0, 85, 168));
		done.setBackground(new Color(234, 172, 53));
		done.setSize(200, 35);
		done.setLocation(66, 230);
		done.addActionListener(this);
		c.add(done);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == done) {
			PasswordChecker p = new PasswordChecker();

			// check username and password
			if (username.getText().equals("Username") || username.getText().equals("")) {
				showMessageDialog(null, "Please enter a valid username.");
				return;
			}

			for (User u : users) {
				if (u.getUserName().equals(username.getText())) {
					showMessageDialog(null, "Username is taken.");
					return;
				}
			}

			try {
				p.checkPassword(new String(password.getPassword()));
			} catch (PasswordException ex) {
				ex.printStackTrace();
				showMessageDialog(null, "Password requirements not met: " + ex.getMessage());
				return;
			}

			// create new user from fields and add to list
			User newUser = new Spartan(username.getText(), new String(password.getPassword()), new Preferences[] {});
			users.add(newUser);

			// redirect user
			PrefPanel pref = new PrefPanel((Spartan) newUser, new HomeFrame((Spartan) newUser));
		}

	}
	
	JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(new Color(0,58,168));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to close this window?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					SignupFrame.this.dispose();
				}
			}
		});
		lblExit.setForeground(new Color(0, 85, 168));
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExit.setBounds(287, 0, 13, 27);
		panel.add(lblExit);
}
