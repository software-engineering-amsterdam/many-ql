package uva.ql.ast.expressions.literals;
import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.Expression;

public class Value<T> extends Expression{

	T value;
	public Value(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	@Override
	public String toString(){
		return this.getClass().getName().toString() + "(" + this.getClass().getName().toString() + ")";
	}
}

