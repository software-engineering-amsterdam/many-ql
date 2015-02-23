package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

@SuppressWarnings("rawtypes")
public class StringLiteral extends Literal<String> {	
	
	public StringLiteral(String value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public Literal add(Literal argument) {
		return argument.addString(getValue());
	}
	
	@Override
	public Literal addInteger(int argument) {
		return new StringLiteral(getValue() + argument);
	}
	
	@Override
	public Literal addFloat(float argument) {
		return new StringLiteral(getValue() + argument);
	}

	@Override
	public Literal addString(String argument) {
		return new StringLiteral(getValue() + argument);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
