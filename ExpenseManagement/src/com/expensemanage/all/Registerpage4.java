package com.expensemanage.all;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registerpage4 {

	String Name;
	static String UserName;
	static char [] Password;
	JTextField tf1;
	JPasswordField p1;
	boolean flag;
	JFrame f4;
	private JTextField tf2;
	
	Registerpage4()
	{
	f4=new JFrame("Register Page");
	f4.setSize(500,500);
	f4.getContentPane().setLayout(null);
	f4.setLocationRelativeTo(null);
	f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f4.getContentPane().setBackground(new Color(60, 179, 113));
	
	JLabel l1=new JLabel("User-Name");
	l1.setBounds(50, 100, 100, 30);
	
	JLabel l2=new JLabel("Password");
	l2.setBounds(50, 150, 100, 30);
	
	tf1=new JTextField();
	tf1.setBounds(150, 100, 200 ,30);
	
	p1=new JPasswordField();
	p1.setBounds(150, 150, 200, 30);
	
	JButton b1=new JButton("Register");
	b1.setBounds(150, 250, 200, 50);
	
	b1.addActionListener(new ActionListener()
	{

		public void actionPerformed(ActionEvent e) {
			
			Name = tf2.getText();
			UserName = tf1.getText();
			Password = p1.getPassword();
			method42();
		}
			
		});
	
	JButton b2=new JButton("Login");
	b2.setBounds(150, 350, 200, 50);
	
	b2.addActionListener(new ActionListener()
	{

		public void actionPerformed(ActionEvent e) {
			try {
				new Loginpage2().Method2();
				f4.dispose();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
			
		});
	
	f4.getContentPane().add(l1);
	f4.getContentPane().add(l2);
	f4.getContentPane().add(tf1);
	f4.getContentPane().add(p1);
	f4.getContentPane().add(b1);
	f4.getContentPane().add(b2);
	
	JLabel l3 = new JLabel("Name");
	l3.setBounds(50, 48, 100, 30);
	f4.getContentPane().add(l3);
	
	tf2 = new JTextField();
	tf2.setBounds(150, 48, 200, 30);
	f4.getContentPane().add(tf2);
	f4.setVisible(true);
	}
	
	void method42()
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
			
			method43();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	void method43()
	{
		if(flag==true)
		{
				try {
				Connection  con1=Daoexpense.getConnection();
				
					PreparedStatement ps=con1.prepareStatement("insert into user values(?,?,?)");
					ps.setString(1, Name);
					ps.setString(2, UserName);
					ps.setString(3, String.valueOf(Password));
					ps.executeUpdate();
					con1.close();
					
				    JOptionPane.showMessageDialog(null,"Successfully Register"); 
				    f4.dispose();
				    new Loginpage2().Method2();
		}
				catch(Exception e)
				{
					System.out.println(e);
				}		
		}
			else
			{	
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
				Connection  con=Dao.getConnection();
				
				Statement smt=con.createStatement();
				smt.executeUpdate("create database expense_data");
				smt.executeUpdate("use expense_data");
				PreparedStatement ps=con.prepareStatement("create table user (Name varchar(30), UserName varchar(30) primary key, Password varchar(30))");
				ps.executeUpdate();
				ps.executeUpdate("create table data (UserName varchar (30), ExpenseName varchar(30), Amount varchar(30), Date varchar(30))");
				ps.executeUpdate("use expense_data");
				PreparedStatement p=con.prepareStatement("insert into user values(?,?,?)");
				p.setString(1, Name);
				p.setString(2, UserName);
				p.setString(3, String.valueOf(Password));
				p.executeUpdate();
				con.close();
				
			    JOptionPane.showMessageDialog(null,"Successful Register"); 
			    f4.dispose();
			    new Loginpage2().Method2();
			}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
	}				
}