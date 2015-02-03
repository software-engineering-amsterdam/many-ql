package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class And extends Expr<Boolean> {

	public And(boolean expr, boolean expr2) {
		super(expr && expr2);
	}
}
