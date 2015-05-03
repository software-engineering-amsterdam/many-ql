package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;

public abstract class QuestionViewController extends FormElementViewController 
{
	public QuestionViewController(FormQuestion question) 
	{
		super(question);
	}
	
	public QBaseQuestionType questionReturnType()
	{
		return ((FormQuestion) modelElement).returnType();
	}
	
	public String questionString()
	{
		return ((FormQuestion) modelElement).questionText().value();
	}
}
