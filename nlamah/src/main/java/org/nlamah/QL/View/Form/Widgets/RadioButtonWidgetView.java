package org.nlamah.QL.View.Form.Widgets;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Helper.QLHelper;
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
	private Map<TextLiteral, ? extends ValueExpression> map;

	public RadioButtonWidgetView(Map<TextLiteral, ? extends ValueExpression> map, QBaseQuestionType returnType)
	{
		super(returnType);

		this.map = map;

		radioButtons = new ArrayList<JRadioButton>();
		buttonGroup = new ButtonGroup();

		int neededHeight = 20;
		
		for (Map.Entry<TextLiteral, ? extends ValueExpression> entry : map.entrySet())
		{
			JRadioButton button = new JRadioButton(entry.getKey().toString());
			button.setActionCommand(entry.getKey().toString());

			ValueExpression value = QLHelper.defaultValueForQuestionType(returnType);
			button.setSelected(value.equals(entry.getValue()));
			
			radioButtons.add(button);
			add(button);
			neededHeight += button.getPreferredSize().height;
			
			button.addActionListener(this);
			buttonGroup.add(button);
		}
		
		neededHeight = Math.max(neededHeight, super.getPreferredSize().height);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMaximumSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		setMinimumSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
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
	public ValueExpression value() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(ValueExpression value) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		TextLiteral key = new TextLiteral(e.getActionCommand());
		
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
