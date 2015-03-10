package org.uva.qls.ast.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.StrLiteral;

public class DropdownModel extends RadioModel {

	public DropdownModel(StrLiteral first, StrLiteral second, CodePosition position) {
		super(first, second, position);
	}
	
	@Override
	public String toString() {
		return "dropdown";
	}

}
