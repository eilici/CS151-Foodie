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
// Edited 5/3/23 by Robert Veloya : added review text area and functional (?) submit button.
public class ReviewPanel extends JFrame implements ActionListener {

	private Container c;
	
	private JTextArea txtrReview;
	
	private JLabel desc;
	//private Restaurant restaurant;

	private JButton submit;
	
	public ReviewPanel(/*Restaurant restaurant*/) {
		
		//this.restaurant = restaurant;
		
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
		desc.setSize(169, 35);
		desc.setLocation(65, 20);
		c.add(desc);
		
		txtrReview = new JTextArea();
		txtrReview.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrReview.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrReview.setBounds(10, 53, 320, 235);
		getContentPane().add(txtrReview);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtrReview.getText() == "") {
					JOptionPane.showMessageDialog(null,"Please enter a response","Invalid response", JOptionPane.OK_OPTION);
				}else {
					ArrayList<String> review = new ArrayList<>();
					review.add(txtrReview.getText());
					JOptionPane.showMessageDialog(null, "Review Added!", "Success", JOptionPane.OK_OPTION);
					ReviewPanel.this.dispose();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 85, 168));
		btnNewButton.setFont(new Font("HelveticaNeue MediumCond", Font.PLAIN, 15));
		btnNewButton.setBounds(108, 299, 113, 26);
		getContentPane().add(btnNewButton);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(txtrReview.getText() == null) {
			JOptionPane.showMessageDialog(null,"Please enter a response","Invalid response", JOptionPane.OK_OPTION);
		}else {
			Restaurant.addReview(txtrReview);
			JOptionPane.showMessageDialog(null, "Review Added!", "Success", JOptionPane.OK_OPTION);
			ReviewPanel.this.dispose();
		}

	}
}
