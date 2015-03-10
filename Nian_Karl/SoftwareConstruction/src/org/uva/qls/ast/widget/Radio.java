package org.uva.qls.ast.widget;

import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.utility.CodePosition;

public class Radio extends WidgetType {

	private final StrLiteral first;
	private final StrLiteral second;
	
	public Radio(StrLiteral first, StrLiteral second, CodePosition position) {
		super(position);
		this.first = first;
		this.second = second;
	}
	
	public StrLiteral getFirst() {
		return first;
	}
	
	public StrLiteral getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "radio";
	}
}
