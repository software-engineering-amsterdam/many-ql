package gui.widget.composite;

import gui.Composite;
import gui.Widget;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.Evaluator;
import ql.value.BooleanValue;

public class IfPanel extends Composite {
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	private final Widget ifPanel, elsePanel;
	private JPanel activePanel;
	
	public IfPanel(Expression expression, ValueEnvironment valueEnvironment, Panel ifPanel, Panel elsePanel) {
		super(new Identifier("If panel."));
		
		this.expression = expression;
		this.valueEnvironment = valueEnvironment;
		
		this.activePanel = new JPanel();
		
		this.ifPanel = ifPanel;
		this.ifPanel.setHandler(this);
		activePanel.add(this.ifPanel.getComponent());
		
		this.elsePanel = elsePanel;
		this.elsePanel.setHandler(this);
		activePanel.add(this.elsePanel.getComponent());
		
		activateElsePanel();
	}
	
	public IfPanel(Expression expression, ValueEnvironment valueEnvironment, Panel ifComponent) {
		this(expression, valueEnvironment, ifComponent, new Panel(this));
	}
	
	public void activateIfPanel() {
		ifPanel.getComponent().setVisible(true);
		ifPanel.updateComponent();
		
		elsePanel.getComponent().setVisible(false);
		elsePanel.updateComponent();
	}
	
	public void activateElsePanel() {
		ifPanel.getComponent().setVisible(false);
		ifPanel.updateComponent();
		
		elsePanel.getComponent().setVisible(true);
		elsePanel.updateComponent();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void updateComponent() {
		// Recalculate the value for this computedQuestion
		Value value = Evaluator.check(expression, valueEnvironment);
		
		if(value.isUndefined()) {
			activateElsePanel();
			return;
		}
		
		if(((BooleanValue) value).getValue()) {
			activateIfPanel();
		} else {
			activateElsePanel();
		}
		
		activePanel.revalidate();
		activePanel.repaint();
	}
	
	@Override
	public JComponent getComponent() {		
		return activePanel;
	}
}
 