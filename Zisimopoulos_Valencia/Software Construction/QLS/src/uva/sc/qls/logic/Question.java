package uva.sc.qls.logic;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;
import uva.sc.qls.atom.ID;

public class Question implements INode{

	ID id;
	Widget widget;
	
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

	public <T> T accept(INodeVisitor<T> visitor) {
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
