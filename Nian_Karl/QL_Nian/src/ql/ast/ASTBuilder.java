package ql.ast;

import ql.antlr.QLBaseVisitor;
import ql.antlr.QLParser.ExprParenthesesContext;
import ql.antlr.QLParser.ExprPlusContext;
import ql.antlr.QLParser.IntContext;
import ql.antlr.QLParser.QuestionContext;
import ql.ast.expression.Expression;
import ql.ast.expression.Parenthese;
import ql.ast.expression.binary.Plus;
import ql.ast.expression.literal.IntLiteral;
import ql.ast.visitor.Evaluator;

public class ASTBuilder extends QLBaseVisitor<ASTNode>{
		
	
	@Override
	public ASTNode visitExprPlus(ExprPlusContext ctx) {
		System.out.println("PLUS");
		System.out.println(ctx.getText());
		//System.out.println(ctx.expression().size());
		
//		String left = ctx.getChild(0).getText();
//		String right = ctx.getChild(2).getText();
//		Expression l = new IntLiteral(Integer.parseInt(left));
//		Expression r = new IntLiteral(Integer.parseInt(right));	
//		Plus expr = new Plus(l,r);
//		System.out.println("Value" + expr.accept(new Evaluator()).getValue());
		
		Expression l = (Expression) ctx.expression().get(0).accept(this);
		Expression r = (Expression) ctx.expression().get(1).accept(this);
		Plus expr = new Plus(l, r);
		System.out.println("Left" + l.accept(new Evaluator()).getValue());
		System.out.println("Right" + r.accept(new Evaluator()).getValue());
		System.out.println("Value" + expr.accept(new Evaluator()).getValue());
		System.out.println("");
		
		return expr;
	}
	
	@Override
	public Parenthese visitExprParentheses(ExprParenthesesContext ctx) {
		return new Parenthese((Expression) ctx.expression().accept(this));
	}
	
	@Override
	public IntLiteral visitInt(IntContext ctx) {
		// TODO Auto-generated method stub
		return new IntLiteral(Integer.parseInt(ctx.getText()));
	}
	
}
