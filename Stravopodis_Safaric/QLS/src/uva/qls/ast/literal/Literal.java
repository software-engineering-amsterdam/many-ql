package uva.qls.ast.literal;

import uva.qls.ast.ASTNode;
import uva.qls.ast.CodeLines;
import uva.qls.ast.value.GenericValue;

public abstract class Literal extends ASTNode {

	
	public Literal(CodeLines codeLines){
		super(codeLines);
		
	}
	
	@Override
	public abstract String toString();
	public abstract GenericValue<?> evaluate();
}

