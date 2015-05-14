package org.nlamah.QL.View.Form.Widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Expression.Literal.NumberLiteral;
import org.nlamah.QL.Model.Expression.Literal.TextLiteral;
import org.nlamah.QL.View.Form.Abstract.WidgetView;
import org.nlamah.QLS.Model.Abstract.DeclarationValue;
import org.nlamah.QLS.Model.Value.BooleanValue;
import org.nlamah.QLS.Model.Value.NumberValue;
import org.nlamah.QLS.Model.Value.TextValue;

@SuppressWarnings("serial")
public class RadioButtonWidgetView extends WidgetView implements ActionListener
{
	private List<JRadioButton> radioButtons;
	private ButtonGroup buttonGroup;
	private Map<TextValue, ? extends DeclarationValue> map;

	public RadioButtonWidgetView(Map<TextValue, ? extends DeclarationValue> map, QBaseQuestionType returnType)
	{
		super(returnType);

		this.map = map;

		radioButtons = new ArrayList<JRadioButton>();
		buttonGroup = new ButtonGroup();

		for (Map.Entry<TextValue, ? extends DeclarationValue> entry : map.entrySet())
		{
			JRadioButton button = new JRadioButton(entry.getKey().toString());
			button.setActionCommand(entry.getKey().toString());
			button.setSelected(true);

			radioButtons.add(button);
			button.addActionListener(this);
			buttonGroup.add(button);
		}
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
		DeclarationValue value = map.get(new TextLiteral(e.getActionCommand()));

		switch (returnType())
		{
		case BOOLEAN:
		{
			BooleanValue booleanValue = (BooleanValue) value;
			widgetViewDelegate.valueChanged(new BooleanLiteral(booleanValue.value()));
			break;
		}
		case NUMBER:
		{
			NumberValue numberValue = (NumberValue) value;
			widgetViewDelegate.valueChanged(new NumberLiteral(Integer.toString(numberValue.number())));
			break;
		}
		case TEXT:
		{
			TextValue textValue = (TextValue) value;
			widgetViewDelegate.valueChanged(new NumberLiteral(textValue.toString()));
			break;
		}
		default:
		{
			assert(false);
		}
		}
	}
}
