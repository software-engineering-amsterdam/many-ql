package uva.sc.qls.widgetTypes;

import uva.sc.core.types.Boolean;
import uva.sc.core.types.Type;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class Radio implements WidgetType {

	Type	type	= new Boolean();

	public Type getType() {
		return type;
	}

	public java.lang.String toString() {
		return "[WidgetType]: radio";
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if (type == null) {
			return false;
		}
		if (type instanceof Radio) {
			return true;
		}
		else {
			return false;
		}
	}

}
