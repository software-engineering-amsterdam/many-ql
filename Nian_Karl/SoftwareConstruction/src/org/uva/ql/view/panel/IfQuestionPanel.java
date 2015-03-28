package org.uva.ql.view.panel;

import java.util.List;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class IfQuestionPanel extends QuestionPanel {

	private Expression expr;

	public IfQuestionPanel(List<Panel> questionPanels, Expression expr) {
		super(questionPanels);
		this.expr = expr;
		toggleIfBlock(false);
	}

	public void evaluateAndShow(Evaluator evaluator) {
		Value value = evaluator.evaluate(expr);
		if (value.isDefined()) {
			if ((boolean) value.value()) {
				toggleIfBlock(true);
			} else {
				toggleIfBlock(false);
			}
		} else {
			toggleIfBlock(false);
		}
	}

	public void toggleIfBlock(boolean show) {
		for (Panel panel : this.ifBlockPanels) {
			(panel).setVisible(show);
		}
	}
}