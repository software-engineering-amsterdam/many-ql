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
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;

@SuppressWarnings("rawtypes")
public class ComputedQuestionComposite extends Composite implements Observer {
	private JPanel questionPanel;
	private Expression expression;
	
	private Widget questionText;

	public ComputedQuestionComposite(Identifier identifier, Widget questionText, Widget widget, Expression expression) {
		super(identifier);
		
		this.expression = expression;
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		this.questionText = questionText;
		this.questionText.addObserver(new QuestionObserver());
		questionPanel.add(this.questionText.getComponent());
		
		widget.addObserver(this);
		questionPanel.add(widget.getComponent());
	}

	public Expression getExpression() {
		return expression;
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
		// TODO Auto-generated method stub		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(this.questionText);
	}
}
