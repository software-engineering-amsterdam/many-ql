package org.nlamah.QL.View.Form.Widgets;

import javax.swing.JLabel;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class ComputedValueWidgetView extends WidgetView 
{
	private JLabel label;
	
	public ComputedValueWidgetView() 
	{
		super(QBaseQuestionType.TEXT);
		
		label = new JLabel();

		add(label);
	}
	
	@Override
	public ValueExpression value() 
	{
		return new TextLiteral(label.getText());
	}

	@Override
	public void setValue(ValueExpression value) 
	{
		this.value = value;
		
		assert(value instanceof TextLiteral);
		
		label.setText(value.toString());
	}
	
	@Override
	public void layoutView() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void initializeComponents() 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void addComponentsToView() 
	{
		// TODO Auto-generated method stub
	}
}

