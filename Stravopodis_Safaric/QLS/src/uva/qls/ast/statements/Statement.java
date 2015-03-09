package uva.qls.ast.statements;

import uva.qls.ast.ASTNode;
import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;

public abstract class Statement extends ASTNode {

	public Statement(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public abstract <T> T accept(StatementVisitor<T> visitor);
}
