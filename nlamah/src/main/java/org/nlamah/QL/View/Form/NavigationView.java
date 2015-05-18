package org.nlamah.QL.View.Form;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QL.Helper.QLHelper;

@SuppressWarnings("serial")
public class NavigationView extends JPanel 
{
	public NavigationView() 
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMinimumSize(new Dimension(QLHelper.navigationViewWidth(), 1500));
		setPreferredSize(new Dimension(QLHelper.navigationViewWidth(), 1500));
	}
}