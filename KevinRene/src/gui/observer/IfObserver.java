package gui.observer;

import gui.Widget;

import java.util.Observable;
import java.util.Observer;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.Expression;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;

@SuppressWarnings("rawtypes")
public class IfObserver implements Observer {	
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	private final Widget ifPanel, elsePanel;
	
	public IfObserver(Expression expression, ValueEnvironment valueEnvironment, Widget ifPanel, Widget elsePanel) {
		this.expression = expression;
		this.valueEnvironment = valueEnvironment;
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
	}
	
	public IfObserver(Expression expression, ValueEnvironment valueEnvironment, Widget ifComponent) {
		this(expression, valueEnvironment, ifComponent, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Yay If observer");
		try {
			// Recalculate the value for this computedQuestion
			Value value = Evaluator.check(expression, valueEnvironment);	
			System.out.println("Value: "+ value);
			
			boolean visible = ((BooleanValue)value).getValue();
			ifPanel.getComponent().setVisible(visible);
				
			if (elsePanel != null) {
				elsePanel.getComponent().setVisible(!visible);
			}
		}
		catch (UnsupportedOperationException e) {
			System.err.println(e);
		}
	}

}
