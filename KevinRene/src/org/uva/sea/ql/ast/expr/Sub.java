package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Sub extends Expr<Integer> {

	public Sub(int expr, int expr2) {
		super(expr - expr2);
	}
}
