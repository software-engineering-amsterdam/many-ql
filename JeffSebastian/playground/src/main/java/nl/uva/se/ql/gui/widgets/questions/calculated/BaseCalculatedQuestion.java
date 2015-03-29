package nl.uva.se.ql.gui.widgets.questions.calculated;

import javafx.scene.Node;
import javafx.scene.control.Label;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.widgets.questions.BaseQuestion;

public abstract class BaseCalculatedQuestion<T> extends BaseQuestion<T> {

	protected Label label = new Label();
	protected T value;
	
	public abstract void setValue(Value value);

	public BaseCalculatedQuestion(Question question, Mediator mediator) {
		super(question, mediator);
		register(question);
	}

	private void register(Question question) {
		getMediator().registerCalculated(question.getId(), this);
	}

	@Override
	public T undoChange(T newValue, T oldValue) {
		return value;
	}

	public String createText(String value) {
		return getQuestion().getLabel() + " " + value;
	}

	@Override
	public Node getWidget() {
		return this.label;
	}
}
