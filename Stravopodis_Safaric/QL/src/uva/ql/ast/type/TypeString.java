package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class TypeString extends Type{

	public TypeString(){
		super();
	}
	
	public TypeString(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitTypeString(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}

}
