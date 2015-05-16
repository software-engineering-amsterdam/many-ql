package org.nlamah.QL.Helper;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class QLHelper 
{	
	static public String surroundStringWithHtmlTags(String string)
	{
		return "<html>" + string + "</html>";
	}

	static public FormQuestion getQuestionWithIdentifier(List<FormQuestion> questions, IdentifierLiteral identifier)
	{
		for (FormQuestion question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				return question;
			}
		}

		return null;
	}

	static public List<FormQuestion> getQuestionsWithIdentifier(List<FormQuestion> questions, IdentifierLiteral identifier)
	{
		List<FormQuestion> foundQuestions = new ArrayList<FormQuestion>();

		for (FormQuestion question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				foundQuestions.add(question);
			}
		}

		return foundQuestions;
	}

	static public List<FormQuestion> getQuestionsWithQuestionText(List<FormQuestion> questions, TextLiteral questionText)
	{
		List<FormQuestion> foundQuestions = new ArrayList<FormQuestion>();

		for (FormQuestion question : questions)
		{
			if (question.questionText().equals(questionText))
			{
				foundQuestions.add(question);
			}
		}

		return foundQuestions;
	}


	static public int contentWidth()
	{
		return 700;
	}

	static public int labelLeftMargin()
	{
		return 30;
	}

	static public int labelRightMargin()
	{
		return 15;
	}

	static public int widgetWidth()
	{
		return 250;
	}

	static public int widgetRightMargin()
	{
		return 15;
	}
	
	static public int widgetTopPadding() 
	{
		return 10;
	}
	
	static public int widgetBottomPadding() 
	{
		return 10;
	}

	static public int labelTopMargin()
	{
		return 15;
	}

	static public int labelBottomMargin()
	{
		return 15;
	}
	static public int defaultQuestionHeight()
	{
		return 50;
	}

	static public int maximumTextFieldHeight()
	{
		return 30;
	}

	static public int navigationViewWidth()
	{
		return 225;
	}

	static public ValueExpression defaultValueForQuestionType(QBaseQuestionType type)
	{
		switch(type)
		{
		case BOOLEAN:return new BooleanLiteral(false);
		case NUMBER:return new NumberLiteral(0);
		case TEXT: return new TextLiteral("");
		default: assert(false);
		}

		return null;
	}
}


