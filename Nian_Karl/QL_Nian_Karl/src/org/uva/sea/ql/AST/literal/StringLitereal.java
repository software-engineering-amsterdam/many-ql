package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.value.StringValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class StringLitereal extends AbstractLiteral {

	public final String stringValue;

	public StringLitereal(String stringValue) {
		this.stringValue = stringValue;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
