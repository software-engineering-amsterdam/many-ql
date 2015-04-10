package qlProject.auxiliary_expression_visitors;

import java.util.HashSet;
import java.util.Set;

import qlProject.ast.expression.BinaryExpression;
import qlProject.ast.expression.IExpressionVisitor;
import qlProject.ast.expression.Id;
import qlProject.ast.expression.ParenthesisExpr;
import qlProject.ast.expression.StringExpr.ConcatenationExpr;
import qlProject.ast.expression.StringExpr.StringLiteral;
import qlProject.ast.expression.arithmeticExpr.AdditionExpr;
import qlProject.ast.expression.arithmeticExpr.DivisionExpr;
import qlProject.ast.expression.arithmeticExpr.IntLiteral;
import qlProject.ast.expression.arithmeticExpr.MultiplicationExpr;
import qlProject.ast.expression.arithmeticExpr.NegationExpr;
import qlProject.ast.expression.arithmeticExpr.SubtractionExpr;
import qlProject.ast.expression.booleanExpr.BoolLiteral;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.BiggerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.EqualExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerEqExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.SmallerThanExpr;
import qlProject.ast.expression.booleanExpr.comparisonExpression.UnequalExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.AndExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.NotExpr;
import qlProject.ast.expression.booleanExpr.logicalExpression.OrExpr;

public class VariablesCollectionVisitor implements IExpressionVisitor{

	@Override
	public Set<String> visit(NotExpr expr) {
		return (Set<String>) expr.getSubExpression().accept(this);
	}

	@Override
	public Set<String> visit(BoolLiteral boolLiteral) {
		return new HashSet<String>();
	}

	@Override
	public Set<String> visit(IntLiteral intLiteral) {
		return new HashSet<String>();
	}

	@Override
	public Set<String> visit(Id id) {
		Set<String> vars = new HashSet<String>();
		vars.add(id.getIdString());
		return vars;
	}

	@Override
	public Set<String> visit(StringLiteral stringLiteral) {
		return new HashSet<String>();
		}

	@Override
	public Set<String> visit(BiggerThanExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(BiggerEqExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(SmallerThanExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(SmallerEqExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(EqualExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(UnequalExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(ConcatenationExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(OrExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(AndExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(AdditionExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(DivisionExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(MultiplicationExpr expr) {
		return visitBinarySubExprs(expr);
	}

	@Override
	public Set<String> visit(SubtractionExpr expr) {
		return visitBinarySubExprs(expr);
	}

	public Set<String> visitBinarySubExprs(BinaryExpression expr){
		Set<String> vars = new HashSet<String>(); 
		vars.addAll((Set<String>)expr.getLeft().accept(this));
		vars.addAll((Set<String>)expr.getRight().accept(this));
		return vars;}

	@Override
	public Set<String> visit(NegationExpr expr) {
		return (Set<String>) expr.getSubExpression().accept(this);
	}

	@Override
	public Set<String> visit(ParenthesisExpr e) {
		return (Set<String>)(e.getSubExpression().accept(this));
	}

}