package nl.uva.se.ql.ast;

public abstract class Node {
	
	private final int lineNumber;
	private final int offset;
	
	public Node(int lineNumber, int offset) {
		this.lineNumber = lineNumber;
		this.offset = offset;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getOffset() {
		return offset;
	}
	
}
