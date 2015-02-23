package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.visitor.Visitor;

@SuppressWarnings("rawtypes")
public class IntegerLiteral extends Literal<Integer> {	

	public IntegerLiteral(int value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public Literal add(Literal argument) {
		return argument.addInteger(this.getValue());
	}
	
	@Override
	public Literal addInteger(int argument) {
		return new IntegerLiteral(getValue() + argument);
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
