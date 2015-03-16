package org.uva.ql.view.panel;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;

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

	public void evaluateAndShow(Evaluator evaluator, TypeChecker typeChecker) {
		Value value = evaluator.evaluate(expr);
		Type type = expr.getType(typeChecker);
		if (type.isEqual(new BoolType()) && value.isDefined()) {
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
			panel.setVisible(show);
		}
	}
}