package org.uva.qls.ast.widget;

import java.util.ArrayList;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.utility.CodePosition;

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

}
