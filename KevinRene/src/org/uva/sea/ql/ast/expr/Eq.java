package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Eq<T> extends Expr<Boolean> {

	public Eq(T expr, T expr2) {
		super(expr == expr2);
	}
}
