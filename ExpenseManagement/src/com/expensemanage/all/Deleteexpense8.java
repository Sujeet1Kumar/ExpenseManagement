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

public class Deleteexpense8 {

	Connection con1=Daoexpense.getConnection();
	
	private JTable table;
	String value;
	static Deleteexpense8 frame;
	static String UserName;

		Deleteexpense8() {
		JFrame f8=new JFrame("Delete Expense");
		f8.setSize(500,500);
		f8.getContentPane().setLayout(null);
		f8.setLocationRelativeTo(null);
		f8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f8.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 484, 388);
		f8.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn2 = new JButton("delete expense");
		btn2.setBounds(176, 427, 141, 23);
		
		f8.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Back");
		btn3.setBounds(395, 3, 89, 23);
		f8.getContentPane().add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f8.dispose();
				new Expensepage3();
			}
		});
		
		new Loginpage2();
		UserName = Loginpage2.USERNAME;
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				String cell = table.getModel().getValueAt(row, 0).toString();
				try {
					PreparedStatement ps=con1.prepareStatement("delete from data where UserName=? and ExpenseName=?");
					ps.setString(1, UserName);
					ps.setString(2, cell);
					ps.execute();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
					updateTable();

				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		updateTable();
	}
	
	void updateTable()
	{
		try
		{
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