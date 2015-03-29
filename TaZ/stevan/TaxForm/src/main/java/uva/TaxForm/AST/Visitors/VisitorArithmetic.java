package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeExp.Expression;
import uva.TaxForm.AST.NodeExp.Operations.OpArithmetic;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorArithmetic {
	
	private static Expression<?> exp = new Expression<>();;
	private static OpArithmetic assign = new OpArithmetic();
	
	private static void init( Question<?> question ) {
		
		exp = question.getExpression();
		exp.add(assign);
	}
	
	public static void visitMinus( @NotNull TaxFormParser.MinusExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("-");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}

	public static void visitAdd( @NotNull TaxFormParser.AddExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("+");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public static void visitMultiply( @NotNull TaxFormParser.MultiplyExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("*");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public static void visitDivide( @NotNull TaxFormParser.DivideExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("/");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
