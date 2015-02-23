package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.VisitorInterface;

public abstract class Statement extends ASTNode{
	
	public Statement(CodeLines _codeLines){
		super(_codeLines);
	}
	
	public abstract <T> T accept(VisitorInterface<T> visitor);
	
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
}
