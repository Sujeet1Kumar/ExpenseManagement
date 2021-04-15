package com.expensemanage.all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Addexpense6 {
	//create table data ("create table data (ExpenseName varchar(30), Amount varchar(30)), Date varchar(30))");

	static String ExpenseName;
	static String Amount;
	static JTextField tf1;
	static JTextField tf2;
	static String UserName;
	JDateChooser dateChooser;
	boolean flag;
	JFrame f6;
	
	Addexpense6()
	{
	JFrame f6=new JFrame("Add Expense");
	f6.setSize(500,500);
	f6.getContentPane().setLayout(null);
	f6.setLocationRelativeTo(null);
	f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JLabel l1=new JLabel("Expense-Name");
	l1.setBounds(50, 100, 100, 30);
	
	JLabel l2=new JLabel("Amount");
	l2.setBounds(50, 150, 100, 30);
	
	tf1=new JTextField();
	tf1.setBounds(150, 100, 200 ,30);
	
	tf2=new JTextField();
	tf2.setBounds(150, 150, 200, 30);
	
	JButton b1=new JButton("Save");
	b1.setBounds(150, 250, 200, 50);
	
	b1.addActionListener(new ActionListener()
	{

		public void actionPerformed(ActionEvent e) {
			
			ExpenseName = tf1.getText();
			Amount = tf2.getText();
			method62();
			f6.dispose();
			new Expensepage3();
		}
			
		});
	
	JButton b2=new JButton("Cancel");
	b2.setBounds(150, 350, 200, 50);
	
	b2.addActionListener(new ActionListener()
	{

		public void actionPerformed(ActionEvent e) {
			f6.dispose();
			new Expensepage3();
		}
			
		});
	
	JLabel l3 = new JLabel("Date");
	l3.setBounds(50, 212, 46, 14);
	f6.getContentPane().add(l3);
	f6.setVisible(true);
	
	
	dateChooser = new JDateChooser();
	dateChooser.setBounds(150, 200, 200, 30);
	
	f6.getContentPane().add(l1);
	f6.getContentPane().add(l2);
	f6.getContentPane().add(tf1);
	f6.getContentPane().add(tf2);
	f6.getContentPane().add(b1);
	f6.getContentPane().add(b2);
	f6.getContentPane().add(dateChooser);
	
	}
	
	void method62()
	{
		try
		{
			Connection con=Dao.getConnection();
			
			ResultSet resultSet = con.getMetaData().getCatalogs();

			while (resultSet.next()) {
			String databaseName = resultSet.getString(1);
			

			String DataBaseName="expense_data";
			if(DataBaseName.equals(databaseName))
			{
				flag=true;
			}
			}
			
			method63();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	void method63()
	{
		{
				try {
					
					new Loginpage2();
					UserName = Loginpage2.USERNAME;
					SimpleDateFormat df = new SimpleDateFormat();
					String Date = df.format(dateChooser.getDate()); 
					Connection con1=Daoexpense.getConnection();
					PreparedStatement ps=con1.prepareStatement("insert into data values(?,?,?,?)");
					ps.setString(1, UserName);
					ps.setString(2, ExpenseName);
					ps.setString(3, Amount);
					ps.setString(4, Date);
					ps.executeUpdate();
					
					con1.close();
					
				    JOptionPane.showMessageDialog(null,"Successfully Add");
				    f6.dispose();
				    new Addexpense6();
		}
				catch(Exception e)
				{
					System.out.println(e);
				}		
		}
	}			
}