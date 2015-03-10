package gui.content;

import gui.UIComponent;
import gui.structure.Panel;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.Expression;
import ql.ast.visitor.evaluator.Evaluator;
import ql.value.BooleanValue;

public class UIConditional extends UIComponent {
	private Panel activePanel;
	private final Expression expression;
	private final ValueEnvironment valueEnvironment;
	private final UIComponent ifPanel, elsePanel;
	
	public UIConditional(Expression expression, ValueEnvironment valueEnvironment, Panel ifPanel, Panel elsePanel) {		
		this.expression = expression;
		this.valueEnvironment = valueEnvironment;
		
		this.activePanel = new Panel(this);
		
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
		
		activePanel.addComponent(this.ifPanel);
		activePanel.addComponent(this.elsePanel);
		
		activateElsePanel();
	}
	
	public UIConditional(Expression expression, ValueEnvironment valueEnvironment, Panel ifComponent) {
		this(expression, valueEnvironment, ifComponent, new Panel());
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
		
		activePanel.updateComponent();
	}
	
	@Override
	public JComponent getComponent() {		
		return activePanel.getComponent();
	}
}
 