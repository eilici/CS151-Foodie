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
import java.util.HashSet;
// Created 4-30-2023 by Elena Ilic

public class HomeFrame extends JFrame implements ActionListener {

	private String username;
	private Spartan user;

	private Container c;

	private JLabel welcome;
	private JLabel restaurant;
	private JLabel prefs;
	private JLabel icon;
	private JLabel sjsu;

	private JButton make;
	private JButton update;
	private JButton go;

	// NAMES of restaurants
	private JList restaurants;

	// filtered restaurant array
	private Restaurant[] filtered;

	// Restaurants
	private static ArrayList<Restaurant> list = Foodie.foodieRestaurants;

	public HomeFrame(Spartan user) {
		this.user = user;
		username = user.getUserName();

		// filter Restaurant view based on preferences
		// restaurants sorted by criteria: has at least one preference specified by user
		// prefs
		filtered = refreshRestaurants();

		// get Restaurant names
		String[] restaurantNames = createList(filtered);

		// create window
		setTitle("Foodie App");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		c.add(sjsu);

		// create welcome label
		welcome = new JLabel("Welcome, " + username + "!");
		welcome.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 25));
		welcome.setForeground(new Color(0, 85, 168));
		welcome.setSize(250, 35);
		welcome.setLocation(60, 180);
		c.add(welcome);

		// show user filters
		prefs = new JLabel("Filters: " + user.getFoodPref());
		prefs.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 15));
		prefs.setForeground(new Color(0, 85, 168));
		prefs.setSize(250, 35);
		prefs.setLocation(60, 220);
		c.add(prefs);

		// create button to make a new review
		make = new JButton("New Review");
		make.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		make.setForeground(new Color(0, 85, 168));
		make.setBackground(new Color(234, 172, 53));
		make.setSize(200, 35);
		make.setLocation(54, 330);
		make.addActionListener(this);
		c.add(make);

		// create button to update preferences
		update = new JButton("Update Filters");
		update.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		update.setForeground(new Color(0, 85, 168));
		update.setBackground(new Color(234, 172, 53));
		update.setSize(200, 35);
		update.setLocation(54, 380);
		update.addActionListener(this);
		c.add(update);

		go = new JButton("See More");
		go.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		go.setForeground(new Color(0, 85, 168));
		go.setBackground(new Color(234, 172, 53));
		go.setSize(200, 35);
		go.setLocation(54, 280);
		go.addActionListener(this);
		c.add(go);

		// create color block division
		JPanel panel = new JPanel(null);
		panel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		panel.setBackground(new Color(0, 85, 168));
		panel.setBounds(311, 0, 445, 475);

		// create restaurant listing
		restaurant = new JLabel("Restaurants fitting your criteria:");
		restaurant.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 20));
		restaurant.setForeground(Color.WHITE);
		restaurant.setSize(350, 35);
		restaurant.setBounds(80, 20, 350, 35);
		panel.add(restaurant);

		// show restaurant listings
		restaurants = new JList(restaurantNames);
		restaurants.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		restaurants.setForeground(new Color(0, 85, 168));
		restaurants.setBackground(Color.WHITE);
		restaurants.setBorder(BorderFactory.createEtchedBorder());
		restaurants.setBounds(80, 60, 270, 300);

		panel.add(restaurants);

		// add panel
		c.add(panel);
		setVisible(true);
	}

	// getter to update label
	public JLabel getPrefs() {
		return prefs;
	}

	public JList getRestaurants() {
		return restaurants;
	}

	// creates string array of Restaurant names according to filters
	public String[] createList(Restaurant[] filter) {
		String[] restaurantNames = new String[filter.length];
		int i = 0;
		for (Restaurant r : filter) {
			restaurantNames[i] = r.getStoreName();
			i++;
		}
		return restaurantNames;
	}

	// filters restaurant list based on if it contains at least one preference
	// specified by user's preferences
	public Restaurant[] refreshRestaurants() {
		HashSet<Restaurant> nodup = new HashSet<>();

		// if restaurant fits requirements set by user prefs, add to hashset
		for (Restaurant r : list) {

			for (Preferences p : user.getFoodPref()) {
				// add preference
				if (r.getContainsPrefs().contains(p)) {
					nodup.add(r);
				}
			}
		}

		// if user has no preferences show all restaurants
		if (user.getFoodPref().isEmpty()) {
			nodup.addAll(list);
		}

		Restaurant[] finished = new Restaurant[nodup.size()];
		// relocation of objects back into array
		int i = 0;
		for (Restaurant r : nodup) {
			finished[i] = r;
			i++;
		}

		return finished;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == make) {
			ReviewPanel review = new ReviewPanel();
		}
		if (e.getSource() == update) {
			new PrefPanel(this.user, this);
		}
		if (e.getSource() == go) {
			Restaurant restaurant = filtered[restaurants.getSelectedIndex()];
			MenuFrame menu = new MenuFrame(restaurant);
		}
	}

}
