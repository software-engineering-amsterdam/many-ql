package org.uva.ql.view.listener;

import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.view.FormFrame;

public class WidgetListener {

	private Evaluator evaluator;
	private TypeChecker checker;

	public WidgetListener() {
		this.evaluator = new Evaluator();
		this.checker = new TypeChecker();
	}

	public void initializeValue(String identifier, Value value) {
		evaluator.addValue(identifier, value);
	}

	public void widgetValueChanged(String identifier, Value value) {
		evaluator.addValue(identifier, value);
	};

	public Evaluator getEvaluator() {
		return evaluator;
	}

}
