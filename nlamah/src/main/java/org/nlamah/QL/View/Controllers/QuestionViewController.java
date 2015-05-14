package org.nlamah.QL.View.Controllers;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Interfaces.WidgetViewDelegate;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QL.View.Form.Abstract.QuestionView;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

public class QuestionViewController extends FormElementViewController implements WidgetViewDelegate
{	
	public QuestionViewController(FormQuestion question, WidgetView widgetView) 
	{
		super(question);
		
		widgetView.setWidgetViewDelegate(this);

		widgetView.setValue(question.value());
		
		view = new QuestionView(question, widgetView);
	}
	
	public QBaseQuestionType questionReturnType()
	{
		return ((FormQuestion) modelElement).returnType();
	}
	
	public String questionString()
	{
		return ((FormQuestion) modelElement).questionText().value();
	}

	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}

	@Override
	public void valueChanged(ValueExpression newValue) 
	{
		FormQuestion question = (FormQuestion) modelElement;
		
		question.setValue(newValue);
		
		rootViewController.modelStateChanged();
	}

	@Override
	public int neededViewHeight() 
	{
		return view.getPreferredSize().height;
	}
}