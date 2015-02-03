package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Not extends Expr<Boolean> {

	public Not(boolean expr) {
		super(!expr);
	}
}
