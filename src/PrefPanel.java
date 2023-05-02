package Foodie;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//Created 4-30-2023 by Elena Ilic
public class PrefPanel extends JFrame implements ActionListener{
	private Container c;

	private Spartan user;
	
	private JRadioButton halal;
	private JRadioButton vegan;
	private JRadioButton vegetarian;
	private JRadioButton kosher;
	private JRadioButton highprotein;
	private JRadioButton keto;
	private JRadioButton ebt;

	private JButton done;
	
	private JLabel desc;

	//connect back to main frame
	private HomeFrame homeframe;

	public PrefPanel(Spartan user, HomeFrame homeframe) {
		this.homeframe = homeframe;
		this.user = user;
		
		setTitle("Foodie App");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 356, 375);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);

		//create description
		desc = new JLabel("Please select ALL applicable");
		desc.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		desc.setForeground(new Color(0, 85, 168));
		desc.setSize(300, 35);
		desc.setLocation(40, 220);
		c.add(desc);
		
		//create buttons for each filter
		halal = new JRadioButton("Halal");
		halal.setBounds(50, 30, 120, 50);
		halal.setBackground(Color.WHITE);
		
		vegan = new JRadioButton("Vegan");
		vegan.setBounds(50, 70, 120, 50);
		vegan.setBackground(Color.WHITE);
		
		vegetarian = new JRadioButton("Vegetarian");
		vegetarian.setBounds(50, 110, 120, 50);
		vegetarian.setBackground(Color.WHITE);
		
		kosher = new JRadioButton("Kosher");
		kosher.setBounds(50, 150, 120, 50);
		kosher.setBackground(Color.WHITE);
		
		highprotein = new JRadioButton("High Protein");
		highprotein.setBounds(180, 30, 120, 50);
		highprotein.setBackground(Color.WHITE);
		
		keto = new JRadioButton("Keto");
		keto.setBounds(180, 70, 120, 50);
		keto.setBackground(Color.WHITE);
		
		ebt = new JRadioButton("EBT");
		ebt.setBounds(180, 110, 120, 50);
		ebt.setBackground(Color.WHITE);
		
		c.add(halal);
		c.add(vegan);
		c.add(vegetarian);
		c.add(kosher);
		c.add(highprotein);
		c.add(keto);
		c.add(ebt);
		
		done = new JButton("Done");
		done.setFont(new Font("HelveticaNeue MediumCond", Font.BOLD, 25));
		done.setForeground(new Color(0, 85, 168));
		done.setBackground(new Color(234, 172, 53));
		done.setSize(200, 35);
		done.setLocation(54, 280);
		done.addActionListener(this);
		c.add(done);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Preferences> userpref = new ArrayList<>();
		
		if (halal.isSelected()) {
			userpref.add(Preferences.HALAL);
		}
		
		if (vegan.isSelected()) {
			userpref.add(Preferences.VEGAN);
		}

		if (vegetarian.isSelected()) {
			userpref.add(Preferences.VEGETARIAN);
		}
		
		if (kosher.isSelected()) {
			userpref.add(Preferences.KOSHER);
		}
		
		if (highprotein.isSelected()) {
			userpref.add(Preferences.HIGHPROTEIN);
		}
		
		if (keto.isSelected()) {
			userpref.add(Preferences.KETO);
		}
		
		if (ebt.isSelected()) {
			userpref.add(Preferences.EBT);
		}
		
		//change user data and update preferences on home frame.
		user.setFoodPref(userpref);
		homeframe.getPrefs().setText("Filters: " + user.getFoodPref());
		this.dispose();
	}
}