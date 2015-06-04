package org.nlamah.QLS.Builders;

import org.nlamah.QLS.Interfaces.QLSVisitorAbstract;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;

public class PageFinder extends QLSVisitorAbstract 
{
	private Page foundPage;

	public Page pageForSection(Section section)
	{
		section.accept(this);

		return foundPage;
	}

	@Override
	public QLSNode visit(Page page) 
	{
		foundPage = page;

		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{
		section.parentNode().accept(this);

		return null;
	}
}
