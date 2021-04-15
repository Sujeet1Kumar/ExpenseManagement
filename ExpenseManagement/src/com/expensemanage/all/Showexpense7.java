package com.expensemanage.all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Showexpense7 {

	Connection con1=Daoexpense.getConnection();
	
	private JTable table;
	String value;
	static Showexpense7 frame;
	static String UserName;

		Showexpense7() {
		JFrame f7=new JFrame("Show Expense");
		f7.setSize(500,500);
		f7.getContentPane().setLayout(null);
		f7.setLocationRelativeTo(null);
		f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f7.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 484, 433);
		f7.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn3 = new JButton("Back");
		btn3.setBounds(395, 3, 89, 23);
		f7.getContentPane().add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f7.dispose();
				new Expensepage3();
			}
		});
		
		updateTable();
	}
		
	void updateTable()
	{
		try
		{
			new Loginpage2();
			UserName = Loginpage2.USERNAME;
			PreparedStatement ps=con1.prepareStatement("select ExpenseName,Amount,Date from data where UserName=?");
			ps.setString(1, UserName);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
			}
}