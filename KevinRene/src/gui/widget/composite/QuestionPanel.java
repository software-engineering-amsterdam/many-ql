package gui.widget.composite;

import gui.Widget;
import gui.observer.QuestionObserver;
import gui.widget.Composite;

import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;

public class QuestionPanel extends Composite {
	private JPanel questionPanel;
	private ValueEnvironment valueEnvironment;
	private final Widget questionText, questionWidget;

	public QuestionPanel(Identifier identifier, Widget questionText, Widget widget, ValueEnvironment valueEnvironment) {
		super(identifier);
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		this.questionText = questionText;
		this.questionText.addObserver(new QuestionObserver());
		questionPanel.add(this.questionText.getComponent());
		
		this.questionWidget = widget;
		this.questionWidget.addObserver(this);
		questionPanel.add(this.questionWidget.getComponent());
		
		this.valueEnvironment = valueEnvironment;
	}
	
	@Override
	public JComponent getComponent() {
		questionPanel.removeAll();
		
		questionPanel.add(questionText.getComponent());
		questionPanel.add(questionWidget.getComponent());
		
		questionPanel.repaint();
		
		return questionPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Question answer changed.");
		
		valueEnvironment.store(getIdentifier(), (Value) arg);
		
		setChanged();		
		notifyObservers();
	}
}
