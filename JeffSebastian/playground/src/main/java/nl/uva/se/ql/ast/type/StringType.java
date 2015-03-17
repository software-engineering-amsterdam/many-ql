package nl.uva.se.ql.ast.type;

import nl.uva.se.ql.evaluation.value.StringValue;
import nl.uva.se.ql.evaluation.value.Value;

public class StringType extends Type {

	public StringType() {
		super("string");
	}

	@Override
	public Value getDefaultValue() {
		return new StringValue("");
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
