package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.BoolValue;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class BoolLiteral extends Literal {

	private final BoolValue value;

	public BoolLiteral(BoolValue value, CodePosition pos) {
		super(pos);
		this.value = value;
	}

	public BoolLiteral(boolean value, CodePosition pos) {
		super(pos);
		this.value = new BoolValue(value);
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BoolValue getValue() {
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BoolLiteral){
			return value.equals(((BoolLiteral) obj).getValue());
			
		} else {
			throw new UnsupportedOperationException("BoolLiteral is only compariable with another BoolLiteral.");
		}
	}

}
