package org.uva.qls.ast.style;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.Literal;

public abstract class StyleNumber extends StyleProperty {

	protected final IntLiteral number;
	
	public StyleNumber(IntLiteral number, CodePosition pos) {
		super(pos);
		this.number = number;
	}

	public StyleNumber(int number, CodePosition pos) {
		super(pos);
		this.number = new IntLiteral(number, pos);
	}
	
	
	@Override
	public Literal getLiteral() {
		return number;
	}
	
}
