package org.uva.sea.ql.encoders.ast;

public class TextLocation {

	private int line;
	private int charPositionInLine;

	public TextLocation(int line, int charPositionInLine) {
		this.line = line;
		this.charPositionInLine = charPositionInLine;
	}

	public int getCharPositionInLine() {
		return charPositionInLine;
	}

	public int getLine() {
		return line;
	}

	@Override
	public String toString() {
		return "Line: " + line + " Position in line: " + charPositionInLine;
	}
}
