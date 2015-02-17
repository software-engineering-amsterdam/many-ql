package uva.ql.ast;


import uva.ql.parser.Visitor;
import uva.ql.supporting.Tuple;

public abstract class ASTNode {
	
	protected Tuple<Integer, Integer> lines;
	public abstract void accept(Visitor visitor);
	
	public ASTNode(Tuple<Integer,Integer> _lines){
		this.lines = _lines;
	}
	public ASTNode(){
		super();
	}
	public int getStartLine(){
		return this.lines.x;
	}
	public int getEndLine(){
		return this.lines.y;
	}
}
