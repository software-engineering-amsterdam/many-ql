package org.nlamah.QLS.Model;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;

public class Page extends QLStylesheetBlock 
{
	public Page(IdentifierValue identifier, List<Section> sections, List<DefaultDeclaration> defaultDeclarations) 
	{
		super(identifier, sections, defaultDeclarations);

	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
