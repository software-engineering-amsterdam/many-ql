package org.nlamah.QL.Model.Form.Abstract;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;

public abstract class FormQuestion extends FormElement
{
	private TextLiteral questionText;
	private QBaseQuestionType type;

	public FormQuestion(IdentifierLiteral identifier, TextLiteral questionString, QBaseQuestionType type) 
	{
		super(identifier);

		this.questionText = questionString;
		this.type = type;

		if (identifier != null)
		{
			identifier.setParentNode(this);
		}

		if (questionString != null)
		{
			questionString.setParentNode(this);
		}
	}

	public QBaseQuestionType returnType()
	{
		return type;
	}

	public TextLiteral questionText()
	{
		return questionText;
	}

	public abstract ValueExpression value();

	@Override 
	public boolean equals(Object object) 
	{
		if (!super.equals(object))
		{
			return false;
		}

		if (!(object instanceof FormQuestion))
		{
			return false;
		}

		FormQuestion value = (FormQuestion) object;

		if (!(this.questionText.equals(value.questionText)))
		{
			return false;
		}

		if (!(this.type.equals(value.type)))
		{
			return false;
		}

		return true;
	}

	@Override
	public int hashCode()
	{
		return identifier().toString().hashCode();
	}

	static public List<FormQuestion> getListWithDuplicatedQuestionIdentifiers(List<FormQuestion> questions)
	{
		List<FormQuestion> referenceList = new ArrayList<FormQuestion>();
		List<FormQuestion> listToReturn = new ArrayList<FormQuestion>();

		for (FormQuestion node : questions) 
		{			
			if (FormQuestion.doesListAlreadyContainQuestionWithTheSameIdentifier(referenceList, node)) 
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
	
	static public List<FormQuestion> getListWithDuplicatedQuestionTexts(List<FormQuestion> questions)
	{
		List<FormQuestion> referenceList = new ArrayList<FormQuestion>();
		List<FormQuestion> listToReturn = new ArrayList<FormQuestion>();

		for (FormQuestion node : questions) 
		{
			if (FormQuestion.doesListAlreadyContainQuestionWithTheSameTextLabel(referenceList, node)) 
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

	static private boolean doesListAlreadyContainQuestionWithTheSameIdentifier(List<FormQuestion> questions, FormQuestion question)
	{		
		for (FormQuestion loopedQuestion : questions)
		{
			if (loopedQuestion.identifier().equals(question.identifier()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	static private boolean doesListAlreadyContainQuestionWithTheSameTextLabel(List<FormQuestion> questions, FormQuestion question)
	{		
		for (FormQuestion loopedQuestion : questions)
		{
			if (loopedQuestion.questionText.equals(question.questionText))
			{
				return true;
			}
		}
		
		return false;
	}
}