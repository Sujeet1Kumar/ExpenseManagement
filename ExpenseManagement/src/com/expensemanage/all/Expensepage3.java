package com.expensemanage.all;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Expensepage3
{
	Expensepage3()
	{
		JFrame f3=new JFrame("Expense Page");
		f3.setSize(500,500);
		f3.setLocationRelativeTo(null);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f3.getContentPane().setBackground(new Color(60, 179, 113));
		
		f3.setLayout(null);
		JButton button1=new JButton("View Profile");
		button1.setBounds(50,100,150,50);
		
		button1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Viewprofile5();
			}
	
		});
		
		
		JButton button2=new JButton("Add Expenses");
		button2.setBounds(50,200,150,50);
		
		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Addexpense6();
			}
	
		});
		
		JButton button3=new JButton("Show Expenses");
		button3.setBounds(50,300,150,50);
		
		button3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Showexpense7();
			}
	
		});
		
		JButton button4=new JButton("Delete Expenses");
		button4.setBounds(250,100,150,50);
		button4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Deleteexpense8();
			}
	
		});
		
		JButton button5=new JButton("Update Expenses");
		button5.setBounds(250,200,150,50);
		
		button5.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Updateexpense9();
			}
	
		});
		
		JButton button6=new JButton("Search Expenses");
		button6.setBounds(250,300,150,50);
		
		button6.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				f3.dispose();
				new Searchexpense10();
			}
	
		});
		
		JButton button7=new JButton("Log Out");
		button7.setBounds(385,0,100,50);
		
		button7.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					JOptionPane.showMessageDialog(null,"Successfully Logout");
					f3.dispose();
					new Loginpage2().Method2();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
	
		});
		
		f3.add(button1);
		f3.add(button2);
		f3.add(button3);
		f3.add(button4);
		f3.add(button5);
		f3.add(button6);
		f3.add(button7);
		
		f3.setVisible(true);
	}
}