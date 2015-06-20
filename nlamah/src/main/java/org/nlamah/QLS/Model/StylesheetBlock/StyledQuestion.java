package org.nlamah.QLS.Model.StylesheetBlock;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSNodeVisitor;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class StyledQuestion extends SectionItem
{
	private IdentifierValue identifier;

	private StyleBlock styleBlock;

	public StyledQuestion(IdentifierValue identifier, StyleBlock styleBlock)
	{
		this.identifier = identifier;
		this.styleBlock = styleBlock;

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

		return true;
	}

	@Override
	public int hashCode() 
	{
		return identifier.toString().hashCode();
	}
	
	static public List<StyledQuestion> getListWithDuplicatedQuestionIdentifiers(List<StyledQuestion> questions)
	{
		List<StyledQuestion> referenceList = new ArrayList<StyledQuestion>();
		List<StyledQuestion> listToReturn = new ArrayList<StyledQuestion>();

		for (StyledQuestion node : questions) 
		{			
			if (StyledQuestion.doesListAlreadyContainQuestionWithTheSameIdentifier(referenceList, node)) 
			{
				listToReturn.add(node);
			}
			else
			{
				referenceList.add(node);
			}
		}

		return listToReturn;
	} 
	
	static private boolean doesListAlreadyContainQuestionWithTheSameIdentifier(List<StyledQuestion> questions, StyledQuestion question)
	{		
		for (StyledQuestion loopedQuestion : questions)
		{
			if (loopedQuestion.identifier().equals(question.identifier()))
			{
				return true;
			}
		}
		
		return false;
	}
}