package org.uva.sea.ql.encoders.ast;

public class TextLocationBuilder {

	private int line;
	private int column;

	public static TextLocationBuilder aTextLocation() {
		TextLocationBuilder builder = new TextLocationBuilder();
		builder.line = 10;
		builder.column = 10;
		return builder;
	}

	public TextLocation build() {
		return new TextLocation(line, column);
	}

	public TextLocationBuilder withLine(int line) {
		this.line = line;
		return this;
	}

	public TextLocationBuilder withColumn(int column) {
		this.column = column;
		return this;
	}
}
