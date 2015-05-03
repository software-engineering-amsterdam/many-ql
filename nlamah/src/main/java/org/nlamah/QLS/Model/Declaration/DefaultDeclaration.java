package org.nlamah.QLS.Model.Declaration;

import java.util.List;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.StyleDeclaration;

public class DefaultDeclaration extends QLSNode
{
	public boolean checkForTypeEquality;
	
	private QBaseQuestionType questionType;
	private List<StyleDeclaration> styleDeclarations;
	
	public DefaultDeclaration(QBaseQuestionType questionType, List<StyleDeclaration> styleDeclarations)
	{
		super();
		
		this.questionType = questionType;
		
		this.styleDeclarations = styleDeclarations;
		
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
		if (checkForTypeEquality)
		{
			if (!(object instanceof DefaultDeclaration))
			{
				return false;
			}
			
			DefaultDeclaration value = (DefaultDeclaration) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}

			return true;
		}
		else
		{
			if (!(object instanceof DefaultDeclaration))
			{
				return false;
			}
			
			DefaultDeclaration value = (DefaultDeclaration) object;
			
			if (this.questionType != value.questionType)
			{
				return false;
			}
			
			if (!this.styleDeclarations.equals(value.styleDeclarations))
			{
				return false;
			}

			return true;
		}
	}
	
	@Override
	public int hashCode()
	{
		return questionType.toString().hashCode();
	}
}
