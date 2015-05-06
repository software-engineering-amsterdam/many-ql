package org.nlamah.QLS.Helper;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.Value.IdentifierValue;

public class QLSHelper 
{

	static boolean doesExist()
	{
		return false;
	}
	
	static public List<StyledQuestion> getQuestionsWithIdentifier(List<StyledQuestion> questions, IdentifierValue identifier)
	{
		List<StyledQuestion> foundQuestions = new ArrayList<StyledQuestion>();
		
		for (StyledQuestion question : questions)
		{
			if (question.identifier().equals(identifier))
			{
				foundQuestions.add(question);
			}
		}
		
		return foundQuestions;
	}

	public static boolean questionIsStyled(FormQuestion formQuestion, List<StyledQuestion> styledQuestions) 
	{		
		for (StyledQuestion styledQuestion : styledQuestions)
		{
			if (questionsHaveTheSameIdentifier(formQuestion, styledQuestion))
			{
				return true;
			}
		}
		
		
		return false;
	}


	public static boolean doesStyledQuestionExistInForm(StyledQuestion styledQuestion, List<FormQuestion> formQuestions) 
	{
		for (FormQuestion formQuestion : formQuestions)
		{
			if (questionsHaveTheSameIdentifier(formQuestion, styledQuestion))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean questionsHaveTheSameIdentifier(FormQuestion formQuestion, StyledQuestion styledQuestion) 
	{
		return formQuestion.identifier().toString().equals(styledQuestion.identifier().toString());
	}
}
