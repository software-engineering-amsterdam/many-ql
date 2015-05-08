package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.Stack;

import org.nlamah.QBase.EqualityStating;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class StyledQuestion extends SectionItem implements EqualityStating
{
	public Stack<QBaseEqualityState> equalityStateStack;
	
	private IdentifierValue identifier;
	private WidgetDeclaration widgetDeclaration;
	
	public DefaultBlock styleBlock;
	
	public StyledQuestion(IdentifierValue identifier, WidgetDeclaration widgetDeclaration)
	{
		super();
		
		this.identifier = identifier;
		this.widgetDeclaration = widgetDeclaration;
		
		equalityStateStack = new Stack<QBaseEqualityState>();
		equalityStateStack.push(QBaseEqualityState.ALL);
		
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
		switch (equalityStateStack.peek())
		{
		case IDENTIFIER:
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
			
			break;
		}
		default:
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
			
			break;
		}
		}
		
		return true;
	}
	
	@Override
	public int hashCode() 
	{
		return identifier.toString().hashCode();
	}

	@Override
	public void push(QBaseEqualityState state) 
	{
		equalityStateStack.push(state);
	}

	@Override
	public QBaseEqualityState popState() 
	{
		return equalityStateStack.pop();
	}
}
