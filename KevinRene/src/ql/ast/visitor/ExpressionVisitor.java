package ql.ast.visitor;

import ql.ast.expression.Binary;
import ql.ast.expression.Unary;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Negation;
import ql.ast.expression.arithmetic.Positive;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.relational.And;
import ql.ast.expression.relational.Equal;
import ql.ast.expression.relational.Greater;
import ql.ast.expression.relational.GreaterOrEqual;
import ql.ast.expression.relational.Lower;
import ql.ast.expression.relational.LowerOrEqual;
import ql.ast.expression.relational.Not;
import ql.ast.expression.relational.NotEqual;
import ql.ast.expression.relational.Or;
import shared.IExpressionVisitor;

public interface ExpressionVisitor<T> extends IExpressionVisitor<T> {	
	default T visit(Unary unaryNode) {
		unaryNode.getExpression().accept(this);		
		return null;
	};
	
	default T visit(Binary binaryNode) {
		binaryNode.getLeft().accept(this);
		binaryNode.getRight().accept(this);
		return null;
	};
	
	default T visit(Add addNode) {
		addNode.getLeft().accept(this);
		addNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Divide divNode) {
		divNode.getLeft().accept(this);
		divNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Multiply mulNode) {
		mulNode.getLeft().accept(this);
		mulNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Subtract subNode) {
		subNode.getLeft().accept(this);
		subNode.getRight().accept(this);
		return null;
	}

	default T visit(And andNode) {
		andNode.getLeft().accept(this);
		andNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Equal eqNode) {
		eqNode.getLeft().accept(this);
		eqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(GreaterOrEqual geqNode) {
		geqNode.getLeft().accept(this);
		geqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Greater gtNode) {
		gtNode.getLeft().accept(this);
		gtNode.getRight().accept(this);
		return null;
	}
	
	default T visit(LowerOrEqual leqNode) {
		leqNode.getLeft().accept(this);
		leqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Lower ltNode) {
		ltNode.getLeft().accept(this);
		ltNode.getRight().accept(this);
		return null;
	}
	
	default T visit(NotEqual neqNode) {
		neqNode.getLeft().accept(this);
		neqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Or orNode) {
		orNode.getLeft().accept(this);
		orNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Negation negNode) {
		negNode.getExpression().accept(this);
		return null;
	}
	
	default T visit(Not notNode) {
		notNode.getExpression().accept(this);
		return null;
	}
	
	default T visit(Positive posNode) {
		posNode.getExpression().accept(this);
		return null;
	}
}
