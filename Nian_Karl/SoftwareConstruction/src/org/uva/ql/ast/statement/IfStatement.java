package org.uva.ql.ast.statement;

import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.StatementVisitor;

public class IfStatement extends Statement {

	private final Block ifBlock;
	private final Expression expr;

	public IfStatement(Expression expr, Block ifBlock, CodePosition pos) {
		super(pos);
		this.expr = expr;
		this.ifBlock = ifBlock;
	}

	public Expression getExpr() {
		return expr;
	}

	public Block getIfBlock() {
		return ifBlock;
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "[If] " + "\n\tExpression = " + expr.toString() + "\n\tIf Block = " + ifBlock.toString();
	}

}
