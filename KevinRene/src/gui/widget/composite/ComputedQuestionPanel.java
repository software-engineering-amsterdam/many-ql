package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;
import gui.widget.InputWidget;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;

@SuppressWarnings("rawtypes")
public class ComputedQuestionPanel extends Composite {
	private JPanel questionPanel;
	private Expression expression;
	private ValueEnvironment valueEnvironment;
	
	private Widget questionText;
	private InputWidget inputWidget;
	
	public ComputedQuestionPanel(Identifier identifier, Widget questionText, 
			Widget inputWidget, Expression expression, ValueEnvironment valueEnvironment) {
		super(identifier);
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		this.questionText = questionText;
		this.questionText.setHandler(this);		
		questionPanel.add(this.questionText.getComponent());
		
		this.inputWidget = (InputWidget) inputWidget;		
		this.inputWidget.setHandler(this);
		this.inputWidget.disable();		
		questionPanel.add(this.inputWidget.getComponent());
		
		this.expression = expression;
		
		this.valueEnvironment = valueEnvironment;		
	}

	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void handleChange(Value changedValue) {
		valueEnvironment.store(getIdentifier(), changedValue);
		
		super.handleChange(changedValue);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateComponent() {
		Value expressionValue = Evaluator.check(expression, valueEnvironment);

		if(expressionValue.isUndefined()) {
			return;
		}

		inputWidget.setValue(expressionValue);
	}
	
	
	@Override
	public JComponent getComponent() {
		return questionPanel;
	}
}
