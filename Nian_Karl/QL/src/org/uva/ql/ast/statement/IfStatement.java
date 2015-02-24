package org.uva.ql.ast.statement;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.visitor.Visitor;

public class IfStatement extends Statement {

	private BlockStatement ifBlock;

	private final Expression expr;

	public IfStatement(Expression expr, BlockStatement ifBlock) {
		this.expr = expr;
		this.ifBlock = ifBlock;
	}

	public Expression getExpr() {
		return expr;
	}

	public BlockStatement getIfBlock() {
		return ifBlock;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
