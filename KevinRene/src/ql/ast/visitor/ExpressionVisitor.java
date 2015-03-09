package ql.ast.visitor;

import ql.ast.expression.Binary;
import ql.ast.expression.Identifier;
import ql.ast.expression.Unary;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Div;
import ql.ast.expression.arithmetic.Mul;
import ql.ast.expression.arithmetic.Neg;
import ql.ast.expression.arithmetic.Pos;
import ql.ast.expression.arithmetic.Sub;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.And;
import ql.ast.expression.relational.Eq;
import ql.ast.expression.relational.GEq;
import ql.ast.expression.relational.GT;
import ql.ast.expression.relational.LEq;
import ql.ast.expression.relational.LT;
import ql.ast.expression.relational.NEq;
import ql.ast.expression.relational.Not;
import ql.ast.expression.relational.Or;
import ql.ast.expression.type.QLBoolean;
import ql.ast.expression.type.QLError;
import ql.ast.expression.type.QLFloat;
import ql.ast.expression.type.QLForm;
import ql.ast.expression.type.QLInteger;
import ql.ast.expression.type.QLNumeric;
import ql.ast.expression.type.QLString;

public interface ExpressionVisitor<T> {
	
	default T visit(Unary unaryNode) {
		unaryNode.getExpression().accept(this);
		
		return null;
	};
	
	default T visit(Binary binaryNode) {
		binaryNode.getLeft().accept(this);
		binaryNode.getRight().accept(this);
		return null;
	};
	
	default T visit(Identifier identNode) {	return null; }
	
	// Types contain nothing. An empty function will be the default visit action.
	default T visit(QLBoolean booleanNode) 	{ return null; }
	default T visit(QLFloat floatNode) 		{ return null; }   
	default T visit(QLForm formNode) 		{ return null; } 
	default T visit(QLNumeric numericNode) 	{ return null; }
	default T visit(QLInteger intNode) 		{ return null; }
	default T visit(QLString stringNode) 	{ return null; }
	default T visit(QLError errNode)		{ return null; }
	
	default T visit(BooleanLiteral booleanNode) {	return null;}	
	default T visit(FloatLiteral floatNode) {		return null;}
	default T visit(IntegerLiteral intNode) {		return null;}
	default T visit(StringLiteral stringNode) {		return null;}
	
	default T visit(Add addNode) {
		addNode.getLeft().accept(this);
		addNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Div divNode) {
		divNode.getLeft().accept(this);
		divNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Mul mulNode) {
		mulNode.getLeft().accept(this);
		mulNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Sub subNode) {
		subNode.getLeft().accept(this);
		subNode.getRight().accept(this);
		return null;
	}

	default T visit(And andNode) {
		andNode.getLeft().accept(this);
		andNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Eq eqNode) {
		eqNode.getLeft().accept(this);
		eqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(GEq geqNode) {
		geqNode.getLeft().accept(this);
		geqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(GT gtNode) {
		gtNode.getLeft().accept(this);
		gtNode.getRight().accept(this);
		return null;
	}
	
	default T visit(LEq leqNode) {
		leqNode.getLeft().accept(this);
		leqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(LT ltNode) {
		ltNode.getLeft().accept(this);
		ltNode.getRight().accept(this);
		return null;
	}
	
	default T visit(NEq neqNode) {
		neqNode.getLeft().accept(this);
		neqNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Or orNode) {
		orNode.getLeft().accept(this);
		orNode.getRight().accept(this);
		return null;
	}
	
	default T visit(Neg negNode) {
		negNode.getExpression().accept(this);
		return null;
	}
	default T visit(Not notNode) {
		notNode.getExpression().accept(this);
		return null;
	}
	default T visit(Pos posNode) {
		posNode.getExpression().accept(this);
		return null;
	}
}
