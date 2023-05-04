package foodie;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Created 4-30-2023 by Elena Ilic
public class ReviewPanel extends JFrame implements ActionListener {

	private Container c;
	
	private JLabel desc;
	private Restaurant restaurant;

	private JButton submit;
	
	public ReviewPanel(Restaurant restaurant) {
		
		this.restaurant = restaurant;
		
		setTitle("Make new Review");

		//create window
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 356, 375);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);

		// create description
		desc = new JLabel("What did you think?");
		desc.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 20));
		desc.setForeground(new Color(0, 85, 168));
		desc.setSize(300, 35);
		desc.setLocation(65, 20);
		c.add(desc);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
