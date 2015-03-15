package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.visitor.AstVisitor;

public abstract class AstNode {

	private TextLocation textLocation;

	public AstNode(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

	public abstract <T> T accept(AstVisitor<T> visitor);
}
