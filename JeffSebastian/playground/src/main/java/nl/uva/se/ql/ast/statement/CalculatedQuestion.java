package nl.uva.se.ql.ast.statement;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.type.Type;

public class CalculatedQuestion extends Question {

	private final Expression expression;

	public CalculatedQuestion(int lineNumber, int offset, String id, Type type,
			String question, Expression expression) {
		super(lineNumber, offset, id, type, question);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}
	
}
