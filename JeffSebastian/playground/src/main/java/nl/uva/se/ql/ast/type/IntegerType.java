package nl.uva.se.ql.ast.type;

import nl.uva.se.ql.evaluation.value.IntegerValue;
import nl.uva.se.ql.evaluation.value.Value;

public class IntegerType extends Type {

	public IntegerType() {
		super("integer");
	}

	@Override
	public Value getDefaultValue() {
		return new IntegerValue(0);
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type promote() {
		return new DecimalType();
	}

	@Override
	public boolean isNumerical() {
		return true;
	}
	
}
