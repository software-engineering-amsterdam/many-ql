package cons.ql.ast.expression.literal;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.visitor.Visitor;

public class BooleanLiteral extends Expression {
	
	boolean value;
	
	public BooleanLiteral(boolean value) {
		this.value = value;
	}
	
	@Override
	public void accept(Visitor visitor) {

	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}

}
