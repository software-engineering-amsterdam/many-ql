package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;
import org.nlamah.QLS.Model.Declaration.DefaultDeclaration;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class Page extends StylesheetBlock 
{
	List<Section> sections;
	
	public Page(IdentifierValue identifier, List<Section> sections, List<DefaultDeclaration> defaultDeclarations) 
	{
		super(identifier, defaultDeclarations);
		
		this.sections = sections;
		
		for (Section section : sections)
		{
			section.setParentNode(this);
		}
	}

	public List<Section> sections()
	{
		return sections;
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

		if (!(object instanceof Page))
		{
			return false;
		}
		
		Page value = (Page) object;
		
		if (!(sections.equals(value.sections)))
		{
			return false;
		}

		return true;
	}
}
