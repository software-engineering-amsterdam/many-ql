package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ast.expression.Identifier;
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.DefaultComponent;
import ql.gui.Component;
import ql.gui.structure.Panel;

public class UIQuestion extends DefaultComponent {
	private final Identifier identifier;
	private final Panel questionPanel;
	private final ValueEnvironment valueEnvironment;
	private final Component questionText, questionWidget;
	
	public UIQuestion(Identifier identifier, Component questionText, Component widget, ValueEnvironment valueEnvironment) {
		this.identifier = identifier;
		this.questionText = questionText;
		this.questionWidget = widget;
		
		questionPanel = new Panel(this);
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.questionWidget);
		
		this.valueEnvironment = valueEnvironment;
	}
	
	@Override
	public void handleChange(Value changedValue, Component source) {		
		valueEnvironment.store(identifier, changedValue);
		
		super.handleChange(changedValue, this);
	}
	
	@Override
	public void updateComponent() {		
		questionPanel.updateComponent();
	}
	
	@Override
	public JComponent getComponent() {		
		return questionPanel.getComponent();
	}
}
