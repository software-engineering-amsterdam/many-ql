package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ql.Value;
import ql.ValueEnvironment;
import ql.ast.expression.Identifier;

public class QuestionPanel extends Composite {
	private JPanel questionPanel;
	private ValueEnvironment valueEnvironment;
	private final Widget questionText, questionWidget;

	public QuestionPanel(Identifier identifier, Widget questionText, Widget widget, ValueEnvironment valueEnvironment) {
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
	public void handleChange(Value changedValue) {		
		valueEnvironment.store(getIdentifier(), changedValue);
		super.handleChange(changedValue);
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
