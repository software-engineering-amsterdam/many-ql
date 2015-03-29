package ql.ast.statement;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.visitor.StatementVisitor;

public class ComputedQuestion extends Question {

	private final Expression expression;

	public ComputedQuestion(Identifier identifier, QLType type,
			StringLiteral text, Expression expression) {
		super(identifier, type, text);
		this.expression = expression;
	}

	public Expression getExpression() {
		return this.expression;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ComputedQuestion(");

		sb.append(getIdentifier().toString() + ", ");
		sb.append(getType().toString() + ", ");
		sb.append(getText().toString() + ", ");
		sb.append(getExpression().toString());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
}