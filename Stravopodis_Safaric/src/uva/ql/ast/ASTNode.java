package uva.ql.ast;

public abstract class ASTNode {
	
	protected CodeLines lines;
	
	public ASTNode(CodeLines _lines){
		this.lines = _lines;
	}
	public ASTNode(){
		super();
	}
	public int getStartLine(){
		return this.lines.getCodeLines().x;
	}
	public int getEndLine(){
		return this.lines.getCodeLines().y;
	}
	@Override
	public String toString(){
		return this.toString();
	}
}
