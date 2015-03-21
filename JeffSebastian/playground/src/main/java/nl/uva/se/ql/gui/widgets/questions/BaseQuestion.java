package nl.uva.se.ql.gui.widgets.questions;

import javafx.scene.Node;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.evaluation.value.Value;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.validators.Validator;

public abstract class BaseQuestion<T> {
	private final Question question;
	private final Validator<T> validator;
	private final Mediator mediator;

	public BaseQuestion(Question question, Mediator mediator) {
		this.question = question;
		this.validator = initValidator();
		this.mediator = mediator;
	}
	
	public abstract Validator<T> initValidator();

	public Mediator getMediator() {
		return mediator;
	}

	public Question getQuestion() {
		return question;
	}

	public Validator<T> getValidator() {
		return validator;
	}

	public abstract T undoChange(T newValue, T oldValue);

	public abstract Value getValue();	
	
	public abstract Node getWidget();
	
}
