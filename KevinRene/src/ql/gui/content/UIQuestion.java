package ql.gui.content;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.expression.Identifier;
import ql.gui.UIComponent;
import ql.gui.structure.Panel;

public class UIQuestion implements UIComponent {
	private final Identifier identifier;
	private final Panel questionPanel;
	private final ValueEnvironment valueEnvironment;
	private final UIComponent questionText, questionWidget;
	
	private UIComponent handler;

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
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}

	@Override
	public void handleChange(Value changedValue, UIComponent source) {		
		valueEnvironment.store(identifier, changedValue);
		
		handler.handleChange(changedValue, this);
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
