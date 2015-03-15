package org.uva.sea.ql.encoders.ast;

public class TextLocationBuilder {

	private int line;
	private int charPositionInLine;

	public static TextLocationBuilder aTextLocation() {
		TextLocationBuilder builder = new TextLocationBuilder();
		builder.line = 10;
		builder.charPositionInLine = 10;
		return builder;
	}

	public TextLocation build() {
		return new TextLocation(line, charPositionInLine);
	}

	public TextLocationBuilder withLine(int line) {
		this.line = line;
		return this;
	}

	public TextLocationBuilder withCharPositionInLine(int charPositionInLine) {
		this.charPositionInLine = charPositionInLine;
		return this;
	}
}
