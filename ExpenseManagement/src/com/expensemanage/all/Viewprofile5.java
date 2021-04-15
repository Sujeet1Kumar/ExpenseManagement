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

public class Viewprofile5{

	private JTable table;
	static Viewprofile5 frame;
	static String UserName;
	
	Connection con1=Daoexpense.getConnection();

		Viewprofile5() {
		JFrame f5=new JFrame("View Profile");
		f5.getContentPane().setLayout(null);
		f5.setVisible(true);
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f5.setSize(500, 500);
		f5.setLocationRelativeTo(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 23, 484, 438);
		f5.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn = new JButton("Back");
		btn.setBounds(395, 0, 89, 23);
		f5.getContentPane().add(btn);
		
		JButton btn2 = new JButton("Change Password");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f5.dispose();
				new Changepassword();
			}
		});
		
		btn2.setBounds(0, 0, 140, 23);
		f5.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Change Name");
		btn3.setBounds(204, 0, 122, 23);
		f5.getContentPane().add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f5.dispose();
				new Changename();
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f5.dispose();
				new Expensepage3();
			}
		});
		
		
		data();
	}
	
	void data()
	{
		
		try
		{
			new Loginpage2();
			UserName = Loginpage2.USERNAME;
			PreparedStatement ps=con1.prepareStatement("select Name,UserName,Password from user where UserName=?");
			ps.setString(1, UserName);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}