package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.StatementVisitor;

public abstract class Statement extends ASTNode{
	
	public abstract <T> T accept(StatementVisitor<T> visitor);
	public abstract CodeLines getCodeLine();
	
	public Statement(CodeLines _codeLines){
		super(_codeLines);
	}
}
