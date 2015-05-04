package org.nlamah.QLS.View.Stylesheet;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Section;

@SuppressWarnings("serial")
public class SectionView extends JPanel 
{
	public SectionView(Section section)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
