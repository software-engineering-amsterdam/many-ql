package org.uva.ql.ast.expression.literal;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.StrValue;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitor;

public class StrLiteral extends Literal {

	private final StrValue value;

	public StrLiteral(StrValue value, CodePosition pos) {
		super(pos);
		this.value = value;
	}
	
	public StrLiteral(String value, CodePosition pos) {
		super(pos);
		this.value = new StrValue(value);
	}	

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public StrValue getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Type getType(TypeChecker typeChecker) {
		return new StrType(getPosition());
	}
	
	public boolean equals(StrLiteral strLiteral) {
		return value.equals(strLiteral.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof StrLiteral){
			return value.equals(((StrLiteral) obj).getValue());
			
		} else {
			throw new UnsupportedOperationException("StrLiteral is only compariable with another StrLiteral.");
		}
	}
	
}
