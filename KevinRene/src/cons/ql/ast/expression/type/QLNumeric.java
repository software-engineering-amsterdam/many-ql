package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLNumeric extends QLType {

	public QLNumeric() {
		super(Arrays.asList(QLFloat.class, QLInt.class, QLNumeric.class));
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLType getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
