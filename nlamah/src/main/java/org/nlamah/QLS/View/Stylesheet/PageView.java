package org.nlamah.QLS.View.Stylesheet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QLS.Model.StylesheetBlock.Page;

@SuppressWarnings("serial")
public class PageView extends JPanel 
{
	private JLabel titleLabel;

	public PageView(Page page)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		titleLabel = new JLabel(page.title(), JLabel.CENTER);

		titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
		titleLabel.setOpaque(true);

		titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(titleLabel);

		add(horizontalBox);

		add(Box.createRigidArea(new Dimension(0, UIConstants.pageTitleBottomPadding())));
	}
}