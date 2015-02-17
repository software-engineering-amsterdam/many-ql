package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLBoolean extends QLType {
	public QLBoolean() {
		super(Arrays.asList(QLBoolean.class));
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}
		
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
