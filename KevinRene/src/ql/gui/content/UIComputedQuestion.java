package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;
import ql.gui.widget.InputWidget;

public class UIComputedQuestion implements UIComponent {
	private final Identifier identifier;
	private final Panel questionPanel;
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	
	private final UIComponent questionText;
	private final InputWidget<Value> inputWidget;

	private UIComponent handler;
	
	@SuppressWarnings("unchecked")
	public UIComputedQuestion(Identifier identifier, UIComponent questionText, 
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
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		valueEnvironment.store(identifier, changedValue);
		
		handler.handleChange(changedValue, this);
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
