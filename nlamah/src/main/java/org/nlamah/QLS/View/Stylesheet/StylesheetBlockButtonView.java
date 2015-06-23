package org.nlamah.QLS.View.Stylesheet;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;

@SuppressWarnings("serial")
public abstract class StylesheetBlockButtonView extends JPanel 
{
	protected StylesheetBlock block;
	protected NavigationButton button;
	protected final int padding = 5;

	public StylesheetBlockButtonView(StylesheetBlock block, ActionListener listener) 
	{
		this.block = block;

		button = new NavigationButton(block.title());
		button.setValue(block);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		Border emptyBorder = BorderFactory.createCompoundBorder();
		button.setBorder(emptyBorder);

		button.addActionListener(listener);

		setPreferredSize(new Dimension(UIConstants.navigationViewWidth(), button.getPreferredSize().height + 2 * padding));
		setMaximumSize(getPreferredSize());
		setMinimumSize(getPreferredSize());
	}

	public StylesheetBlock block()
	{
		return block;
	}
}