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
import javax.swing.ScrollPaneConstants;
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
import java.util.HashSet;
// Created 4-30-2023 by Elena Ilic
//5-3-2023 Elena Ilic: fixed restaurant list from leading to wrong menu. removed defunct createList.

public class HomeFrame extends JFrame implements ActionListener {

	private String username;
	private Spartan user;

	private Container c;

	private JLabel welcome;
	private JLabel restaurant;
	private JLabel prefs;
	private JLabel icon;
	private JLabel sjsu;
	
	private JTextArea filters;
	private JScrollPane scroll;

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

		// create window
		setTitle("FOODIE App");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 475);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);

		// image icon
		Image img = new ImageIcon("src/foodie/SpartanSpirit[2color]_4cp.png").getImage().getScaledInstance(100, 100,
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

		c.add(sjsu);

		// create welcome label
		welcome = new JLabel("Welcome, " + username + "!");
		welcome.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		welcome.setForeground(new Color(0, 85, 168));
		welcome.setSize(250, 35);
		welcome.setLocation(60, 160);
		c.add(welcome);

		// show user filters
		prefs = new JLabel("FILTERS: ");
		prefs.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 15));
		prefs.setForeground(new Color(0, 85, 168));
		prefs.setSize(250, 20);
		prefs.setLocation(60, 200);
		c.add(prefs);
		
		//create textarea displaying user filters
		System.out.println(user.getFoodPref());
		filters = new JTextArea(user.getFoodPref().toString());
		filters.setEditable(false);
		filters.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 15));
		filters.setForeground(new Color(0, 85, 168));
		filters.setSize(185, 25);
		filters.setLocation(60,240);

		filters.setLineWrap(true);
		filters.setWrapStyleWord(true);
		
		//give scroll bar
		scroll = new JScrollPane(filters);
		scroll.setBounds(60, 230, 185, 25);
		c.add(scroll);

		// create button to update preferences
		update = new JButton("UPDATE FILTERS");
		update.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		update.setForeground(new Color(0, 85, 168));
		update.setBackground(new Color(234, 172, 53));
		update.setSize(200, 35);
		update.setLocation(54, 380);
		update.addActionListener(this);
		c.add(update);

		//see more info on restaurant
		go = new JButton("SEE MORE");
		go.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		go.setForeground(new Color(0, 85, 168));
		go.setBackground(new Color(234, 172, 53));
		go.setSize(200, 35);
		go.setLocation(54, 330);
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
		restaurants = new JList(filtered);
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
	public JTextArea getFilters() {
		return filters;
	}

	public JList getRestaurants() {
		return restaurants;
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
		if (user.getFoodPref().get(0) == Preferences.NONE) {
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
		if (e.getSource() == update) {
			new PrefPanel(this.user, this);
		}
		if (e.getSource() == go) {
			if (restaurants.getSelectedValue() == null) {
				showMessageDialog(null, "Please select a Restaurant.");
			}
			
			Restaurant restaurant = (Restaurant)restaurants.getSelectedValue();
			MenuFrame menu = new MenuFrame(restaurant, this);
			this.setVisible(false);
			
		}
	}

}