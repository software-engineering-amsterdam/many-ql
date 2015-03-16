package org.uva.sea.qls.encoders.ast;

// Duplication?

public abstract class AstNode {

	private TextLocation textLocation;

	public AstNode(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

}
