package org.nlamah.QL.Helper;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class QLHelper 
{
	static public boolean arrayExistsAndHasElements(List<?> List)
	{
		return List != null && List.size() > 0;
	}
	
	static public String surroundStringWithHtmlTags(String string)
	{
		return "<html>" + string + "</html>";
	}
	
	static public Question getQuestionWithIdentifier(List<Question> questions, IdentifierLiteral identifier)
	{
		for (Question question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				return question;
			}
		}
		
		return null;
	}
	
	static public List<Question> getQuestionsWithIdentifier(List<Question> questions, IdentifierLiteral identifier)
	{
		List<Question> foundQuestions = new ArrayList<Question>();
		
		for (Question question : questions)
		{
			if (question.identifier().equals(identifier))
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
}


