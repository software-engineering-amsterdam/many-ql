package org.uva.sea.ql.encoders.ast;

public abstract class AstNodeWithLocation implements AstNode {

	private TextLocation textLocation;

	public AstNodeWithLocation(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

}
