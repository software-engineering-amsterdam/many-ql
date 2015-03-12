package org.uva.qls.ast.style;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitable;

public abstract class StyleProperty extends BaseNode implements StyleVisitable{
	
	public StyleProperty(CodePosition pos) {
		super(pos);
	}
	
	public abstract Literal getLiteral();
	public abstract String toString();
	public abstract <T> T isValid();
}
