package org.nlamah.QLS.View.Stylesheet;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QLS.Model.StylesheetBlock.Section;

@SuppressWarnings("serial")
public class SectionView extends JPanel implements ComponentListener
{
	private Section section;
	
	public SectionView(Section section)
	{
		this.section = section;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		addComponentListener(this);
	}
	
	private void redrawBorder()
	{
		setBorder(BorderFactory.createEmptyBorder());
		
		if (getPreferredSize().height > 0)
		{
			setBorder(BorderFactory.createTitledBorder(section.title()));
		}
	}

	@Override
	public void componentResized(ComponentEvent e) 
	{		
		redrawBorder();
	}

	@Override
	public void componentMoved(ComponentEvent e) 
	{
		redrawBorder();
	}

	@Override
	public void componentShown(ComponentEvent e) 
	{
		redrawBorder();
	}

	@Override
	public void componentHidden(ComponentEvent e) 
	{
		redrawBorder();
	}
}
