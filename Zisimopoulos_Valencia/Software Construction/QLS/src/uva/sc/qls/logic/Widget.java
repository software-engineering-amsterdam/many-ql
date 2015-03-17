package uva.sc.qls.logic;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.widgetTypes.WidgetType;

public class Widget implements IQLSNode {

	WidgetType	widgetType;
	String		argument1;
	String		argument2;

	public Widget(WidgetType widgetType) {
		this.widgetType = widgetType;
	}

	public Widget(WidgetType widgetType, String argument1, String argument2) {
		this.widgetType = widgetType;
		this.argument1 = argument1;
		this.argument2 = argument2;
	}

	public WidgetType getWidgetType() {
		return widgetType;
	}

	public String getArgument1() {
		return argument1;
	}

	public String getArgument2() {
		return argument2;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[Widget]:\n\t" + widgetType.toString() + "(" + argument1 + "," + argument2 + ")";
		return result;
	}

}
