package org.nlamah.QL.Views.Form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QL.Helper.QLHelper;

@SuppressWarnings("serial")
public class ContentView extends JPanel 
{		
	public ContentView() 
	{
		super();
		
		layoutView();
	}
	
	private void layoutView()
	{
		setBackground(Color.gray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMaximumSize(new Dimension(QLHelper.contentWidth(), 700));
		setMinimumSize(new Dimension(QLHelper.contentWidth(),700));
		setPreferredSize(new Dimension(QLHelper.contentWidth(),700));
	}
}
