package org.nlamah.QLS.View.Stylesheet;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Page;

@SuppressWarnings("serial")
public class PageView extends JPanel 
{
	public PageView(Page page)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel(page.title()));
	}
}
