package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.Expression;
import cons.ql.ast.statement.If;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;

public class IfObserver implements Observer {
	
	private final Expression expression;
	private final ValueEnvironment valueEnv;
	private final JComponent ifComponent, elseComponent;
	
	public IfObserver(Expression expression, ValueEnvironment valueEnv, JComponent ifComponent, JComponent elseComponent) {
		this.expression = expression;
		this.valueEnv = valueEnv;
		this.ifComponent = ifComponent;
		this.elseComponent = elseComponent;
	}
	public IfObserver(Expression expression, ValueEnvironment valueEnv, JComponent ifComponent) {
		this(expression, valueEnv, ifComponent, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		// Recalculate the value for this computedQuestion
		Value value = expression.accept(new Evaluator(valueEnv));	

		if (value.isUndefined()) {
			return;
		}
		
		boolean visible = ((BooleanValue)value).getValue();
		this.ifComponent.setVisible(visible);
				
		if (elseComponent != null) {
			this.elseComponent.setVisible(!visible);
		}
	}

}
