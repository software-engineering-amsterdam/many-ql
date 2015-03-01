package org.uva.ql.view;

import java.util.ArrayList;

import org.uva.ql.ast.expression.Expression;

public class DependentQuestionPanel extends QLQuestionPanel {

	private static final long serialVersionUID = -4507161988032536469L;

	private Expression expr;

	public DependentQuestionPanel(ArrayList<QLPanel> questionPanels, Expression expr) {
		super(questionPanels);
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}
}