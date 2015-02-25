package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLString extends QLType {		
	public QLString() {
		super(Arrays.asList(QLString.class));
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
