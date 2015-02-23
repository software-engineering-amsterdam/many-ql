package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.visitor.Visitor;

@SuppressWarnings("rawtypes")
public class FloatLiteral extends Literal<Float> {	

	public FloatLiteral(float value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public Literal add(Literal argument) {
		return argument.addFloat(getValue());
	}

	@Override
	public Literal addInteger(int argument) {
		return new FloatLiteral(getValue() + argument);
	}
	
	@Override
	public Literal addFloat(float argument) {
		return new FloatLiteral(getValue() + argument);
	}

	@Override
	public Literal addString(String argument) {
		return new StringLiteral(getValue().toString() + argument);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
