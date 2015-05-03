package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;
import org.nlamah.QLS.Model.Abstract.WidgetType;

public class WidgetDeclaration extends StyleDeclaration 
{
	public WidgetDeclaration(WidgetType widgetType) 
	{
		super(widgetType);
	}
	
	public QBaseQuestionType returnType()
	{
		return ((WidgetType) value).type();
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

		if (!(object instanceof WidgetDeclaration))
		{
			return false;
		}

		return true;
	}
}
