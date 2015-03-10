package nl.uva.se.ast.type;

import nl.uva.se.evaluation.value.IntegerValue;
import nl.uva.se.evaluation.value.Value;

public class IntegerType extends Type {

	public IntegerType() {
		super("integer");
	}

	@Override
	public Value getDefaultValue() {
		return new IntegerValue(0);
	}

}
