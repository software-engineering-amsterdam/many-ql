package ast.builder;

import antlr.QLBaseVisitor;
import antlr.QLParser.ExprAndContext;
import antlr.QLParser.ExprDivideContext;
import antlr.QLParser.ExprEqualContext;
import antlr.QLParser.ExprGreaterContext;
import antlr.QLParser.ExprGreaterEqualContext;
import antlr.QLParser.ExprLessContext;
import antlr.QLParser.ExprLessEqualContext;
import antlr.QLParser.ExprMinusContext;
import antlr.QLParser.ExprMultiplyContext;
import antlr.QLParser.ExprNegativeContext;
import antlr.QLParser.ExprNotContext;
import antlr.QLParser.ExprNotEqualContext;
import antlr.QLParser.ExprOrContext;
import antlr.QLParser.ExprParenthesesContext;
import antlr.QLParser.ExprPlusContext;
import antlr.QLParser.ExprPositiveContext;
import antlr.QLParser.LiteralBoolContext;
import antlr.QLParser.LiteralIdContext;
import antlr.QLParser.LiteralIntContext;
import antlr.QLParser.LiteralStrContext;
import ast.Node;
import ast.expression.Expression;
import ast.expression.association.Parenthese;
import ast.expression.binary.And;
import ast.expression.binary.Divide;
import ast.expression.binary.Equal;
import ast.expression.binary.Greater;
import ast.expression.binary.GreaterEqual;
import ast.expression.binary.Less;
import ast.expression.binary.LessEqual;
import ast.expression.binary.Minus;
import ast.expression.binary.Multiply;
import ast.expression.binary.NotEqual;
import ast.expression.binary.Or;
import ast.expression.binary.Plus;
import ast.expression.literal.Identifier;
import ast.expression.literal.IntLiteral;
import ast.expression.literal.StrLiteral;
import ast.expression.unary.Negative;
import ast.expression.unary.Not;
import ast.expression.unary.Positive;

public class BuilderVisitor extends QLBaseVisitor<Node>{

	@Override
	public Node visitExprNot(ExprNotContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Not(expr);
	}
	
	@Override
	public Node visitExprPositive(ExprPositiveContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Positive(expr);
	}
	
	@Override
	public Node visitExprNegative(ExprNegativeContext ctx) {
		Expression expr = (Expression) ctx.expression().accept(this);
		return new Negative(expr);
	}
	
	@Override
	public Node visitExprPlus(ExprPlusContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		
//		Expression result = new Plus(left, right);
//		System.out.println(result.toString());
//		System.out.println(left.accept(new Evaluator()).getValue());
//		System.out.println(right.accept(new Evaluator()).getValue());
//		System.out.println("Result = " + result.accept(new Evaluator()).getValue());
		
		return new Plus(left, right);
	}
	
	@Override
	public Node visitExprMinus(ExprMinusContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Minus(left, right);
	}
	
	@Override
	public Node visitExprMultiply(ExprMultiplyContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Multiply(left, right);
	}
	
	@Override
	public Node visitExprDivide(ExprDivideContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Divide(left, right);
	}
	
	@Override
	public Node visitExprAnd(ExprAndContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new And(left, right);
	}
	
	@Override
	public Node visitExprOr(ExprOrContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Or(left, right);
	}
	
	@Override
	public Node visitExprEqual(ExprEqualContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Equal(left, right);
	}
	
	@Override
	public Node visitExprNotEqual(ExprNotEqualContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new NotEqual(left, right);
	}
	
	@Override
	public Node visitExprGreater(ExprGreaterContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Greater(left, right);
	}
	
	@Override
	public Node visitExprGreaterEqual(ExprGreaterEqualContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new GreaterEqual(left, right);
	}
	
	@Override
	public Node visitExprLess(ExprLessContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new Less(left, right);
	}
	
	@Override
	public Node visitExprLessEqual(ExprLessEqualContext ctx) {
		Expression left = (Expression) ctx.expression(0).accept(this);
		Expression right = (Expression) ctx.expression(1).accept(this);
		return new LessEqual(left, right);
	}

	@Override
	public Node visitLiteralId(LiteralIdContext ctx) {
		return new Identifier(ctx.Identifier().getText());
	}
	
	@Override
	public Node visitLiteralInt(LiteralIntContext ctx) {
		System.out.println("IntLiteral" + ctx.getText());
		return new IntLiteral(Integer.parseInt(ctx.getText()));
	}

	@Override
	public Node visitLiteralBool(LiteralBoolContext ctx) {
		return ctx.BooleanLiteral().accept(this);
	}
	
	@Override
	public Node visitLiteralStr(LiteralStrContext ctx) {
		return new StrLiteral(ctx.StringLiteral().getText());
	}
	
	@Override
	public Node visitExprParentheses(ExprParenthesesContext ctx) {
		System.out.println("Parenthese");
		return new Parenthese((Expression) ctx.expression().accept(this));
	}

}
