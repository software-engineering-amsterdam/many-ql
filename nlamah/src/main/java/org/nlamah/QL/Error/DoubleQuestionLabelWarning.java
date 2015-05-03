package org.nlamah.QL.Error;

import java.util.List;
import java.util.Iterator;

import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public class DoubleQuestionLabelWarning extends QBaseWarning 
{
	private List<FormQuestion> questions;

	public DoubleQuestionLabelWarning(List<FormQuestion> questions)
	{
		this.questions = questions;
	}

	@Override
	public String description() 
	{
		String errorString = "WARNING: The questions declared on lines ";

		for (Iterator<FormQuestion> i = questions.iterator(); i.hasNext(); ) 
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
		if (!(object instanceof DoubleQuestionLabelWarning))
		{
			return false;
		}

		DoubleQuestionLabelWarning value = (DoubleQuestionLabelWarning)object;

		if (!this.questions.equals(value.questions))
		{
			return false;
		}

		return true;
	}
}
