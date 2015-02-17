package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLIdentifier extends QLType {
	public QLIdentifier() {
		super(Arrays.asList());
	}
	
	@Override
	public QLType getType() {
		return new QLIdentifier();
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}	
}
