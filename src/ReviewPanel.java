package foodie;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//Created 4-30-2023 by Elena Ilic
public class ReviewPanel extends JFrame implements ActionListener {

	private Container c;

	public ReviewPanel() {
		setTitle("What are your filters?");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 356, 375);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);

		c = getContentPane();
		c.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
