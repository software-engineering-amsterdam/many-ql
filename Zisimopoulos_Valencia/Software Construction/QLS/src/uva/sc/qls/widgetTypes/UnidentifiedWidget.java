package uva.sc.qls.widgetTypes;

import uva.sc.qls.ast.*;

public class UnidentifiedWidget implements WidgetType {

	public java.lang.String toString() {
		return "[Type]: undefinedWidget";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if(type == null) {
			return false;
		}
		if(type instanceof UnidentifiedWidget) {
			return true;
		}
		else {
			return false;
		}
	}
}
