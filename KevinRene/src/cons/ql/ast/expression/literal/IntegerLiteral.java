package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
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
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
