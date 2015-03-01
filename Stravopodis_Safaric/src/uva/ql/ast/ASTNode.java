package uva.ql.ast;

import uva.ql.ast.value.GenericValue;

public abstract class ASTNode {
	
	protected CodeLines codeLines;
	public abstract GenericValue<?> evaluate();
	
	public ASTNode(CodeLines _codeLines){
		this.codeLines = _codeLines;
	}
	
	@Override
	public String toString(){
		return this.toString();
	}
}
