package gui.content;

import gui.UIComponent;
import gui.structure.Section;

import javax.swing.JComponent;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.expression.Identifier;

public class UIQuestion extends UIComponent {
	private final Identifier identifier;
	private final Section questionPanel;
	private final ValueEnvironment valueEnvironment;
	private final UIComponent questionText, questionWidget;

	public UIQuestion(Identifier identifier, UIComponent questionText, UIComponent widget, ValueEnvironment valueEnvironment) {
		this.identifier = identifier;
		this.questionText = questionText;
		this.questionWidget = widget;
		
		questionPanel = new Section(this);
		questionPanel.addComponent(this.questionText);
		questionPanel.addComponent(this.questionWidget);
		
		this.valueEnvironment = valueEnvironment;
	}
	
	@SuppressWarnings("rawtypes")
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
