package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.TypeVisitor;

public class TypeMoney extends Type{

	public TypeMoney(){
		super();
	}
	
	public TypeMoney(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	@Override
	public NumberValue typeInitialValue() {
		return new NumberValue(0);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visitTypeMoney(this);
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}
}
