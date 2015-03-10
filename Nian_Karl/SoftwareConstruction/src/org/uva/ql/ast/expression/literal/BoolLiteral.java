package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;
import org.uva.utility.CodePosition;

public class BoolLiteral extends Literal {
	
	private final Boolean value;

	public BoolLiteral(Boolean value,CodePosition pos) {
		super(pos);
		this.value = value;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Boolean getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return new BoolType(getPosition());
	}

}
