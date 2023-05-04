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
import javax.swing.JScrollPane;
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

public class MenuFrame extends JFrame implements ActionListener {

	private Container c;

	private JLabel sjsu;
	private JLabel menu;
	private JLabel rev;

	private JTextArea desc;

	private JButton go;
	private JButton back;
	private JButton make;

	private JList<String> menuList;
	private JTextArea reviewList;

	private ArrayList<Food> menuInput;
	private ArrayList<String> reviewInput;
	
	String[] menuItems;
	String[] reviewItems;
	
	private Restaurant restaurant;
	private HomeFrame homeframe;
	
	public MenuFrame(Restaurant restaurant, HomeFrame homeframe) {
		this.restaurant = restaurant;
		
		menuInput = this.restaurant.getMenu();
		reviewInput = this.restaurant.getReviews();

		this.homeframe = homeframe;

		menuItems = new String[menuInput.size()];
		reviewItems = new String[reviewInput.size()];

		// set NAMES to a list to display
		int i = 0;
		for (String s : reviewInput) {
			reviewItems[i] = reviewInput.get(i);
			i++;
		}

		// set NAMES to a list to display
		int j = 0;
		for (Food f : menuInput) {
			menuItems[j] = menuInput.get(j).getName();
			j++;
		}

		setTitle("FOODIE App");

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
		sjsu = new JLabel("FOODIE");
		sjsu.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 35));
		sjsu.setForeground(new Color(0, 85, 168));
		sjsu.setSize(250, 50);
		sjsu.setBounds(120, 78, 152, 88);

		// create desc label
		desc = new JTextArea(
				"Post a new review with [New Review]. \nClick an item and click [See More] to view food preferences. \nClick [Go back] to return to home page.");

		desc.setEditable(false);
		desc.setLineWrap(true);
		desc.setWrapStyleWord(true);

		desc.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 13));
		desc.setForeground(new Color(0, 85, 168));
		desc.setSize(250, 90);
		desc.setLocation(40, 180);
		c.add(desc);

		// create button to make a new review
		make = new JButton("NEW REVIEW");
		make.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		make.setForeground(new Color(0, 85, 168));
		make.setBackground(new Color(234, 172, 53));
		make.setSize(200, 35);
		make.setLocation(54, 280);
		make.addActionListener(this);
		c.add(make);

		// see item info
		go = new JButton("SEE MORE");
		go.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		go.setForeground(new Color(0, 85, 168));
		go.setBackground(new Color(234, 172, 53));
		go.setSize(200, 35);
		go.setLocation(54, 330);
		go.addActionListener(this);
		c.add(go);

		// go back to main page
		back = new JButton("GO BACK");
		back.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		back.setForeground(new Color(0, 85, 168));
		back.setBackground(new Color(234, 172, 53));
		back.setSize(200, 35);
		back.setLocation(54, 380);
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
		menu.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 15));
		menu.setForeground(Color.WHITE);
		menu.setSize(350, 35);
		menu.setBounds(80, 10, 350, 35);
		panel.add(menu);

		// create review listing
		rev = new JLabel("Reviews of: " + restaurant.getStoreName());
		rev.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 15));
		rev.setForeground(Color.WHITE);
		rev.setSize(350, 35);
		rev.setBounds(80, 210, 350, 35);
		panel.add(rev);

		// show menu options
		menuList = new JList<>(menuItems);
		menuList.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		menuList.setForeground(new Color(0, 85, 168));
		menuList.setBackground(Color.WHITE);
		menuList.setBorder(BorderFactory.createEtchedBorder());
		menuList.setBounds(80, 40, 270, 150);

		// give scroll bar
		JScrollPane scrollMenu = new JScrollPane(menuList);
		scrollMenu.setBounds(80, 40, 270, 150);
		panel.add(scrollMenu);

		// show review options
		reviewList = new JTextArea();
		reviewList.setEditable(false);
		reviewList.setLineWrap(true);
		reviewList.setWrapStyleWord(true);

		// List reviews
		int k = 1;
		for (String r : reviewItems) {
			if (k == 1) {
				reviewList.append(r);
			} else {
				reviewList.append("\n" + r);
			}
			k++;
		}

		reviewList.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		reviewList.setForeground(new Color(0, 85, 168));
		reviewList.setBackground(Color.WHITE);
		reviewList.setBorder(BorderFactory.createEtchedBorder());
		reviewList.setBounds(80, 240, 270, 150);

		// give scroll bar
		JScrollPane scrollReview = new JScrollPane(reviewList);
		scrollReview.setBounds(80, 240, 270, 150);
		panel.add(scrollReview);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == go) {
			Food food = menuInput.get(menuList.getSelectedIndex());
			showMessageDialog(null, food.toString());
		}

		if (e.getSource() == back) {
			this.dispose();
			homeframe.setVisible(true);
		}
		
		if (e.getSource() == make) {
			ReviewPanel r = new ReviewPanel(this.restaurant);
		}

	}

}
