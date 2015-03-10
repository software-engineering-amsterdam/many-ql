package gui.content;

import gui.UIComponent;
import gui.structure.Panel;
import gui.widget.InputWidget;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;

@SuppressWarnings("rawtypes")
public class UIComputedQuestion extends UIComponent {
	private Identifier identifier;
	private Panel questionPanel;
	private Expression expression;
	private ValueEnvironment valueEnvironment;
	
	private UIComponent questionText;
	private InputWidget inputWidget;
	
	public UIComputedQuestion(Identifier identifier, UIComponent questionText, 
			InputWidget inputWidget, Expression expression, ValueEnvironment valueEnvironment) {
		super();
		
		questionPanel = new Panel();
		
		this.identifier = identifier;
		this.expression = expression;
		this.questionText = questionText;	
		this.valueEnvironment = valueEnvironment;	
			
		this.inputWidget = inputWidget;		
		this.inputWidget.disable();
		
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.inputWidget);
	}

	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		valueEnvironment.store(identifier, changedValue);
		
		super.handleChange(changedValue, this);
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
		return questionPanel.getComponent();
	}
}
