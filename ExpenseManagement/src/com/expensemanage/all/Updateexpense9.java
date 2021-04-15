package com.expensemanage.all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Updateexpense9 {

	Connection con1=Daoexpense.getConnection();
	
	private JTable table;
	private JTextField tf1;
	private JTextField tf2;
	String value;
	static Updateexpense9 frame;
	static String UserName;

		Updateexpense9() {
		JFrame f9=new JFrame("Update Expense");
		f9.setSize(500,500);
		f9.getContentPane().setLayout(null);
		f9.setLocationRelativeTo(null);
		f9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f9.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 28, 484, 340);
		f9.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tf1 = new JTextField();
		tf1.setBounds(10, 397, 123, 20);
		f9.getContentPane().add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(357, 397, 117, 20);
		f9.getContentPane().add(tf2);
		
		JButton btn2 = new JButton("update expense");
		btn2.setBounds(176, 427, 141, 23);
		
		f9.getContentPane().add(btn2);
		
		JLabel l2 = new JLabel("Amount");
		l2.setBounds(395, 372, 44, 14);
		f9.getContentPane().add(l2);
		
		JLabel l1 = new JLabel("Expense Name");
		l1.setBounds(23, 372, 95, 14);
		f9.getContentPane().add(l1);
		
		JButton btn3 = new JButton("Back");
		btn3.setBounds(395, 3, 89, 23);
		f9.getContentPane().add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f9.dispose();
				new Expensepage3();
			}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					int i=table.getSelectedRow();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					if(i>=0)
					{
						value=model.getValueAt(i, 0).toString();

						model.setValueAt(tf1.getText(), i, 0);
						model.setValueAt(tf2.getText(), i, 1);
						
						update();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error");
					}
					}
			}			
			});

		new Loginpage2();
		UserName = Loginpage2.USERNAME;
		
		updateTable();
	}
	
	void update()
	{
	try {
		PreparedStatement ps=con1.prepareStatement("update data set ExpenseName=? , Amount=? where UserName=? and ExpenseName=?");
		ps.setString(1, tf1.getText());
		ps.setString(2, tf2.getText());
		ps.setString(3, UserName);
		ps.setString(4, value);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Updated Successfully");
		updateTable();

	}
	catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null, e1);
	}
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