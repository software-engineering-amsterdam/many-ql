package ql.ast.visitor;

import ql.ast.expression.Parenthese;
import ql.ast.expression.binary.Plus;
import ql.ast.expression.literal.IntLiteral;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class Evaluator implements Visitor<Value<?>>{

	public Evaluator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Value<?> visit(Plus node) {
		Int left = (Int) node.getLeft().accept(this);
		Int right = (Int) node.getRight().accept(this);
		return left.add(right);
	}
	
	@Override
	public Value<?> visit(IntLiteral node) {
		return new Int(node.getValue());
	}

	@Override
	public Value<?> visit(Parenthese node) {
		return node.getExpression().accept(this);
	}
}
