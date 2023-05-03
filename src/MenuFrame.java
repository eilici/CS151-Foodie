package foodie;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//Created 4-30-2023 by Elena Ilic

public class MenuFrame extends JFrame implements ActionListener, ListSelectionListener {

	private Container c;

	private JLabel sjsu;
	private JLabel menu;
	private JLabel desc1;
	private JLabel desc2;

	private JButton go;
	private JButton back;
	private JButton reviews;

	private JList menuList;
	private ArrayList<Food> menuInput;

	public MenuFrame(Restaurant restaurant) {
		menuInput = restaurant.getMenu();

		String[] menuItems = new String[menuInput.size()];

		// set NAMES to a list to display
		int i = 0;
		for (Food f : menuInput) {
			menuItems[i] = menuInput.get(i).getName();
			i++;
		}

		setTitle("Foodie App");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 756, 475);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);

		// image icon
		Image img = new ImageIcon("src/Foodie/SpartanSpirit[2color]_4cp.png").getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH);

		JLabel icon = new JLabel();
		icon.setBounds(10, 50, 100, 100);
		icon.setIcon(new ImageIcon(img));

		c.add(icon);

		// sjsu brand
		sjsu = new JLabel("Foodie");
		sjsu.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 35));
		sjsu.setForeground(new Color(0, 85, 168));
		sjsu.setSize(250, 50);
		sjsu.setBounds(120, 78, 152, 88);

		// create desc label
		desc1 = new JLabel("Click 'See More' to see info!");
		desc1.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		desc1.setForeground(new Color(0, 85, 168));
		desc1.setSize(250, 35);
		desc1.setLocation(30, 180);
		c.add(desc1);

		desc2 = new JLabel("Click 'Go Back' to return!");
		desc2.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		desc2.setForeground(new Color(0, 85, 168));
		desc2.setSize(250, 35);
		desc2.setLocation(40, 210);
		c.add(desc2);

		// see item info
		go = new JButton("See More");
		go.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		go.setForeground(new Color(0, 85, 168));
		go.setBackground(new Color(234, 172, 53));
		go.setSize(200, 35);
		go.setLocation(54, 280);
		go.addActionListener(this);
		c.add(go);

		// go back to main page
		back = new JButton("Go Back");
		back.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		back.setForeground(new Color(0, 85, 168));
		back.setBackground(new Color(234, 172, 53));
		back.setSize(200, 35);
		back.setLocation(54, 340);
		back.addActionListener(this);
		c.add(back);

		c.add(sjsu);

		// create color block division
		JPanel panel = new JPanel(null);
		panel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.setBackground(new Color(0, 85, 168));
		panel.setBounds(311, 0, 445, 475);

		c.add(panel);

		// create menu listing
		menu = new JLabel("Menu of: " + restaurant.getStoreName());
		menu.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 20));
		menu.setForeground(Color.WHITE);
		menu.setSize(350, 35);
		menu.setBounds(80, 20, 350, 35);
		panel.add(menu);

		// show menu options
		menuList = new JList(menuItems);
		menuList.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		menuList.setForeground(new Color(0, 85, 168));
		menuList.setBackground(Color.WHITE);
		menuList.setBorder(BorderFactory.createEtchedBorder());
		menuList.setBounds(80, 60, 270, 300);
		menuList.addListSelectionListener(this);
		panel.add(menuList);

		setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == go) {
			Food food = menuInput.get(menuList.getSelectedIndex());
			showMessageDialog(null, food.toString());
		}

		if (e.getSource() == back) {
			this.dispose();
		}

	}

}
