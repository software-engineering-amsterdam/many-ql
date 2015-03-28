package uva.ql.ast;

public abstract class Node {
	
	protected CodeLines codeLines;
	
	public Node(){
		super();
	}
	
	public Node(CodeLines _codeLines){
		this.codeLines = _codeLines;
	}
	
}
