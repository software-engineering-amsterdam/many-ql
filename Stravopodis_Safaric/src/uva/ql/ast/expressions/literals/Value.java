package uva.ql.ast.expressions.literals;
import uva.ql.ast.expressions.Expression;
import uva.ql.supporting.Tuple;

public class Value<T> extends Expression{

	T value;
	
	public Value(Tuple<Integer, Integer> codeLines) {
		super(codeLines);
	}
	
}

