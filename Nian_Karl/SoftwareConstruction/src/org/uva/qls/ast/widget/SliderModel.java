package org.uva.qls.ast.widget;

import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.utility.CodePosition;

public class SliderModel extends WidgetType {

	private final IntLiteral min;
	private final IntLiteral max;
	
	public SliderModel(IntLiteral min, IntLiteral max, CodePosition position) {
		super(position);
		this.min = min;
		this.max = max;
	}
	
	public IntLiteral getMin() {
		return min;
	}
	
	public IntLiteral getMax() {
		return max;
	}
	
	@Override
	public String toString() {
		return "slider";
	}

}
