package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class TypeBoolean extends Type{

	public TypeBoolean(){
		super();
	}
	
	public TypeBoolean(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitTypeBoolean(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}
	
}
