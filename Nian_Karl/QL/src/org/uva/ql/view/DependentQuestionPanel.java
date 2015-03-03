package org.uva.ql.view;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.value.Bool;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;

public class DependentQuestionPanel extends QuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private Expression expr;
	private ArrayList<Panel> questionPanels;

	public DependentQuestionPanel(ArrayList<Panel> questionPanels, Expression expr) {
		super(questionPanels);
		this.questionPanels = questionPanels;
		this.expr = expr;
		for (Panel panel : this.questionPanels) {
			panel.setVisible(false);
		}
	}

	public Expression getExpr() {
		return expr;
	}

	public void evaluateAndShow(Evaluator evaluator) {
		// dirty
		System.out.println("Yo");
		System.out.println(evaluateExpressions(evaluator));
		if (evaluateExpressions(evaluator) instanceof Bool) {
			Bool value = (Bool) evaluateExpressions(evaluator);
			if (value.getValue()) {
				showQuestions(true);
			} else {
				showQuestions(false);
			}
		}
	}

	public Value evaluateExpressions(Evaluator evaluator) {
		return evaluator.evaluate(expr);
	}

	public void showQuestions(boolean show) {
		for (Panel panel : questionPanels) {
			panel.setVisible(show);
		}
	}
}