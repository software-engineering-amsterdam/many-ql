package org.nlamah.QL.Error;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QL.Helper.Helper;

@SuppressWarnings("serial")
public class QLErrorView extends JPanel
{
	private JLabel errorLabel;
	
	public QLErrorView() 
	{
		super();
		
		errorLabel = new JLabel();
		errorLabel.setForeground(Color.red);
				
		layoutView();
	}
	
	public void fillInErrorString(String errorString)
	{
		errorLabel.setText(errorString);
	}
	
	private void layoutView()
	{
		setBackground(Color.white);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMaximumSize(new Dimension(Helper.contentWidth(), 700));
		setMinimumSize(new Dimension(Helper.contentWidth(),700));
		setPreferredSize(new Dimension(Helper.contentWidth(),700));
		
		add(errorLabel);
	}
}
