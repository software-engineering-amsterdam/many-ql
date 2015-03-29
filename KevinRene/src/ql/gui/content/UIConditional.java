package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ast.Expression;
import ql.ast.visitor.evaluator.Evaluator;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.DefaultComponent;
import ql.gui.Component;
import ql.gui.structure.Panel;
import ql.value.BooleanValue;

public class UIConditional extends DefaultComponent {
	private Panel activePanel;
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	private final Component ifPanel, elsePanel;
	
	public UIConditional(Expression expression, ValueEnvironment valueEnvironment, Panel ifPanel, Panel elsePanel) {		
		this.expression = expression;
		this.valueEnvironment = valueEnvironment;
				
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
		
		activePanel = new Panel(this);
		activePanel.addComponent(this.ifPanel);
		activePanel.addComponent(this.elsePanel);
		
		activateElsePanel();
	}
	
	public UIConditional(Expression expression, ValueEnvironment valueEnvironment, Panel ifPanel) {
		this(expression, valueEnvironment, ifPanel, new Panel());
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

	@Override
	public void updateComponent() {
		// Recalculate the value for this computedQuestion
		Value value = Evaluator.check(expression, valueEnvironment);
		
		if(value.isUndefined()) {
			activateElsePanel();
			return;
		}
		
		if(((BooleanValue) value).getPrimitive()) {
			activateIfPanel();
		} else {
			activateElsePanel();
		}
		
		activePanel.updateComponent();
	}
	
	@Override
	public JComponent getComponent() {		
		return activePanel.getComponent();
	}
}
 