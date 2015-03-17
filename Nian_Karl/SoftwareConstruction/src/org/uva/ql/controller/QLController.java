package org.uva.ql.controller;

import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.view.FormFrame;

public class QLController {

	private final Questionnaire questionnaire;
	private final FormFrame formView;
	private final Evaluator evaluator;
	private final TypeChecker typeChecker;

	public QLController(Questionnaire questionnaire, FormFrame formView) {
		super();
		this.questionnaire = questionnaire;
		this.formView = formView;
		evaluator = new Evaluator();
		typeChecker = new TypeChecker();
	}

	public void notifyEvaluator(String identifier, Value value) {
		getEvaluator().addValue(identifier, value);
		formView.notifyPanels(getEvaluator(), typeChecker);
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}
	
	
}
