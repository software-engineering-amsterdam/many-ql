package org.uva.qls.ast.widget;

import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.utility.CodePosition;

public class Dropdown extends Radio {

	public Dropdown(StrLiteral first, StrLiteral second, CodePosition position) {
		super(first, second, position);
	}
	
	@Override
	public String toString() {
		return "dropdown";
	}

}
