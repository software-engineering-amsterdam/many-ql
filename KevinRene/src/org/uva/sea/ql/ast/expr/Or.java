package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Or extends Expr<Boolean> {

	public Or(boolean expr, boolean expr2) {
		super(expr || expr2);
	}
}
