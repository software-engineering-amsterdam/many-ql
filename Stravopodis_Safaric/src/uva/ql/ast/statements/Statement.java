package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.value.GenericValue;

public abstract class Statement extends ASTNode{
	
	public Statement(CodeLines _codeLines){
		super(_codeLines);
	}
	
	public abstract <T> T accept(StatementVisitor<T> visitor);
	
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
}
