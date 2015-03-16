package nl.uva.se.ql.ast.type;

import nl.uva.se.ql.evaluation.value.BooleanValue;

public class BooleanType extends Type {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public BooleanValue getDefaultValue() {
		return new BooleanValue(false);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
