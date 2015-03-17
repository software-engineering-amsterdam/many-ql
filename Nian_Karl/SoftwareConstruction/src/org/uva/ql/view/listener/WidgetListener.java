package org.uva.ql.view.listener;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.view.FormFrame;

public class WidgetListener {

	private Evaluator evaluator;
	private FormFrame form;
	private TypeChecker checker;

	public WidgetListener(FormFrame form) {
		this.evaluator = new Evaluator();
		this.checker = new TypeChecker();
		this.form = form;
	}

	public void initializeValue(Identifier identifier, Value value) {
		evaluator.addValue(identifier, value);
	}

	public void widgetValueChanged(Identifier identifier, Value value) {
		evaluator.addValue(identifier, value);
		form.notifyPanels(evaluator, checker);
	};

	public Evaluator getEvaluator() {
		return evaluator;
	}
}
