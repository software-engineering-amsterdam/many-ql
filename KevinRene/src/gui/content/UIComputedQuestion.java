package gui.content;

import gui.UIComponent;
import gui.structure.Section;
import gui.widget.InputWidget;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;

public class UIComputedQuestion extends UIComponent {
	private final Identifier identifier;
	private final Section questionPanel;
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	
	private final UIComponent questionText;
	private final InputWidget<Value<?>> inputWidget;
	
	@SuppressWarnings("unchecked")
	public UIComputedQuestion(Identifier identifier, UIComponent questionText, 
			InputWidget<?> inputWidget, Expression expression, ValueEnvironment valueEnvironment) {
		this.identifier = identifier;
		this.expression = expression;
		this.questionText = questionText;	
		this.valueEnvironment = valueEnvironment;	
			
		this.inputWidget = (InputWidget<Value<?>>) inputWidget;		
		this.inputWidget.disable();
		
		questionPanel = new Section(this);
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.inputWidget);
	}

	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void handleChange(Value<?> changedValue, UIComponent source) {
		valueEnvironment.store(identifier, changedValue);
		
		super.handleChange(changedValue, this);
	}
	
	@Override
	public void updateComponent() {
		Value<?> expressionValue = Evaluator.check(expression, valueEnvironment);

		if(expressionValue.isUndefined()) {
			return;
		}

		inputWidget.setValue(expressionValue);
	}
	
	
	@Override
	public JComponent getComponent() {
		return questionPanel.getComponent();
	}
}
