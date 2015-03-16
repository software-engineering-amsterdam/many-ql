package uva.ql.ast.type;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public abstract class Type extends ASTNode{
	
	public abstract <T> T accept(ExpressionVisitorInterface<T> visitor);
	
	public Type(){
		super();
	}
	
	public Type(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		return this.getClass() == obj.getClass();
	}
}
