package com.expensemanage.all;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 475);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 307, 436);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(307, 0, 290, 436);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Existing User");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 215, 98, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New User");
		lblNewLabel_1.setBounds(20, 215, 85, 20);
	
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
					new Loginpage2().Method2();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(0, 400, 64, 36);
		panel.add(btnExit);
			
		
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		
		btnNewButton.setBounds(198, 210, 85, 35);
		panel.add(btnNewButton);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Expense");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(217, 11, 80, 30);
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Manager");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(0, 11, 90, 30);
		
		panel_1.add(lblNewLabel_2_1);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Registerpage4();
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnNewButton_1.setBounds(125, 210, 85, 35);
		
		
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		  Border line1 = new LineBorder(Color.GRAY);
		  btnNewButton_1.setOpaque(false);
		  Border margin1 = new EmptyBorder(5, 15, 5, 15);
		  Border compound1 = new CompoundBorder(line1, margin1);
		  btnNewButton_1.setBorder(compound1);
		  
		  panel_1.add(btnNewButton_1);
		  
		  JTextArea txtrMadeBySujeet = new JTextArea();
		  txtrMadeBySujeet.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 14));
		  txtrMadeBySujeet.setText("Made by\r\nSujeet Kumar");
		  txtrMadeBySujeet.setBounds(171, 345, 119, 50);
		  panel_1.add(txtrMadeBySujeet);
		  
		  ImageIcon im = new ImageIcon(getClass().getClassLoader().getResource("pink.jpg"));

		  JLabel lblNewLabel_3 = new JLabel(im);
		  lblNewLabel_3.setBounds(0, 0, 290, 436);
		  panel_1.add(lblNewLabel_3);
		  
		 
		 
			
	
		
	}
}
