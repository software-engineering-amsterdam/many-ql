package org.nlamah.QL.View.Form.Abstract;

import javax.swing.BoxLayout;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Interfaces.WidgetViewDelegate;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

@SuppressWarnings("serial")
public abstract class WidgetView extends FormElementView
{
	private QBaseQuestionType returnType;
	
	protected ValueExpression value;
	protected WidgetViewDelegate widgetViewDelegate;
	
	public WidgetView(QBaseQuestionType returnType)
	{
		super();
		
		this.returnType = returnType;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	public QBaseQuestionType returnType()
	{
		return returnType;
	}
	
	public void setWidgetViewDelegate(WidgetViewDelegate widgetViewDelegate)
	{
		this.widgetViewDelegate = widgetViewDelegate;
	}
}
