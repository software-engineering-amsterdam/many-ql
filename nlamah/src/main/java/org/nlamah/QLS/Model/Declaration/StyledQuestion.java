package org.nlamah.QLS.Model.Declaration;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class StyledQuestion extends QLSNode
{
	private IdentifierValue identifier;
	private WidgetDeclaration widgetDeclaration;
	
	public StyledQuestion(IdentifierValue identifier, WidgetDeclaration widgetDeclaration)
	{
		super();
		
		this.identifier = identifier;
		this.widgetDeclaration = widgetDeclaration;
		
		if (widgetDeclaration != null)
		{
			widgetDeclaration.setParentNode(this);
		}
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
		if (!(object instanceof StyledQuestion))
		{
			return false;
		}
		
		StyledQuestion value = (StyledQuestion) object;
		
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
	
	@Override
	public int hashCode() 
	{
		return identifier.toString().hashCode();
	}
}
