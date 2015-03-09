package uva.sc.atom;

import uva.sc.ast.INodeVisitor;
import uva.sc.logic.Expression;

public class NumberAtom extends Expression{

	String value;
	
	public NumberAtom(String value) {
		this.value = (value.equals("")) ? "0" : value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString(){
		return value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Expression evaluate() {
		return null;
	}

}
