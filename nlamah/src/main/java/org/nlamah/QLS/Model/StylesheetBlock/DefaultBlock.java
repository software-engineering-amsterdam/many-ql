package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.List;
import java.util.Stack;

import org.nlamah.QBase.EqualityStating;
import org.nlamah.QBase.QBaseEqualityState;
import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Helper.QLSHelper;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class DefaultBlock extends SectionItem implements EqualityStating
{
	public Stack<QBaseEqualityState> equalityStateStack;
	
	private QBaseQuestionType questionType;
	private List<StyleDeclaration> styleDeclarations;
	
	public DefaultBlock(QBaseQuestionType questionType, List<StyleDeclaration> styleDeclarations)
	{
		super();
		
		assert(styleDeclarations != null);
		
		this.questionType = questionType;
		this.styleDeclarations = styleDeclarations;
		
		equalityStateStack = new Stack<QBaseEqualityState>();
		equalityStateStack.push(QBaseEqualityState.ALL);
		
		for (StyleDeclaration styleDeclaration : styleDeclarations)
		{
			styleDeclaration.setParentNode(this);
		}
	}
	
	public QBaseQuestionType questionType()
	{
		return questionType;
	}
	
	public List<StyleDeclaration> styleDeclarations()
	{		
		return styleDeclarations;
	}
	
	public void overWriteStyleDeclaration(StyleDeclaration styleDeclaration)
	{
		List<StyleDeclaration> foundStyleDeclarations = QLSHelper.findStyleDeclarationsOfTheSameClass(styleDeclaration, styleDeclarations);
		
		if (foundStyleDeclarations.size() == 0)
		{
			styleDeclarations.add(styleDeclaration);
		}
		else
		{
			assert(foundStyleDeclarations.size() == 1);
			
			styleDeclarations.remove(foundStyleDeclarations.get(0));
			styleDeclarations.add(styleDeclaration);
		}
	}

	@Override
	public QLSNode accept(QLSNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override
	public String toString()
	{
		//TODO
		return questionType.toString();
	}
	
	@Override 
	public boolean equals(Object object) 
	{
		
		switch(equalityStateStack.peek())
		{
		case TYPE:
		{
			if (!(object instanceof DefaultBlock))
			{
				return false;
			}
			
			DefaultBlock value = (DefaultBlock) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}
			
			break;
		}
		default:
		{
			if (!(object instanceof DefaultBlock))
			{
				return false;
			}
			
			DefaultBlock value = (DefaultBlock) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}
			
			if (!this.styleDeclarations.equals(value.styleDeclarations))
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
		return questionType.toString().hashCode();
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
