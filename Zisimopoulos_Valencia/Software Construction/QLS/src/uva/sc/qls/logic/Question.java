package uva.sc.qls.logic;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class Question implements IQLSNode {

	ID		id;
	Widget	widget;

	public Question(ID id, Widget widget) {
		this.id = id;
		this.widget = widget;
	}

	public ID getId() {
		return id;
	}

	public Widget getWidget() {
		return widget;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[Question]:\n\t" + id.toString();
		if (widget != null) {
			result += widget.toString();
		}
		return result;
	}
}
