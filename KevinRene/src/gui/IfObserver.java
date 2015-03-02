package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import cons.Value;
import cons.ql.ast.Expression;
import cons.ql.ast.statement.If;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;

public class IfObserver implements Observer {
	
	private final Expression expression;
	private final Controller controller;
	private final JComponent ifComponent, elseComponent;
	
	public IfObserver(Expression expression, Controller controller, JComponent ifComponent, JComponent elseComponent) {
		this.expression = expression;
		this.controller = controller;
		this.ifComponent = ifComponent;
		this.elseComponent = elseComponent;
	}
	public IfObserver(Expression expression, Controller controller, JComponent ifComponent) {
		this(expression, controller, ifComponent, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			// Recalculate the value for this computedQuestion
			Value value = expression.accept(new Evaluator(controller.getValueEnvironment()));	
			System.out.println(value);
				
			
			boolean visible = ((BooleanValue)value).getValue();
			this.ifComponent.setVisible(visible);
				
			if (elseComponent != null) {
				this.elseComponent.setVisible(!visible);
			}
		}
		catch (UnsupportedOperationException e) {
			System.err.println(e);
		}
	}

}
