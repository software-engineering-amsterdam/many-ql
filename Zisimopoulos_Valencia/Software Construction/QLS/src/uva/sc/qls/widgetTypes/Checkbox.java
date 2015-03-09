package uva.sc.qls.widgetTypes;

import uva.sc.qls.ast.INodeVisitor;

public class Checkbox implements WidgetType{

	public java.lang.String toString() {
		return "[WidgetType]: checkbox";
	}
	
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public boolean equals(WidgetType type) {
		if(type == null) {
			return false;
		}
		if(type instanceof Checkbox) {
			return true;
		}
		else {
			return false;
		}
	}

}
