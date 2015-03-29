package org.uva.ql.view.listener;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.FormFrame;

public class WidgetListener {

	private Evaluator evaluator;
	private FormFrame form;

	public WidgetListener(FormFrame form) {
		this.evaluator = new Evaluator();
		this.form = form;
	}

	public void initializeValue(Identifier identifier, Value value) {
		evaluator.addValue(identifier, value);
	}

	public void widgetValueChanged(Identifier identifier, Value value) {
		evaluator.addValue(identifier, value);
		if (value.isDefined()) {
			form.notifyPanels(evaluator, identifier);
		}
	};

	public Evaluator getEvaluator() {
		return evaluator;
	}
}
