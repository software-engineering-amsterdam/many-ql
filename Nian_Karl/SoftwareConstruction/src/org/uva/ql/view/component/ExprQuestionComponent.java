package org.uva.ql.view.component;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.view.widgit.Widget;

public class ExprQuestionComponent extends QuestionComponent {

	private final Expression expr;
	private static final long serialVersionUID = 134684077598012568L;

	public ExprQuestionComponent(QuestionCompute question, Widget widget) {
		super(question, widget);
		this.expr = question.getExpression();
		widget.getWidget().setEnabled(false);
	}

	public Expression getExpr() {
		return expr;
	}

	public void evaluateAndChange(Evaluator evaluator) {
		widget.setWidgetValue(evaluator.evaluate(expr));
	}
}
