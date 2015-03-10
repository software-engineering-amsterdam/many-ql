package nl.uva.se.ql.ast.type;

import java.math.BigDecimal;

import nl.uva.se.ql.evaluation.value.DecimalValue;
import nl.uva.se.ql.evaluation.value.Value;

public class DecimalType extends Type {

	public DecimalType() {
		super("decimal");
	}

	@Override
	public Value getDefaultValue() {
		return new DecimalValue(new BigDecimal(0));
	}

	@Override
	public Type getAcceptedType() {
		return new IntegerType();
	}
	
}
