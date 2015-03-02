package org.uva.ql.view;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;

public class DependentQuestionPanel extends QuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private Expression expr;

	public DependentQuestionPanel(ArrayList<Panel> questionPanels, Expression expr) {
		super(questionPanels);
		this.expr = expr;
		for (Panel panel : questionPanels) {
			panel.setVisible(false);
		}
	}

	public Expression getExpr() {
		return expr;
	}
}