package gui;

import java.util.Observable;
import java.util.Observer;

import cons.Value;
import cons.ql.ast.statement.ComputedQuestion;
import cons.ql.ast.visitor.evaluator.Evaluator;

public class ComputedQuestionObserver implements Observer {
	
	private final ComputedQuestion expression;
	private final Controller controller;
	private final Component component;
	
	public ComputedQuestionObserver(ComputedQuestion expression, Controller controller, Component component) {
		this.expression = expression;
		this.controller = controller;
		this.component = component;
	}

	@Override
	public void update(Observable o, Object arg) {

		try {
			// Recalculate the value for this computedQuestion
			Value value = expression.getExpression().accept(new Evaluator(controller.getValueEnvironment()));	
	
//			System.out.println("new value for " + expression.getIdentifier() + ": " + value);
				
			// Update the type environment
			controller.storeValue(expression.getIdentifier(), value);
				
			// Now update all the Components that watch the computedQuestion
			controller.notify(expression.getIdentifier());
				
			// Now also update the component
			component.setValue(value);
		}
		catch (UnsupportedOperationException e) {
			
		}
	}
}