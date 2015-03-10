package nl.uva.se.ql.ast.type;

import nl.uva.se.ql.evaluation.value.BooleanValue;
import nl.uva.se.ql.evaluation.value.Value;

public class BooleanType extends Type {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public Value getDefaultValue() {
		return new BooleanValue(false);
	}

}
