package uva.sc.qls.widgetTypes;

import uva.sc.qls.ast.INodeVisitor;

public class Spinbox implements WidgetType{

	public java.lang.String toString() {
		return "[WidgetType]: spinbox";
	}
	
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Spinbox) {
			return true;
		}
		else {
			return false;
		}
	}

}
