package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class NEq<T> extends Expr<Boolean> {

	public NEq(T expr, T expr2) {
		super(expr != expr2);
	}
}
