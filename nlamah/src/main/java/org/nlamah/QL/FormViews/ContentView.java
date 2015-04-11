package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QL.Helper.Helper;

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
		
		setMaximumSize(new Dimension(Helper.contentWidth(), 700));
		setMinimumSize(new Dimension(Helper.contentWidth(),700));
		setPreferredSize(new Dimension(Helper.contentWidth(),700));
	}
}
