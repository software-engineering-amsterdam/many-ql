package nl.uva.se.ast.type;

import nl.uva.se.evaluation.value.BooleanValue;
import nl.uva.se.evaluation.value.Value;

public class BooleanType extends Type {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public Value getDefaultValue() {
		return new BooleanValue(false);
	}

}
