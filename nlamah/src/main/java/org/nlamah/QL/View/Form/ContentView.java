package org.nlamah.QL.View.Form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QBase.Constants.UIConstants;

@SuppressWarnings("serial")
public class ContentView extends JPanel 
{		
	public ContentView() 
	{
		setBackground(Color.gray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMaximumSize(new Dimension(UIConstants.contentWidth(), 700));
		setMinimumSize(new Dimension(UIConstants.contentWidth(),700));
		setPreferredSize(new Dimension(UIConstants.contentWidth(),700));
	}
}