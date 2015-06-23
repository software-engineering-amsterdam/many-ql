package org.nlamah.QL.View.Widgets;

import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.nlamah.QBase.Constants.QBaseQuestionType;
import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class SpinnerWidgetView extends WidgetView implements ChangeListener
{
	private JSpinner spinner;

	public SpinnerWidgetView(QBaseQuestionType returnType)
	{
		super(returnType);

		initializeComponents();
		addComponentsToView();
		layoutView();
	}

	@Override
	public void layoutView() 
	{
		spinner.setPreferredSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
		spinner.setMaximumSize(new Dimension(UIConstants.widgetWidth(), UIConstants.maximumTextFieldHeight()));
	}

	@Override
	public void initializeComponents() 
	{
		ValueExpression value = UIConstants.defaultValueForQuestionType(returnType());
		int number = Integer.parseInt(value.toString());
		SpinnerNumberModel model = new SpinnerNumberModel(number, 0, 1000, 1);

		spinner = new JSpinner(model);
		spinner.addChangeListener(this);
	}

	@Override
	public void addComponentsToView() 
	{
		add(spinner);
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		SpinnerNumberModel numberModel = (SpinnerNumberModel) spinner.getModel();
		Number numberObject = numberModel.getNumber();

		widgetViewDelegate.valueChanged(new NumberLiteral(numberObject.intValue()));
	}
}