package org.uva.qls.ast.sheet;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.ast.style.widget.WidgetType;
import org.uva.qls.visitor.SheetVisitor;

public class QuestionWidget extends Question {

	private final WidgetType widget;

	public QuestionWidget(IdentifierLiteral identifier, WidgetType widget, CodePosition pos) {
		super(identifier, pos);
		this.widget = widget;
	}

	public WidgetType getWidget() {
		return widget;
	}
	
	@Override
	public <T> T accept(SheetVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
