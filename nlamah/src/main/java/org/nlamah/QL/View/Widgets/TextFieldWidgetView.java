package org.nlamah.QL.View.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
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
		textField.setPreferredSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));
		textField.setMaximumSize(new Dimension(QLHelper.widgetWidth(), QLHelper.maximumTextFieldHeight()));	
	}

	@Override
	public void initializeComponents() 
	{
		textField = new JTextField();
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
