package nl.uva.sc.encoders.qls.ast;

// Duplication?

public class AstNodeWithLocation implements AstNode {

	private TextLocation textLocation;

	public AstNodeWithLocation(TextLocation textLocation) {
		this.textLocation = textLocation;
	}

	public TextLocation getTextLocation() {
		return textLocation;
	}

}
