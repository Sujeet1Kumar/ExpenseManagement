package com.expensemanage.all;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


	public class ExpenseManager {
		public static JFrame frame;
		public String UserName;
		  static class BarThread extends Thread {
			  
			JProgressBar progressBar=new JProgressBar();
			
		    public BarThread(JProgressBar bar) {
		     
		    	progressBar = bar;
		    }

		    public void run() {
		    	ImageIcon im = new ImageIcon(getClass().getClassLoader().getResource("Expense Manager.jpg"));
			    
				JLabel label=new JLabel(im);
				frame.add(label);
		      int minimum = progressBar.getMinimum();
		      int maximum = progressBar.getMaximum();
		      for (int i = minimum; i < maximum; i++) {
		        try {
		          int value = progressBar.getValue();
		          progressBar.setValue(value + 1);

		          Thread.sleep(50);
		        } catch (InterruptedException ignoredException) {
		        }
		      }
		   
		      new Index().setVisible(true);
			frame.dispose();
		    }
		  }
		 
		   
	
	public static void main(String [] args) throws FileNotFoundException
	{
			    frame = new JFrame("Expense Manager");
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			    final JProgressBar aJProgressBar = new JProgressBar(0, 50);
			    
			    aJProgressBar.setStringPainted(true);
			    
			    Thread stepper = new BarThread(aJProgressBar);
			    stepper.start();

			    frame.add(aJProgressBar, BorderLayout.SOUTH);
			    frame.setSize(500, 500);
			    frame.setLocationRelativeTo(null);
			    
			    frame.setVisible(true);
			 
			   
			  }
}