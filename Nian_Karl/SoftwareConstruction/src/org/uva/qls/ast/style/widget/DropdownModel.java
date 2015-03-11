package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.StrLiteral;

public class DropdownModel extends RadioModel {

	public DropdownModel(StrLiteral first, StrLiteral second, CodePosition position) {
		super(first, second, position);
	}
	
	public DropdownModel(String firstStr, String secondStr, CodePosition pos) {
		super(new StrLiteral(firstStr, pos), new StrLiteral(secondStr, pos), pos);
	}

	@Override
	public String toString() {
		return "dropdown";
	}

}
