package gui;

import gui.widgets.Widget;

import java.util.Observable;
import java.util.Observer;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.visitor.evaluator.Evaluator;

public class ComputedQuestionObserver implements Observer {
	
	private final ComputedQuestion expression;
	private final ValueEnvironment controller;
	private final Widget component;
	
	public ComputedQuestionObserver(ComputedQuestion expression, ValueEnvironment controller, Widget component) {
		this.expression = expression;
		this.controller = controller;
		this.component = component;
	}

	@Override
	public void update(Observable o, Object arg) {
		// Recalculate the value for this computedQuestion
		Value value = expression.getExpression().accept(new Evaluator(controller));	
	
		if (value.isUndefined()) {
			return;
		}
		// Update the type environment
		controller.store(expression.getIdentifier(), value);
								
		// Now also update the component
		component.setValue(value);
	}
}