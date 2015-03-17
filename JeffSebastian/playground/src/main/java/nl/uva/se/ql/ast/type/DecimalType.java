package nl.uva.se.ql.ast.type;

import java.math.BigDecimal;

import nl.uva.se.ql.evaluation.value.DecimalValue;

public class DecimalType extends Type {

	public DecimalType() {
		super("decimal");
	}

	@Override
	public DecimalValue getDefaultValue() {
		return new DecimalValue(new BigDecimal(0));
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isNumerical() {
		return true;
	}
	
}
