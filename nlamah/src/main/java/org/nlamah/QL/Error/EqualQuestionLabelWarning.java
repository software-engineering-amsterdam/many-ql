package org.nlamah.QL.Error;

import java.util.List;
import java.util.Iterator;

import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QL.Model.Form.Abstract.Question;

public class EqualQuestionLabelWarning extends QBaseWarning 
{
	private List<Question> questions;

	public EqualQuestionLabelWarning(List<Question> questions)
	{
		this.questions = questions;
	}

	@Override
	public String description() 
	{
		String errorString = "WARNING: The questions declared on lines ";

		for (Iterator<Question> i = questions.iterator(); i.hasNext(); ) 
		{
			errorString += i.next().startsOnLine;

			if (i.hasNext()) 
			{
				errorString += " and ";
			}
		}

		errorString += " have equal labels.";

		return errorString;	
	}

	@Override 
	public boolean equals(Object object) 
	{
		if (!(object instanceof EqualQuestionLabelWarning))
		{
			return false;
		}

		EqualQuestionLabelWarning value = (EqualQuestionLabelWarning)object;

		if (!this.questions.equals(value.questions))
		{
			return false;
		}

		return true;
	}
}
