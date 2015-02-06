package anotherOne.main.trash;

import java.awt.event.*;
import javax.swing.*;
 
public class Test1 extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCount,lblCount2;
	public JTextField txtQTY[] = new JTextField[11];
	private JTextField txtCName; 
	private JButton addButton, remButton;
 
	public Test1()
	{
		super("Test");
		setLayout (null);
 
		lblCount= new JLabel("80");
		lblCount.setBounds(700, 80,100, 20);
		lblCount.setVisible(false);
		add(lblCount);
		lblCount2= new JLabel("0");
		lblCount2.setBounds(700, 100,100, 20);
		lblCount2.setVisible(false);
		add(lblCount2);
 
		txtCName = new JTextField("");
		txtCName.setBounds(150, 10,100, 20);
		txtCName.setHorizontalAlignment(JTextField.RIGHT);
		add(txtCName);
 
		addButton = new JButton("+");
		addButton.setBounds(50, 80, 45, 20);
		add(addButton);
 
		HandlerClass1 handler1 = new HandlerClass1();
		addButton.addActionListener(handler1);
 
		remButton = new JButton("-");
		remButton.setBounds(50, 105, 45, 20);
		add(remButton);
		HandlerClass2 handler2 = new HandlerClass2();
		remButton.addActionListener(handler2);
 
 
	}
 
		 public class HandlerClass1 implements ActionListener
		{
		 	public void actionPerformed (ActionEvent event)
			{	
		 		String a = lblCount2.getText();
		 		int b = Integer.parseInt(a);
		 		int c = b+1;
		 		String x = lblCount.getText();
		 		int y = Integer.parseInt(x);
		 		if(b!=10)
		 		{
		 		//
		 		//Quantity
		 		//
				txtQTY[c] = new JTextField(" ");
				txtQTY[c].setBounds(100, y,50, 20);
				txtQTY[c].setHorizontalAlignment(JTextField.RIGHT);
				add(txtQTY[c]);								
 
				y = y+30;
				b=b+1;
				String z=Integer.toString(y);
				String d=Integer.toString(b);
				lblCount.setText(z);
				lblCount2.setText(d);
		 		}
		 		else
		 		{
		 			JOptionPane.showMessageDialog(null, "max");
		 		}
			}
 
		}	 
	 public class HandlerClass2 implements ActionListener
		{			
			public void actionPerformed (ActionEvent event)
			{
				remove(txtCName);
			}
		}
}