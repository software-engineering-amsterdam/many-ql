package org.uva.ql.ast.statement;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.type.Type;
import org.uva.ql.visitor.StatementVisitor;

public class QuestionComputed extends QuestionNormal {

	private final Expression expression;

	public QuestionComputed(Identifier identifier, StrLiteral label, Type type, Expression expr, CodePosition pos) {
		super(identifier, label, type, pos);
		this.expression = expr;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return getIdentifier().toString();
	}

}
