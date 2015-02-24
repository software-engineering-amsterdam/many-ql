package org.uva.ql.ast.statement;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.type.QuestionType;
import org.uva.ql.ast.visitor.Visitor;

public class QuestionCompute extends QuestionNormal {

	private Expression expression;

	public QuestionCompute(QuestionType questionType, String identifier, String questionLabel, Expression expr) {
		super(questionType, identifier, questionLabel);
		expression = expr;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
