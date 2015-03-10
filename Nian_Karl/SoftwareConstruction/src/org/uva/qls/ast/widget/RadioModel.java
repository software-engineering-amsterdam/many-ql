package org.uva.qls.ast.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.StrLiteral;

public class RadioModel extends WidgetType {

	private final StrLiteral first;
	private final StrLiteral second;
	
	public RadioModel(StrLiteral first, StrLiteral second, CodePosition position) {
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
