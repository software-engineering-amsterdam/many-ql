package nl.uva.se.ast.type;

import java.math.BigDecimal;

import nl.uva.se.evaluation.value.DecimalValue;
import nl.uva.se.evaluation.value.Value;

public class DecimalType extends Type {

	public DecimalType() {
		super("decimal");
	}

	@Override
	public Value getDefaultValue() {
		return new DecimalValue(new BigDecimal(0));
	}
	
}
