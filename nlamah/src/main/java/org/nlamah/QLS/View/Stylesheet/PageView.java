package org.nlamah.QLS.View.Stylesheet;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Page;

@SuppressWarnings("serial")
public class PageView extends JPanel 
{
	private JLabel pageTitle;
	
	public PageView(Page page)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
		pageTitle = new JLabel("Page:" + page.title(), JLabel.CENTER);
		
		pageTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

		add(pageTitle);
	}
}
