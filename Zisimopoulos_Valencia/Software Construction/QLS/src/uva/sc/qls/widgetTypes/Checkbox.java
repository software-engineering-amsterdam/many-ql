package uva.sc.qls.widgetTypes;

import uva.sc.core.types.Boolean;
import uva.sc.core.types.Type;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class Checkbox implements WidgetType {

	Type	type	= new Boolean();

	public Type getType() {
		return type;
	}

	public java.lang.String toString() {
		return "[WidgetType]: checkbox";
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if (type == null) {
			return false;
		}
		if (type instanceof Checkbox) {
			return true;
		}
		else {
			return false;
		}
	}

}
