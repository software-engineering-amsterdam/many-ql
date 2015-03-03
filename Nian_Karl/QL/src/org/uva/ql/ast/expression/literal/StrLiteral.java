package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class StrLiteral extends Literal {

	private final String value;

	public StrLiteral(String value, CodePosition pos) {
		super(pos);
		this.value = value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("\"%s\"", value);
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return new StrType();
	}

}
