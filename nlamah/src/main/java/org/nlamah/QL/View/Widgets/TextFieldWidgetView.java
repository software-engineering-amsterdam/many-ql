package org.nlamah.QL.View.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
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
		ValueExpression defaultValue = UIConstants.defaultValueForQuestionType(QBaseQuestionType.TEXT);
		
		textField = new JTextField(defaultValue.toString());
		textField.addActionListener(this);
	}

	@Override
	public void addComponentsToView() 
	{
		add(textField);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String insertedTextString = ((JTextField) e.getSource()).getText();

		widgetViewDelegate.valueChanged(new TextLiteral(insertedTextString));
	}
}