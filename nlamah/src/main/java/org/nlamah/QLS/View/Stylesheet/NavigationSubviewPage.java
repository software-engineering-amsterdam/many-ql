package org.nlamah.QLS.View.Stylesheet;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;

@SuppressWarnings("serial")
public class NavigationSubviewPage extends JPanel 
{
	private NavigationPageButtonView pageButton;
	private List<NavigationSectionButtonView> sectionButtons;

	public NavigationSubviewPage(Page page, List<Section> sections, ActionListener buttonListener) 
	{
		super();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pageButton = new NavigationPageButtonView(page, buttonListener);

		add(pageButton);

		sectionButtons = new ArrayList<NavigationSectionButtonView>();

		int preferredHeight = 0;

		for (Section section : sections)
		{
			NavigationSectionButtonView sectionButton = new NavigationSectionButtonView(section, buttonListener);
			preferredHeight += sectionButton.getPreferredSize().height;

			sectionButtons.add(sectionButton);

			add(sectionButton);
		}

		setPreferredSize(new Dimension(225, preferredHeight));
		setMinimumSize(getPreferredSize());
		setMaximumSize(getPreferredSize());
	}
}
