package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLBoolean extends QLType {
	
	String value;
	boolean defined;
	
	public QLBoolean() {
		super(Arrays.asList(QLBoolean.class));
	}
	
	public QLBoolean(String value) {
		super(Arrays.asList(QLBoolean.class));
		this.value = value;
		this.defined = true;
	}

	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}

	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
