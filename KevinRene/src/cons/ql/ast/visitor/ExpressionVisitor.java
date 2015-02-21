package cons.ql.ast.visitor;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.FloatLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.relational.And;
import cons.ql.ast.expression.relational.Eq;
import cons.ql.ast.expression.relational.GEq;
import cons.ql.ast.expression.relational.GT;
import cons.ql.ast.expression.relational.LEq;
import cons.ql.ast.expression.relational.LT;
import cons.ql.ast.expression.relational.NEq;
import cons.ql.ast.expression.relational.Or;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;

public interface ExpressionVisitor<T> extends Visitor<Void> {
	
	default Void visit(Unary unaryNode) {
		unaryNode.getExpression().accept(this);
		
		return null;
	};
	
	default Void visit(Binary binaryNode) {
		binaryNode.getLeft().accept(this);
		binaryNode.getRight().accept(this);
		return null;
	};
	
	default Void visit(Identifier identNode) {		return null;}
	
	// Types contain nothing. An empty function will be the default visit action.
	default Void visit(QLBoolean booleanNode) {	return null;}
	default Void visit(QLFloat floatNode) {		return null;}    
	default Void visit(QLNumeric numericNode) {	return null;}
	default Void visit(QLInteger intNode) {		return null;}
	default Void visit(QLString stringNode) {
		return null;}
	
	default Void visit(BooleanLiteral booleanNode) {	return null;}	
	default Void visit(FloatLiteral floatNode) {		return null;}
	default Void visit(IntegerLiteral intNode) {		return null;}
	default Void visit(StringLiteral stringNode) {		return null;}
	
	default Void visit(Add addNode) {
		addNode.getLeft().accept(this);
		addNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Div divNode) {
		divNode.getLeft().accept(this);
		divNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Mul mulNode) {
		mulNode.getLeft().accept(this);
		mulNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Sub subNode) {
		subNode.getLeft().accept(this);
		subNode.getRight().accept(this);
		return null;
	}

	default Void visit(And andNode) {
		andNode.getLeft().accept(this);
		andNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Eq eqNode) {
		eqNode.getLeft().accept(this);
		eqNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(GEq geqNode) {
		geqNode.getLeft().accept(this);
		geqNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(GT gtNode) {
		gtNode.getLeft().accept(this);
		gtNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(LEq leqNode) {
		leqNode.getLeft().accept(this);
		leqNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(LT ltNode) {
		ltNode.getLeft().accept(this);
		ltNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(NEq neqNode) {
		neqNode.getLeft().accept(this);
		neqNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Or orNode) {
		orNode.getLeft().accept(this);
		orNode.getRight().accept(this);
		return null;
	}
	
	default Void visit(Neg negNode) {
		negNode.getExpression().accept(this);
		return null;
	}
	default Void visit(Not notNode) {
		notNode.getExpression().accept(this);
		return null;
	}
	default Void visit(Pos posNode) {
		posNode.getExpression().accept(this);
		return null;
	}
}
