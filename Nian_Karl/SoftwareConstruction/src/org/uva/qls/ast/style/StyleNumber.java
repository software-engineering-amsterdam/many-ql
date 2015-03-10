package org.uva.qls.ast.style;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.Literal;

public abstract class StyleNumber extends Style {

	protected final IntLiteral number;
	
	public StyleNumber(IntLiteral number, CodePosition pos) {
		super(pos);
		this.number = number;
	}

	@Override
	public Literal getLiteral() {
		return number;
	}
	
}
