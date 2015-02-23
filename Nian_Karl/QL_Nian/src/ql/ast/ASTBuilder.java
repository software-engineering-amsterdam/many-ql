package ql.ast;

import java.util.ArrayList;

import ql.antlr.QLBaseVisitor;
import ql.antlr.QLParser.ExprParenthesesContext;
import ql.antlr.QLParser.ExprPlusContext;
import ql.antlr.QLParser.IntContext;
import ql.ast.expression.Expression;
import ql.ast.expression.binary.Plus;
import ql.ast.expression.literal.IntLiteral;

public class ASTBuilder extends QLBaseVisitor<ArrayList<Expression>>{
	
	private ArrayList<Expression> exprs;
	
	public ASTBuilder(){
		this.exprs = new ArrayList<Expression>();
		
	}
	
	@Override
	public ArrayList<Expression> visitExprPlus(ExprPlusContext ctx) {
		System.out.println("Plus");
		System.out.println(ctx.getText());
		
		Expression left = new IntLiteral(Integer.parseInt(ctx.getChild(0).getText()));
		System.out.println(left.evaluate().getValue());
		Expression right = new IntLiteral(Integer.parseInt(ctx.getChild(2).getText()));
		System.out.println(right.evaluate().getValue());
		
		Expression plus = new Plus(left, right);
		System.out.println("Result = " + plus.evaluate().getValue());
		
		this.exprs.add(new Plus(left, right));
		System.out.println(exprs.size());
		return this.exprs;
	}
	
	@Override
	public ArrayList<Expression> visitExprParentheses(ExprParenthesesContext ctx) {
		System.out.println("Paren");
		return super.visitExprParentheses(ctx);
	}
	
	@Override
	public ArrayList<Expression> visitInt(IntContext ctx) {
		return super.visitInt(ctx);
	}
	
}
