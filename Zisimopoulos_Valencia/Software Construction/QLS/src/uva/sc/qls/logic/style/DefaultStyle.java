package uva.sc.qls.logic.style;

import java.util.ArrayList;
import java.util.List;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.logic.Widget;
import uva.sc.core.types.Type;

public class DefaultStyle implements IQLSNode {

	Type				type;
	List<StyleProperty>	stylePropertyList	= new ArrayList<StyleProperty>();
	Widget				widget;

	public DefaultStyle(Type type, List<StyleProperty> stylePropertyList, Widget widget) {
		this.type = type;
		this.stylePropertyList = stylePropertyList;
		this.widget = widget;
	}

	public Type getType() {
		return type;
	}

	public List<StyleProperty> getStyleProperty() {
		return stylePropertyList;
	}

	public Widget getWidget() {
		return widget;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[DefaultStyle]:\n" + type.toString() + "\n";
		for (StyleProperty styleProperty : stylePropertyList) {
			result += styleProperty.toString() + "\n";
		}
		result += widget.toString();
		return result;
	}

}
