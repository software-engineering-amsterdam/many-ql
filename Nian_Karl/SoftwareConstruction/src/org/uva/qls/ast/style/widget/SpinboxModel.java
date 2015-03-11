package org.uva.qls.ast.style.widget;

import java.util.ArrayList;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class SpinboxModel extends WidgetType {

	private final ArrayList<IntLiteral> values;
	
	public SpinboxModel(ArrayList<IntLiteral> values, CodePosition position) {
		super(position);
		this.values = values;
	}
	
	public ArrayList<IntLiteral> getValues() {
		return values;
	}
	
	@Override
	public String toString() {
		return "spinbox";
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
