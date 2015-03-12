package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

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
	
	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		// TO-DO EEEH HMM..
		return null;
	}

}
