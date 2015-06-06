package org.nlamah.QL.Helper;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
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
}