package uva.qls.ast.type;

import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.ASTNode;
import uva.qls.ast.CodeLines;

public abstract class Type extends ASTNode{

	public abstract <T> T accept(StatementVisitor<T> visitor);
	
	public Type(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		return this == obj;
	}
}
