package ast.visitor;

import ast.expression.association.Parenthese;
import ast.expression.binary.Plus;
import ast.expression.literal.IntLiteral;
import ast.value.Int;
import ast.value.Value;

public class Evaluator implements Visitor<Value> {

	public Evaluator() {
		
	}

	@Override
	public Value visit(Plus node) {
		Int left = (Int) node.getLeftExpression().accept(this);
		Int right = (Int) node.getRightExpression().accept(this);
		return left.plus(right);
	}

	@Override
	public Value visit(IntLiteral node) {
		return new Int(node.getValue());
	}

	@Override
	public Value visit(Parenthese node) {
		return node.getExpression().accept(this);
	}

}
