package org.nlamah.QL.Views.Form;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class NavigationView extends JPanel 
{
	public NavigationView() 
	{
		super();
		
		setMinimumSize(new Dimension(150, 500));
		setPreferredSize(new Dimension(150, 500));
	}

	public NavigationView(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public NavigationView(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public NavigationView(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
}
