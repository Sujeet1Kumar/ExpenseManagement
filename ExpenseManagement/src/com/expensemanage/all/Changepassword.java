package com.expensemanage.all;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Changepassword{
	static Changepassword frame;
	static String UserName;
	String Pass;
	JFrame f5;
	
	Connection con1=Daoexpense.getConnection();
	private JTextField tf1;
	private JButton btn2;

		Changepassword() {
		f5=new JFrame("Change Password");
		f5.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Enter New Password");
		l1.setBounds(50, 48, 122, 14);
		f5.getContentPane().add(l1);
		
		tf1 = new JTextField();
		tf1.setBounds(50, 105, 122, 20);
		f5.getContentPane().add(tf1);
		
		JButton btn1 = new JButton("Change Password");
		btn1.setBounds(37, 177, 162, 23);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data();
			}
		});
		
		f5.getContentPane().add(btn1);
		
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f5.dispose();
				new Viewprofile5();
			}
		});
		btn2.setBounds(145, 0, 89, 23);
		f5.getContentPane().add(btn2);
		f5.setVisible(true);
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f5.setSize(250, 250);
		f5.setLocationRelativeTo(null);
	}
	
	void data()
	{
		
		try
		{
			Pass = tf1.getText();
			new Loginpage2();
			UserName = Loginpage2.USERNAME;
			PreparedStatement ps=con1.prepareStatement("update user set Password=? where UserName=?");
			ps.setString(1, Pass);
			ps.setString(2, UserName);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Password Changed Successfully");
			f5.dispose();
			new Viewprofile5();
		}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}