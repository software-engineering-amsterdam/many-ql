package cons.ql.ast.expression.type;

import java.util.Arrays;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.visitor.Visitor;

public class QLIdent extends QLType {
	
	String value;
	boolean defined;
	
	public QLIdent() {
		super(Arrays.asList());
	}
	
	public QLIdent(String value) {
		super(Arrays.asList());
		this.value = value;
		this.defined = true;
	}
	
	//TODO remove
	public String getValue() {
		return this.value;
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
		return new QLIdent();
	}
}
