package org.uva.ql.ast.builder;

public class CodePosition {
	private final int startLine;
	private final int endLine;
	
	public CodePosition(int startLine, int endLine) {
		this.startLine = startLine;
		this.endLine = endLine;
	}
	
	public int getEndLine() {
		return endLine;
	}
	
	public int getStartLine() {
		return startLine;
	}
}
