package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.expression.Identifier;
import ql.gui.DefaultChangeHandler;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public class UIQuestion extends DefaultChangeHandler implements UIComponent {
	private final Identifier identifier;
	private final Panel questionPanel;
	private final ValueEnvironment valueEnvironment;
	private final UIComponent questionText, questionWidget;
	
	public UIQuestion(Identifier identifier, UIComponent questionText, UIComponent widget, ValueEnvironment valueEnvironment) {
		this.identifier = identifier;
		this.questionText = questionText;
		this.questionWidget = widget;
		
		questionPanel = new Panel(this);
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.questionWidget);
		
		this.valueEnvironment = valueEnvironment;
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {		
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
