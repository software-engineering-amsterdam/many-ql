package org.uva.sea.ql.encoders.ast.expression;

import org.uva.sea.ql.encoders.ast.AstNode;
import org.uva.sea.ql.encoders.ast.TextLocation;

public abstract class Expression extends AstNode {

	public Expression(TextLocation textLocation) {
		super(textLocation);
	}

}
