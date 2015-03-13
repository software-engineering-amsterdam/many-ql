package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class IntLiteral extends Literal{

	private final Integer value;
	
	public IntLiteral(Integer value,CodePosition pos) {
		super(pos);
		this.value = value;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	@Override
	public Type getType(TypeChecker typeChecker) {
		return new IntType(getPosition());
	}
	
}
