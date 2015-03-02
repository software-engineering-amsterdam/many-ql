package gui.widget.composite;

import java.util.Observable;
import java.util.Observer;

import gui.Widget;
import gui.observer.QuestionObserver;
import gui.widget.Composite;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.Value;
import cons.ql.ast.expression.Identifier;

@SuppressWarnings("rawtypes")
public class QuestionComposite extends Composite implements Observer {
	private JPanel questionPanel;

	public QuestionComposite(Identifier identifier, Widget questionText, Widget widget) {
		super(identifier);
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		questionText.addObserver(new QuestionObserver());
		questionPanel.add(questionText.getComponent());
		
		widget.addObserver(this);
		questionPanel.add(widget.getComponent());
	}
	
	@Override
	public JComponent getComponent() {
		return questionPanel;
	}

	@Override
	public Value getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setValue(Value value) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Something changed in the question " + getIdentifier());
		notifyObservers();
	}
}
