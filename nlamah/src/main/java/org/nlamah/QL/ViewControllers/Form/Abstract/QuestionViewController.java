package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.Question;

public abstract class QuestionViewController extends FormElementViewController 
{
	public QuestionViewController(Question question) 
	{
		super(question);
	}
	
	public QBaseQuestionType questionReturnType()
	{
		return ((Question) modelElement).returnType();
	}
	
	public String questionString()
	{
		return ((Question) modelElement).questionText().value();
	}
}
