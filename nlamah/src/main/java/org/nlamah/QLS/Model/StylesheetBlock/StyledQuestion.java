package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.Stack;

import org.nlamah.QBase.EqualityStating;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class StyledQuestion extends SectionItem implements EqualityStating
{
	public Stack<QBaseEqualityState> equalityStateStack;

	private IdentifierValue identifier;

	private StyleBlock styleBlock;

	public StyledQuestion(IdentifierValue identifier, StyleBlock styleBlock)
	{
		super();

		this.identifier = identifier;
		this.styleBlock = styleBlock;

		equalityStateStack = new Stack<QBaseEqualityState>();
		equalityStateStack.push(QBaseEqualityState.ALL_PROPERTIES);

		if (styleBlock != null)
		{
			styleBlock.setParentNode(this);
		}
	}

	public IdentifierValue identifier()
	{
		return identifier;
	}

	public StyleBlock styleBlock()
	{
		return styleBlock;
	}

	public void setSyleBlock(StyleBlock styleBlock)
	{
		this.styleBlock = styleBlock;
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
		case IDENTIFIER_ONLY:
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

			if (styleBlock == null && value.styleBlock == null)
			{
				return true;
			}

			if (!styleBlock.equals(value.styleBlock))
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
