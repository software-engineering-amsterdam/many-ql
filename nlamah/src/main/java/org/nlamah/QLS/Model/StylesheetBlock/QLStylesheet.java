package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.QLStylesheetBlock;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QLStylesheet extends QLStylesheetBlock 
{
	private List<Page> pages;
	
	public QLStylesheet(IdentifierValue identifier, List<Page> pages, List<DefaultDeclaration> defaultDeclarations)
	{
		super(identifier, defaultDeclarations);
		
		this.pages = pages;
		
		for (Page page : pages)
		{
			page.setParentNode(this);
		}
	}
	
	public List<Page> pages()
	{
		return pages;
	}
	
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof QLStylesheet))
		{
			return false;
		}
		
		QLStylesheet value = (QLStylesheet) object;
		
		if (!(pages.equals(value.pages)))
		{
			return false;
		}

		return true;
	}
}
