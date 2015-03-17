package uva.sc.qls.widgetTypes;

import uva.sc.core.types.Type;
import uva.sc.core.types.Undefined;
import uva.sc.qls.ast.*;

public class UnidentifiedWidget implements WidgetType {

	Type	type	= new Undefined();

	public Type getType() {
		return type;
	}

	public java.lang.String toString() {
		return "[Type]: undefinedWidget";
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if (type == null) {
			return false;
		}
		if (type instanceof UnidentifiedWidget) {
			return true;
		}
		else {
			return false;
		}
	}
}
