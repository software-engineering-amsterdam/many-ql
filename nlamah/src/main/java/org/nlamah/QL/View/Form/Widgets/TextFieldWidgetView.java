package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class TextFieldWidgetView extends WidgetView implements ActionListener
{
	private JTextField textField;
	
	public TextFieldWidgetView()
	{
		super(QBaseQuestionType.TEXT);
		
		textField = new JTextField();
		textField.addActionListener(this);
		
		textField.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		
		add(textField);
	}
	
	@Override
	public ValueExpression value() 
	{
		return new TextLiteral(textField.getText());
	}

	@Override
	public void setValue(ValueExpression value) 
	{
		if (value == null)
		{
			return;
		}
		
		this.value = value;
		
		assert(value instanceof TextLiteral);
		
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
		String insertedTextString = ((JTextField) e.getSource()).getText();
		
		widgetViewDelegate.valueChanged(new TextLiteral(insertedTextString));
	}
}
