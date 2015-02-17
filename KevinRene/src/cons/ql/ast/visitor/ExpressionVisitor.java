package cons.ql.ast.visitor;

import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
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
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;

public interface ExpressionVisitor extends Visitor {
	default void visit(Add addNode) {
		addNode.getLeft().accept(this);
		addNode.getRight().accept(this);
	}
	
	default void visit(Div divNode) {
		divNode.getLeft().accept(this);
		divNode.getRight().accept(this);
	}
	
	default void visit(Mul mulNode) {
		mulNode.getLeft().accept(this);
		mulNode.getRight().accept(this);
	}
	
	default void visit(Sub subNode) {
		subNode.getLeft().accept(this);
		subNode.getRight().accept(this);
	}
	
	public void visit(QLBoolean booleanNode);	
	public void visit(QLFloat floatNode);	
	public void visit(Identifier identNode);	
	public void visit(QLInteger intNode);
	public void visit(QLString stringNode);
	
	default void visit(And andNode) {
		andNode.getLeft().accept(this);
		andNode.getRight().accept(this);
	}
	
	default void visit(Eq eqNode) {
		eqNode.getLeft().accept(this);
		eqNode.getRight().accept(this);
	}
	
	default void visit(GEq geqNode) {
		geqNode.getLeft().accept(this);
		geqNode.getRight().accept(this);
	}
	
	default void visit(GT gtNode) {
		gtNode.getLeft().accept(this);
		gtNode.getRight().accept(this);
	}
	
	default void visit(LEq leqNode) {
		leqNode.getLeft().accept(this);
		leqNode.getRight().accept(this);
	}
	
	default void visit(LT ltNode) {
		ltNode.getLeft().accept(this);
		ltNode.getRight().accept(this);
	}
	
	default void visit(NEq neqNode) {
		neqNode.getLeft().accept(this);
		neqNode.getRight().accept(this);
	}
	
	default void visit(Or orNode) {
		orNode.getLeft().accept(this);
		orNode.getRight().accept(this);
	}
	
	public void visit(Neg negNode);
	public void visit(Not notNode);
	public void visit(Pos posNode);
}
