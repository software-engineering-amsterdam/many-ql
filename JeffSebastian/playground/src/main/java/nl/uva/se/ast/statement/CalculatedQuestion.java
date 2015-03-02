package nl.uva.se.ast.statement;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.constant.Type;
import nl.uva.se.visitor.Visitor;

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
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
