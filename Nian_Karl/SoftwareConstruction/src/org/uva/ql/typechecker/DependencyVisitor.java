package org.uva.ql.typechecker;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthesis;
import org.uva.ql.ast.expression.binary.Addition;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Binary;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Substraction;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.visitor.ExpressionVisitor;

public class DependencyVisitor implements ExpressionVisitor<List<Identifier>> {

	private final List<Identifier> identifiers;
	
	public DependencyVisitor() {
		identifiers = new ArrayList<Identifier>();
	}
	
	private List<Identifier> visitBinary(Binary node) {
		Expression left = node.getLeftExpression();
		Expression right = node.getRightExpression();
		left.accept(this);
		right.accept(this);
		return identifiers;
	}
	
	@Override
	public List<Identifier> visit(Not node) {
		return node.getExpression().accept(this);
	}

	@Override
	public List<Identifier> visit(Positive node) {
		return node.getExpression().accept(this);
	}

	@Override
	public List<Identifier> visit(Negative node) {
		return node.getExpression().accept(this);
	}

	@Override
	public List<Identifier> visit(Addition node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Substraction node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Multiply node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Divide node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(And node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Or node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Equal node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(NotEqual node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Greater node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(GreaterEqual node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Less node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(LessEqual node) {
		return visitBinary(node);
	}

	@Override
	public List<Identifier> visit(Identifier node) {
		identifiers.add(node);
		return identifiers;
	}

	@Override
	public List<Identifier> visit(IntLiteral node) {
		return identifiers;
	}

	@Override
	public List<Identifier> visit(BoolLiteral node) {
		return identifiers;
	}

	@Override
	public List<Identifier> visit(StrLiteral node) {
		return identifiers;
	}

	@Override
	public List<Identifier> visit(Parenthesis node) {
		return identifiers;
	}

}
