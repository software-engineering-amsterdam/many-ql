package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class NumberFieldWidgetView extends WidgetView implements ActionListener
{
	private JTextField textField;

	public NumberFieldWidgetView()
	{
		super(QBaseQuestionType.NUMBER);
		
		textField = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField.addActionListener(this);
		
		textField.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		
		add(textField);
	}
	
	@Override
	public ValueExpression value() 
	{
		return new NumberLiteral(textField.getText());
	}

	@Override
	public void setValue(ValueExpression value) 
	{
		if (value == null)
		{
			return;
		}
		
		this.value = value;
		
		assert(value instanceof NumberLiteral);
		
		textField.setText(value.toString());
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedNumberString = textField.getText();
		
		widgetViewDelegate.valueChanged(new NumberLiteral(insertedNumberString));
	}
}
