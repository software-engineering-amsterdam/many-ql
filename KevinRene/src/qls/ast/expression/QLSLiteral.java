package qls.ast.expression;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import qls.QLSValue;
import qls.ast.visitor.QLSVisitor;

public abstract class QLSLiteral<U extends QLSValue> extends Literal<U> {
	public QLSLiteral(U value) {
		super(value);
	}

	@Override
	public QLType getType() {
		return null;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		throw new UnsupportedOperationException();
	}
	
	public abstract <T> T accept(QLSVisitor<T> visitor);
}
