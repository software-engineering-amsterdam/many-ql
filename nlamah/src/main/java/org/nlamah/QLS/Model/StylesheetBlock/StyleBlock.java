package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class StyleBlock extends DefaultBlock 
{
	public StyleBlock(List<StyleDeclaration> styleDeclarations) 
	{
		super(null, styleDeclarations);
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
}
