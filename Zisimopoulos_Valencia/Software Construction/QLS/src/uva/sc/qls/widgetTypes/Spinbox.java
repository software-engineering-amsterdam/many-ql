package uva.sc.qls.widgetTypes;

import uva.sc.core.types.Number;
import uva.sc.core.types.Type;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class Spinbox implements WidgetType {

	Type	type	= new Number();

	public Type getType() {
		return type;
	}

	public java.lang.String toString() {
		return "[WidgetType]: spinbox";
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if (type == null) {
			return false;
		}
		if (type instanceof Spinbox) {
			return true;
		}
		else {
			return false;
		}
	}

}
