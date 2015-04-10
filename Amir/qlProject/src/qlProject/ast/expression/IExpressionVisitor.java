package qlProject.ast.expression;

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

public interface IExpressionVisitor {

	public Object visit (BiggerThanExpr expr);
	public Object visit (BiggerEqExpr expr);
	public Object visit (SmallerThanExpr expr);
	public Object visit (SmallerEqExpr expr);
	public Object visit (EqualExpr expr);
	public Object visit (UnequalExpr expr);
	public Object visit (ConcatenationExpr stringConcatenationExpr);
	public Object visit (NotExpr expr);
	public Object visit (IntLiteral intLiteral);
	public Object visit (BoolLiteral boolLiteral);
	public Object visit(StringLiteral stringLiteral);
	public Object visit (Id id);
	public Object visit(OrExpr expr);
	public Object visit(AndExpr expr);
	public Object visit(AdditionExpr expr);
	public Object visit(DivisionExpr expr);
	public Object visit(MultiplicationExpr expr);
	public Object visit(SubtractionExpr expr);
	public Object visit(NegationExpr expr);
	public Object visit(ParenthesisExpr expr);
}