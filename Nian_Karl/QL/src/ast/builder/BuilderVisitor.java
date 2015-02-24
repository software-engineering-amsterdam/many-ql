package ast.builder;

import antlr.QLBaseVisitor;
import antlr.QLParser.ExprParenthesesContext;
import antlr.QLParser.ExprPlusContext;
import antlr.QLParser.IntContext;
import ast.Node;
import ast.expression.Expression;
import ast.expression.association.Parenthese;
import ast.expression.binary.Plus;
import ast.expression.literal.IntLiteral;
import ast.visitor.Evaluator;

public class BuilderVisitor extends QLBaseVisitor<Node>{

	@Override
	public Node visitExprPlus(ExprPlusContext ctx) {
		System.out.println("Plus");
//		Expression left = (Expression) ctx.expression(0).accept(this);
//		Expression right = (Expression) ctx.expression(1).accept(this);
		Expression left = (Expression) ctx.expression().get(0).accept(this);
		Expression right = (Expression) ctx.expression().get(1).accept(this);
		Expression result = new Plus(left, right);
		//System.out.println(result.toString());
		System.out.println(left.accept(new Evaluator()).getValue());
		System.out.println(right.accept(new Evaluator()).getValue());
		System.out.println("Result = " + result.accept(new Evaluator()).getValue());
		return result;
	}
	
	@Override
	public Node visitInt(IntContext ctx) {
		System.out.println("IntLiteral" + ctx.getText());
		return new IntLiteral(Integer.parseInt(ctx.getText()));
	}
	
	
	@Override
	public Node visitExprParentheses(ExprParenthesesContext ctx) {
		System.out.println("Parenthese");
		return new Parenthese((Expression) ctx.expression().accept(this));
	}

}
