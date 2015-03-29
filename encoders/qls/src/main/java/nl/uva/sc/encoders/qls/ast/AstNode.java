package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public abstract class AstNode {

	private TextLocation textLocation;

	public AstNode(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

}
