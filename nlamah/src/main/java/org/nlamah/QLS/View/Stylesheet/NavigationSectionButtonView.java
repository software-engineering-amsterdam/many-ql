package org.nlamah.QLS.View.Stylesheet;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;

import org.nlamah.QLS.Model.StylesheetBlock.Section;

@SuppressWarnings("serial")
public class NavigationSectionButtonView extends StylesheetBlockButtonView
{
	public NavigationSectionButtonView(Section section, ActionListener listener) 
	{		
		super(section, listener);

		add(Box.createRigidArea(new Dimension( padding + 10 * section.depthLevel(), 0)));

		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);

		button.setFont(button.getFont().deriveFont(fontAttributes));

		add(button);
	}
}