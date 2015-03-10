package org.uva.qls.ast.widget;

import java.util.ArrayList;

import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.utility.CodePosition;

public class Spinbox extends WidgetType {

	private final ArrayList<IntLiteral> values;
	
	public Spinbox(ArrayList<IntLiteral> values, CodePosition position) {
		super(position);
		this.values = values;
	}
	
	public ArrayList<IntLiteral> getValues() {
		return values;
	}
	
	@Override
	public String toString() {
		return "spinbix";
	}

}
