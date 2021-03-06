package org.nlamah.QL.View.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class NumberFieldWidgetView extends WidgetView implements ActionListener
{
	private JTextField textField;

	public NumberFieldWidgetView()
	{
		super(QBaseQuestionType.NUMBER);

		initializeComponents();
		addComponentsToView();
		layoutView();
	}

	@Override
	public void layoutView() 
	{
		textField.setPreferredSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
	}

	@Override
	public void initializeComponents() 
	{
		textField = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField.addActionListener(this);	
		
		NumberLiteral defaultValue = (NumberLiteral)UIConstants.defaultValueForQuestionType(QBaseQuestionType.NUMBER);
		textField.setText(defaultValue.toString());	
	}

	@Override
	public void addComponentsToView() 
	{
		add(textField);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedNumberString = textField.getText();

		widgetViewDelegate.valueChanged(new NumberLiteral(Integer.parseInt(insertedNumberString)));
	}
}