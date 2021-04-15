package com.expensemanage.all;
import java.awt.Color;
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


class Loginpage2
{
	static String USERNAME;
	static char [] PASSWORD;
	JTextField tf1;
	JPasswordField p1;
	JFrame f2;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void Method2() throws FileNotFoundException
	{
		f2=new JFrame("Login Page");
		f2.setSize(500, 500);
		f2.setLocationRelativeTo(null);
		f2.getContentPane().setLayout(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		f2.getContentPane().setBackground(new Color(60, 179, 113));
		JLabel l1=new JLabel("User-Name");
		l1.setBounds(50, 100, 100, 30);
		
		JLabel l2=new JLabel("Password");
		l2.setBounds(50, 150, 100, 30);
		
		tf1=new JTextField();
		tf1.setBounds(150, 100, 200 ,30);
		
		p1=new JPasswordField();
		p1.setBounds(150, 150, 200, 30);
		
		JButton b1=new JButton("Login");
		b1.setBounds(150, 250, 200, 50);
		
		b1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						f2.dispose();
						method22();
					}
			
				});
			
		JButton b2=new JButton("Register");
		b2.setBounds(150, 317, 200, 50);
		
		b2.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				new Registerpage4();
			}
	
		});
							
		f2.getContentPane().add(l1);
		f2.getContentPane().add(l2);
		f2.getContentPane().add(tf1);
		f2.getContentPane().add(p1);
		f2.getContentPane().add(b1);
		f2.getContentPane().add(b2);
		
		JButton b3 = new JButton("Forgot Password ?");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				try {
					new Forgotpassword();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b3.setBounds(150, 383, 200, 50);
		f2.getContentPane().add(b3);
		
		f2.setVisible(true);	
	}

	void method22()
{
	try
	{

	Connection con1=Daoexpense.getConnection();
	 
	 	USERNAME = tf1.getText();
		PASSWORD = p1.getPassword();
     PreparedStatement ps=con1.prepareStatement("select * from user where UserName =? and Password=?");  
      ps.setString(1, USERNAME);  
      ps.setString(2, String.valueOf(PASSWORD)); 
     ResultSet rs=ps.executeQuery();  
      if(rs.next())  
      { 
     	  f2.dispose();
     	  new Expensepage3(); 
      }  
      else  
      {  
           
    	  JOptionPane.showMessageDialog(null,"Invalid Email_id or Password   \t" + USERNAME ,"Inane warning",JOptionPane.WARNING_MESSAGE);
    	  Method2();
      }  
	}
    catch (Exception e) {

        System.out.println(e);
    }
}
}