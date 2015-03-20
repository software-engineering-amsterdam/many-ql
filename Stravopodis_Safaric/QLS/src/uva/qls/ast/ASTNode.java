package uva.qls.ast;
import uva.qls.ast.CodeLines;


public abstract class ASTNode {
	
	protected CodeLines codeLines;
	
	public ASTNode (CodeLines _codeLines) {
		this.codeLines=_codeLines;
	}
}
