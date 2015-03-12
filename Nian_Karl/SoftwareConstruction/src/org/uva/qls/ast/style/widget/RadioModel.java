package org.uva.qls.ast.style.widget;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.ast.literal.StrLiteral;
import org.uva.qls.visitor.StyleVisitor;

public class RadioModel extends WidgetType {

	private final StrLiteral first;
	private final StrLiteral second;

	public RadioModel(StrLiteral first, StrLiteral second, CodePosition position) {
		super(position);
		this.first = first;
		this.second = second;
	}

	public RadioModel(String first, String second, CodePosition position) {
		super(position);
		this.first = new StrLiteral(first, position);
		this.second = new StrLiteral(second, position);
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

	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		// TO-DO EEEH HMM..
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean isValid() {
		if (first.getValue().isDefined() && second.getValue().isDefined()) {
			return true;
		}
		return false;
	}
}
