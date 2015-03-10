package gui.content;

import gui.Composite;
import gui.Widget;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.expression.Identifier;

public class UIQuestion extends Composite {
	private JPanel questionPanel;
	private ValueEnvironment valueEnvironment;
	private final Widget questionText, questionWidget;

	public UIQuestion(Identifier identifier, Widget questionText, Widget widget, ValueEnvironment valueEnvironment) {
		super(identifier);
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		this.questionText = questionText;
		this.questionText.setHandler(this);
		questionPanel.add(this.questionText.getComponent());
		
		this.questionWidget = widget;
		this.questionWidget.setHandler(this);
		questionPanel.add(this.questionWidget.getComponent());
		
		this.valueEnvironment = valueEnvironment;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue, Widget source) {		
		valueEnvironment.store(getIdentifier(), changedValue);
		super.handleChange(changedValue, this);
	}
	
	@Override
	public void updateComponent() {
		questionText.updateComponent();
		questionWidget.updateComponent();
		
		questionPanel.revalidate();
		questionPanel.repaint();
	}
	
	@Override
	public JComponent getComponent() {		
		return questionPanel;
	}
}
