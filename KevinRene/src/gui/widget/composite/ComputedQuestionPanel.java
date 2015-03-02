package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;
import gui.widget.InputWidget;

import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.Expression;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.visitor.evaluator.Evaluator;
import cons.value.UndefinedValue;

@SuppressWarnings("rawtypes")
public class ComputedQuestionPanel extends Composite {
	private JPanel questionPanel;
	private Expression expression;
	private ValueEnvironment valueEnvironment;
	
	private Widget questionText;
	private InputWidget inputWidget;
	
	public ComputedQuestionPanel(Identifier identifier, Widget questionText, 
			Widget inputWidget, Expression expression, ValueEnvironment valueEnvironment) {
		super(identifier);
		
		this.expression = expression;
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		
		this.questionText = questionText;
		this.questionText.addObserver(this);
		
		questionPanel.add(this.questionText.getComponent());
		
		this.valueEnvironment = valueEnvironment;
		
		this.inputWidget = (InputWidget) inputWidget;		
		this.inputWidget.addObserver(this);
		this.inputWidget.disable();
		//this.inputWidget.setValue(Evaluator.check(expression, this.valueEnvironment));
		questionPanel.add(this.inputWidget.getComponent());
	}

	public Expression getExpression() {
		return expression;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent getComponent() {
		Value expressionValue = Evaluator.check(expression, this.valueEnvironment);

		if(expressionValue instanceof UndefinedValue) {
			return questionPanel;
		}

		inputWidget.setValue(expressionValue);
		
		return questionPanel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Changed the comp question");
		valueEnvironment.store(getIdentifier(), (Value) arg);
		
		setChanged();		
		notifyObservers();
	}
}
