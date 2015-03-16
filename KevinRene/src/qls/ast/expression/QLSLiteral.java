package qls.ast.expression;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import qls.QLSValue;
import qls.ast.visitor.QLSVisitor;

public abstract class QLSLiteral<T extends QLSValue> extends Literal<T> {
	public QLSLiteral(T value) {
		super(value);
	}

	@Override
	public QLType getType() {
		return null;
	}
	
	@Override
	public <U> U accept(ExpressionVisitor<U> visitor) {
		throw new UnsupportedOperationException();
	}
	
	public abstract <U> U accept(QLSVisitor<U> visitor);
}
