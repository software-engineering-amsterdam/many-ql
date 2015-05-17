package org.nlamah.QLS.View.Stylesheet;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Box;

import org.nlamah.QLS.Model.Abstract.StylesheetBlock;

@SuppressWarnings("serial")
public class NavigationPageButtonView extends StylesheetBlockButtonView 
{

	public NavigationPageButtonView(StylesheetBlock block, ActionListener listener) 
	{
		super(block, listener);

		add(Box.createRigidArea(new Dimension( padding, 0)));

		button.setFont(button.getFont().deriveFont(18.0f));

		add(button);	
	}
}
