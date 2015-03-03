package org.uva.ql.view;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.view.widgit.Widget;

public class DependentQuestionComponent extends QuestionComponent {

	private final Expression expr;
	private static final long serialVersionUID = 134684077598012568L;

	public DependentQuestionComponent(QuestionCompute question, Widget widget) {
		super(question, widget);
		this.expr = question.getExpression();
	}

	public Expression getExpr() {
		return expr;
	}
	
	
}
