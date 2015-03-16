package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public class TypeMoney extends Type{

	public TypeMoney(){
		super();
	}
	
	public TypeMoney(CodeLines _codeLines) {
		super(_codeLines);
	}

	@Override
	public <T> T accept(ExpressionVisitorInterface<T> visitor) {
		return visitor.visitTypeMoney(this);
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}
}
