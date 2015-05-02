package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QuestionDeclaration extends QLSNode
{
	private IdentifierValue identifier;
	private WidgetDeclaration widgetDeclaration;
	
	public QuestionDeclaration(IdentifierValue identifier, WidgetDeclaration widgetDeclaration)
	{
		super();
		
		this.identifier = identifier;
		this.widgetDeclaration = widgetDeclaration;
	}
	
	public IdentifierValue identifier()
	{
		return identifier;
	}
	
	public WidgetDeclaration widgetDeclaration()
	{
		return widgetDeclaration;
	}
	
	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof QuestionDeclaration))
		{
			return false;
		}
		
		QuestionDeclaration value = (QuestionDeclaration) object;
		
		if (!this.identifier.equals(value.identifier))
		{
			return false;
		}
		
		if (widgetDeclaration == null && value.widgetDeclaration == null)
		{
			return true;
		}
		
		if (!widgetDeclaration.equals(value.widgetDeclaration))
		{
			return false;
		}

		return true;
	}
}
