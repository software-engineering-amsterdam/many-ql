package org.nlamah.QL.Helper;

import java.util.ArrayList;

import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class QLHelper 
{
	static public boolean arrayExistsAndHasElements(ArrayList<?> arrayList)
	{
		return arrayList != null && arrayList.size() > 0;
	}
	
	static public int contentWidth()
	{
		return 600;
	}
	
	static public String surroundStringWithHtmlTags(String string)
	{
		return "<html>" + string + "</html>";
	}
	
	static public Question getQuestionWithIdentifier(ArrayList<Question> questions, IdentifierLiteral identifier)
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
	
	static public ArrayList<Question> getQuestionsWithIdentifier(ArrayList<Question> questions, IdentifierLiteral identifier)
	{
		ArrayList<Question> foundQuestions = new ArrayList<Question>();
		
		for (Question question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				foundQuestions.add(question);
			}
		}
		
		return foundQuestions;
	}
}


