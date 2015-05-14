package org.nlamah.QL.View.Form.Abstract;

import javax.swing.BoxLayout;

import org.nlamah.QL.Interfaces.WidgetViewDelegate;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

@SuppressWarnings("serial")
public abstract class WidgetView extends FormElementView
{
	protected ValueExpression value;
	protected WidgetViewDelegate widgetViewDelegate;
	
	public WidgetView()
	{
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	public void setWidgetViewDelegate(WidgetViewDelegate widgetViewDelegate)
	{
		this.widgetViewDelegate = widgetViewDelegate;
	}
	
	abstract public ValueExpression value();
	abstract public void setValue(ValueExpression value);
}
