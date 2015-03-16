package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class TypeInteger extends Type{

	public TypeInteger(){
		super();
	}
	
	public TypeInteger(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitTypeInteger(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}

}
