package org.nlamah.QLS.View.Stylesheet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Section;

@SuppressWarnings("serial")
public class SectionView extends JPanel
{
	private Section section;

	public SectionView(Section section)
	{
		this.section = section;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void layoutView()
	{
		redrawBorder();
	}

	private void redrawBorder()
	{
		setBorder(BorderFactory.createEmptyBorder());

		if (getPreferredSize().height > 0)
		{
			setBorder(BorderFactory.createTitledBorder(section.title()));
		}
	}
}