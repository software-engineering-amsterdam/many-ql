package org.nlamah.QL.ViewControllers.Form.Abstract;

import org.nlamah.QL.Model.Form.Abstract.Question;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;

public abstract class QuestionViewController extends FormElementViewController 
{
	public QuestionViewController(Question question) 
	{
		super(question);
	}
	
	public QuestionReturnType questionReturnType()
	{
		return ((Question) modelElement).returnType();
	}
	
	public String questionString()
	{
		return ((Question) modelElement).questionText().value();
	}
}
