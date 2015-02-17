package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.visitor.Visitor;

public class FloatLiteral extends Literal<Float> {	

	public FloatLiteral(float value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public void accept(Visitor visitor) {}

}
