package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class IntLiteral extends Literal {

	private final IntValue value;

	public IntLiteral(IntValue value, CodePosition pos) {
		super(pos);
		this.value = value;
	}
	
	public IntLiteral(int value, CodePosition pos) {
		super(pos);
		this.value = new IntValue(value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Value getValue() {
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IntLiteral){
			return value.equals(((IntLiteral) obj).getValue());
			
		} else {
			throw new UnsupportedOperationException("IntLiteral is only compariable with another IntLiteral.");
		}
	}
	
}
