package com.expensemanage.all;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class Forgotpassword
{
	String Name;
	static String USERNAME;
	JTextField tf1;
	JFrame f2;
	private JTextField tf2;
	String Password;

	
	/**
	 * @wbp.parser.entryPoint
	 */
		Forgotpassword () throws FileNotFoundException
		{
		f2=new JFrame("Forgot Password");
		f2.setSize(500, 500);
		f2.setLocationRelativeTo(null);
		f2.getContentPane().setLayout(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1=new JLabel("Name");
		l1.setBounds(50, 100, 100, 30);
		
		tf1=new JTextField();
		tf1.setBounds(150, 100, 200 ,30);
			
		JButton btn1=new JButton("Retrieve Password");
		btn1.setBounds(150, 317, 200, 50);
		
		btn1.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				try {
					method22();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		});
							
		f2.getContentPane().add(l1);
		f2.getContentPane().add(tf1);
		f2.getContentPane().add(btn1);
		
		tf2 = new JTextField();
		tf2.setBounds(150, 169, 200, 30);
		f2.getContentPane().add(tf2);
		
		JLabel l2 = new JLabel("User-Name");
		l2.setBounds(50, 169, 100, 30);
		f2.getContentPane().add(l2);
		
		JButton btn2 = new JButton("Back");
		btn2.setBounds(395, 0, 89, 23);
		f2.getContentPane().add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				try {
					new Loginpage2().Method2();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		f2.setVisible(true);	
	}

	void method22() throws FileNotFoundException
	{

		Name = tf1.getText();
		USERNAME = tf2.getText();
		
		try
		{

	Connection con1=Daoexpense.getConnection();
	  
	PreparedStatement ps=con1.prepareStatement("select Password from user where Name=? and UserName=?");  
      ps.setString(1, Name);  
      ps.setString(2, USERNAME);
      ResultSet rs=ps.executeQuery();
      
      if(rs.next())
      {
		JOptionPane.showMessageDialog(null,"Your Password is = " + rs.getString(1));
		new Loginpage2().Method2();
      }
      
      else {
    	  JOptionPane.showMessageDialog(null,"Invalid Name or User-Name   \t" + USERNAME ,"Inane warning",JOptionPane.WARNING_MESSAGE);
    	  new Forgotpassword();
      }
		}
      
    catch (Exception e) {
    JOptionPane.showMessageDialog(null,"Invalid Name or User-Name   \t" + USERNAME ,"Inane warning",JOptionPane.WARNING_MESSAGE);
    new Forgotpassword();
    }
}
}