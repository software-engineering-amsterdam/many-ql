package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.DefaultComponent;
import ql.gui.Component;
import ql.gui.structure.Panel;
import ql.gui.widget.InputWidget;

public class UIComputedQuestion extends DefaultComponent {
	private final Identifier identifier;
	private final Panel questionPanel;
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	
	private final Component questionText;
	private final InputWidget<Value> inputWidget;
	
	@SuppressWarnings("unchecked")
	public UIComputedQuestion(Identifier identifier, Component questionText, 
			InputWidget<?> inputWidget, Expression expression, ValueEnvironment valueEnvironment) {
		this.identifier = identifier;
		this.expression = expression;
		this.questionText = questionText;	
		this.valueEnvironment = valueEnvironment;	
			
		this.inputWidget = (InputWidget<Value>) inputWidget;		
		this.inputWidget.disable();
		
		questionPanel = new Panel(this);
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.inputWidget);
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void handleChange(Value changedValue, Component source) {
		valueEnvironment.store(identifier, changedValue);
		
		super.handleChange(changedValue, this);
	}
	
	@Override
	public void updateComponent() {
		Value expressionValue = Evaluator.check(expression, valueEnvironment);

		if(expressionValue.isUndefined()) {
			return;
		}

		inputWidget.setValue(expressionValue);
		inputWidget.updateComponent();
	}
	
	
	@Override
	public JComponent getComponent() {
		return questionPanel.getComponent();
	}
}
