package com.foodie.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

public class RestaurantFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantFrame frame = new RestaurantFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RestaurantFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 150);
		panel.setBackground(new Color(0, 85, 168));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRestImage = new JLabel("insert restaurant image here");
		lblRestImage.setBounds(10, 38, 130, 100);
		panel.add(lblRestImage);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to close this window?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					RestaurantFrame.this.dispose();
				}
			}
		});
		lblExit.setForeground(new Color(255, 255, 255));
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExit.setBounds(787, 0, 13, 27);
		panel.add(lblExit);
		
		JTextPane txtpnInsertFoodPref = new JTextPane();
		txtpnInsertFoodPref.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnInsertFoodPref.setCaretColor(new Color(255, 255, 255));
		txtpnInsertFoodPref.setBackground(new Color(0, 85, 168));
		txtpnInsertFoodPref.setForeground(new Color(255, 255, 255));
		txtpnInsertFoodPref.setText("INSERT FOOD PREF HERE");
		txtpnInsertFoodPref.setBounds(150, 100, 530, 38);
		panel.add(txtpnInsertFoodPref);
		
		JTextPane txtpnRestaurant = new JTextPane();
		txtpnRestaurant.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnRestaurant.setBackground(new Color(0, 85, 168));
		txtpnRestaurant.setText("RESTAURANT NAME");
		txtpnRestaurant.setForeground(new Color(255, 255, 255));
		txtpnRestaurant.setBounds(150, 51, 530, 38);
		panel.add(txtpnRestaurant);
		
		JTextPane txtpnFoodMenu = new JTextPane();
		txtpnFoodMenu.setEditable(false);
		txtpnFoodMenu.setText("RESTAURANT MENU");
		txtpnFoodMenu.setForeground(new Color(0, 85, 168));
		txtpnFoodMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnFoodMenu.setBounds(10, 150, 222, 37);
		contentPane.add(txtpnFoodMenu);
		
		ScrollPane scrollPane = new ScrollPane(/* we can add content here (restaurant menu food items)*/);
		
		scrollPane.setBounds(10, 193, 780, 297);
		contentPane.add(scrollPane);
	}
}
