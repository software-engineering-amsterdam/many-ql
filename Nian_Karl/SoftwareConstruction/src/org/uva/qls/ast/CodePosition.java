package org.uva.qls.ast;

import org.antlr.v4.runtime.ParserRuleContext;

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
	
	public static CodePosition getCodePosition(ParserRuleContext ctx) {
		return new CodePosition(ctx.getStart().getLine(), ctx.getStop().getLine());
	}
}
