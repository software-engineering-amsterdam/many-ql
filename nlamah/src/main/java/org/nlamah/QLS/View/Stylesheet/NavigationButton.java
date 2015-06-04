package org.nlamah.QLS.View.Stylesheet;

import javax.swing.JButton;

import org.nlamah.QLS.Model.Abstract.StylesheetBlock;

@SuppressWarnings("serial")
public class NavigationButton extends JButton 
{
	private StylesheetBlock value;

	public NavigationButton(String title) 
	{
		super(title);
	}

	public StylesheetBlock value() 
	{
		return this.value;
	}

	public void setValue(StylesheetBlock value) 
	{
		this.value = value;
	}
}