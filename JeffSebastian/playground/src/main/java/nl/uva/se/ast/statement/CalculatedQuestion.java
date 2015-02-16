package nl.uva.se.ast.statement;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.constant.Type;

public class CalculatedQuestion extends Question {

	private final Expression expression;

	public CalculatedQuestion(String id, Type type, String question,
			Expression expression) {
		super(id, type, question);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
