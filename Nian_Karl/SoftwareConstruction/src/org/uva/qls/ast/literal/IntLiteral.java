package org.uva.qls.ast.literal;

import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.IntValue;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitor;
import org.uva.utility.CodePosition;

public class IntLiteral extends Literal {

	private final IntValue value; 
	
	public IntLiteral(IntValue value, CodePosition position) {
		super(position);
		this.value = value;
	}
	
	@Override
	public Value getValue() {
		return value;
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}



}
