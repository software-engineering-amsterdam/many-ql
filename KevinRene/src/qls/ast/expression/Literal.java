package qls.ast.expression;

import ql.ast.QLType;
import ql.Value;
import qls.ast.visitor.ExpressionVisitor;

public abstract class Literal<U extends Value> extends ql.ast.expression.Literal<U> {
	public Literal(U value) {
		super(value);
	}

	@Override
	public abstract QLType getType();
	
	@Override
	public <T> T accept(ql.ast.visitor.ExpressionVisitor<T> visitor) {
		throw new UnsupportedOperationException();
	}
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
}
