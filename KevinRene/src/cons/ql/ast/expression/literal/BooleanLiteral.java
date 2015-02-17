package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.visitor.Visitor;

public class BooleanLiteral extends Literal<Boolean> {	

	public BooleanLiteral(boolean value) {
		super(value);
	}
	
	@Override
	public void accept(Visitor visitor) {}


	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
