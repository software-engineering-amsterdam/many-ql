package org.uva.ql.view.panel;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.value.BoolValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class IfQuestionPanel extends QuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private Expression expr;

	public IfQuestionPanel(ArrayList<Panel> ifBlockPanels, Expression expr) {
		super(ifBlockPanels);
		this.expr = expr;
		toggleIfBlock(false);
	}

	public Expression getExpr() {
		return expr;
	}

	public void evaluateAndShow(Evaluator evaluator) {
		if (evaluateExpressions(evaluator).getType().isEqual(new BoolType())) {
			BoolValue value = (BoolValue) evaluateExpressions(evaluator);
			if (value.getValue()) {
				toggleIfBlock(true);
			} else {
				toggleIfBlock(false);
			}
		} else {
			toggleIfBlock(false);
		}
	}

	public Value evaluateExpressions(Evaluator evaluator) {
		return evaluator.evaluate(expr);
	}

	public void toggleIfBlock(boolean show) {
		for (Panel panel : this.ifBlockPanels) {
			panel.setVisible(show);
		}
	}
}