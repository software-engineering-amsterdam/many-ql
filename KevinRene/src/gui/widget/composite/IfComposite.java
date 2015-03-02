package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.util.Observable;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.BooleanValue;
import cons.value.UndefinedValue;

public class IfComposite extends Composite {
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	private final Widget ifPanel, elsePanel;
	private JPanel activePanel;
	
	public IfComposite(Expression expression, ValueEnvironment valueEnvironment, Panel ifPanel, Panel elsePanel) {
		super(new Identifier("If panel."));
		
		this.expression = expression;
		this.valueEnvironment = valueEnvironment;
		
		this.ifPanel = ifPanel;
		this.ifPanel.addObserver(this);
		
		this.elsePanel = elsePanel;
		this.elsePanel.addObserver(this);
		
		this.activePanel = new JPanel();
	}
	
	public IfComposite(Expression expression, ValueEnvironment valueEnvironment, Panel ifComponent) {
		this(expression, valueEnvironment, ifComponent, new Panel());
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Something in the if block changed.");
		
		setChanged();
		notifyObservers();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public JComponent getComponent() {
		// Recalculate the value for this computedQuestion
		Value value = Evaluator.check(expression, valueEnvironment);
		
		if(value instanceof UndefinedValue) {
			activePanel.add(elsePanel.getComponent());	
			return activePanel;
		}
		
		activePanel.removeAll();
		
		if(((BooleanValue) value).getValue()) {
			activePanel.add(ifPanel.getComponent());			
		} else {
			activePanel.add(elsePanel.getComponent());	
		}
		
		activePanel.revalidate();
		activePanel.setVisible(true);
		activePanel.repaint();
		
		return activePanel;
	}
}
