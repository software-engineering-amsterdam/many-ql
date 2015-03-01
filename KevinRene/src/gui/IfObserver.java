package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import cons.Value;
import cons.ql.ast.statement.If;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;

public class IfObserver implements Observer {
	
	private final If expression;
	private final Controller controller;
	private final JComponent component;
	
	public IfObserver(If expression, Controller controller, JComponent component) {
		this.expression = expression;
		this.controller = controller;
		this.component = component;
		this.component.setVisible(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			// Recalculate the value for this computedQuestion
			Value value = expression.getExpression().accept(new Evaluator(controller.getValueEnvironment()));	
				
			if (value instanceof BooleanValue) {
				boolean visible = ((BooleanValue)value).getValue();
				this.component.setVisible(visible);
			}
		}
		catch (UnsupportedOperationException e) {
			
		}
	}

}
