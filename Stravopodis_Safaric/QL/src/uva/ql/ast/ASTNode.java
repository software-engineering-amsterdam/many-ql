package uva.ql.ast;

public abstract class ASTNode {
	
	protected CodeLines codeLines;
	
	public ASTNode(){
		super();
	}
	
	public ASTNode(CodeLines _codeLines){
		this.codeLines = _codeLines;
	}
}
