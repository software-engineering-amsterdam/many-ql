package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.StatementVisitorInterface;

public abstract class Statement extends ASTNode{
	
	public abstract <T> T accept(StatementVisitorInterface<T> visitor);
	public abstract CodeLines getCodeLine();
	
	public Statement(CodeLines _codeLines){
		super(_codeLines);
	}
}
