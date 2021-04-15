package com.expensemanage.all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Searchexpense10 {

	Connection con1=Daoexpense.getConnection();
	
	private JTable table;
	private JTextField tf1;
	String value;
	static Searchexpense10 frame;
	static String UserName;

	/**
	 * Launch the application.
	 */
	
	int selectedRow;
	DefaultTableModel model;
	private JTextField tf2;
	
		Searchexpense10() {
		JFrame f10=new JFrame("Search Expense");
		f10.setSize(500,500);
		f10.getContentPane().setLayout(null);
		f10.setLocationRelativeTo(null);
		f10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f10.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76, 484, 385);
		f10.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tf1 = new JTextField();
		tf1.setBounds(29, 11, 123, 20);
		f10.getContentPane().add(tf1);
		
		JButton btn = new JButton("by Name");
		btn.setBounds(50, 42, 89, 23);
		f10.getContentPane().add(btn);
		
		new Loginpage2();
		UserName = Loginpage2.USERNAME;
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					PreparedStatement ps=con1.prepareStatement("select * from data where UserName=? and ExpenseName=?");
					ps.setString(1, UserName);
					ps.setString(2, tf1.getText());
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		
		JButton btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f10.dispose();
				new Expensepage3();
			}
		});
		
		
		btn3.setBounds(395, 0, 89, 23);
		f10.getContentPane().add(btn3);
		
		tf2 = new JTextField();
		tf2.setBounds(217, 11, 123, 20);
		f10.getContentPane().add(tf2);
		
		JButton btn2 = new JButton("by Amount");
		btn2.setBounds(227, 42, 102, 23);
		f10.getContentPane().add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s=tf2.getText();
					int i=Integer.parseInt(s);	
					PreparedStatement ps=con1.prepareStatement("select * from data where UserName=? and Amount=?");
					ps.setString(1, UserName);
					ps.setInt(2, i);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));		
				}
				
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		
	}
}