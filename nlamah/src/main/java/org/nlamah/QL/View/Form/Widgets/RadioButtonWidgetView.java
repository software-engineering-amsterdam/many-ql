package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.WidgetViewDelegate;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;

@SuppressWarnings("serial")
public class RadioButtonWidgetView extends WidgetView implements ActionListener
{
	private List<JRadioButton> radioButtons;
	private ButtonGroup buttonGroup;
	private QBaseQuestionType returnType;
	private Map<TextLiteral, ? extends ValueExpression> map;

	public RadioButtonWidgetView(Map<TextLiteral, ? extends ValueExpression> map, QBaseQuestionType returnType)
	{
		super(returnType);

		this.map = map;
		this.returnType = returnType;

		initializeComponents();
		addComponentsToView();
		layoutView();

	}

	@Override
	public void layoutView() 
	{	
		int neededHeight = QLHelper.widgetTopPadding() + QLHelper.widgetBottomPadding();

		for (JRadioButton radioButton : radioButtons)
		{
			neededHeight += radioButton.getPreferredSize().height;
		}

		neededHeight = Math.max(neededHeight, super.getPreferredSize().height);

		setMaximumSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		setMinimumSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
	}

	@Override
	public void initializeComponents() 
	{	
		radioButtons = new ArrayList<JRadioButton>();
		buttonGroup = new ButtonGroup();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for (Map.Entry<TextLiteral, ? extends ValueExpression> entry : map.entrySet())
		{
			JRadioButton button = new JRadioButton(entry.getKey().toString());
			button.setActionCommand(entry.getKey().toString());

			radioButtons.add(button);

			button.addActionListener(this);
			buttonGroup.add(button);
		}
	}

	@Override
	public void setWidgetViewDelegate(WidgetViewDelegate widgetViewDelegate)
	{
		super.setWidgetViewDelegate(widgetViewDelegate);	

		setRightValueSelected();
	}

	private void setRightValueSelected()
	{
		for (JRadioButton radioButton : radioButtons)
		{
			ValueExpression defaultValue = QLHelper.defaultValueForQuestionType(returnType);

			TextLiteral key = new TextLiteral(radioButton.getActionCommand());
			ValueExpression buttonValue = map.get(key);

			if (defaultValue.equals(buttonValue))
			{
				notifiyNewValue(radioButton.getActionCommand());

				radioButton.setSelected(true);

				return;
			}
		}

		JRadioButton radioButton = radioButtons.get(0);

		radioButton.setSelected(true);

		notifiyNewValue(radioButton.getActionCommand());
	}

	@Override
	public void addComponentsToView() 
	{
		add(Box.createRigidArea(new Dimension(0, QLHelper.widgetTopPadding())));

		for (JRadioButton radioButton : radioButtons)
		{
			add(radioButton);
		}

		add(Box.createRigidArea(new Dimension(0, QLHelper.widgetBottomPadding())));
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		notifiyNewValue(e.getActionCommand());
	}

	private void notifiyNewValue(String actionCommandString)
	{		
		TextLiteral key = new TextLiteral(actionCommandString);

		ValueExpression value = map.get(key);

		switch (returnType())
		{
		case BOOLEAN:
		{
			widgetViewDelegate.valueChanged((BooleanLiteral) value);
			break;
		}
		case NUMBER:
		{
			widgetViewDelegate.valueChanged((NumberLiteral) value);
			break;
		}
		case TEXT:
		{
			widgetViewDelegate.valueChanged((TextLiteral) value);
			break;
		}
		default:
		{
			assert(false);
		}
		}
	}
}
