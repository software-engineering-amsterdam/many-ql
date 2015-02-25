package org.uva.ql.ast.statement;


import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.visitor.Visitor;

public class IfElseStatement extends IfStatement {

	//private Block elseBlock;
	private final Block elseBlock;

	public IfElseStatement(Expression expr, Block ifBlock, Block elseBlock) {
		super(expr, ifBlock);
		this.elseBlock = elseBlock;
	}

	public Block getElseBLock() {
		return elseBlock;
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tElse Block = " + elseBlock.toString();
	}
}
