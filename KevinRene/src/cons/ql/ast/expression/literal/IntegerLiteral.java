package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.visitor.Visitor;

public class IntegerLiteral extends Literal<Integer> {	

	public IntegerLiteral(int value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public void accept(Visitor visitor) {}
}
