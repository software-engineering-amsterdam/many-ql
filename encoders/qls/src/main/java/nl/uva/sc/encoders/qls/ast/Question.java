package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.ast.widget.Widget;
import nl.uva.sc.encoders.qls.visitor.AstVisitor;

public class Question extends AstNode {

	private String name;

	private Widget widget;

	public Question(TextLocation textLocation, String name, Widget widget) {
		super(textLocation);
		this.name = name;
		this.widget = widget;
	}

	public String getName() {
		return name;
	}

	public Widget getWidget() {
		return widget;
	}

	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return name;
	}
}
