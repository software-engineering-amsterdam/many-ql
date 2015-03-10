package nl.uva.se.ast.type;

import nl.uva.se.evaluation.value.StringValue;
import nl.uva.se.evaluation.value.Value;

public class StringType extends Type {

	public StringType() {
		super("string");
	}

	@Override
	public Value getDefaultValue() {
		return new StringValue("");
	}
	
}
