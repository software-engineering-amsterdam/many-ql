package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeExp.Expression;
import uva.TaxForm.AST.NodeExp.Operations.OpComparison;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorComparison<T> {
	
	private static Expression<?> exp = new Expression<>();;
	private static OpComparison assign = new OpComparison();
	
	private static void init( Question<?> question ) {
		
		exp = question.getExpression();
		exp.add(assign);
	}
	
	//Lower
	public static void visitLower( @NotNull TaxFormParser.LowerExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("<");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//Upper
	public static void visitUpper( @NotNull TaxFormParser.UpperExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator(">");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//LowerEqual
	public static void visitLowerEqual( @NotNull TaxFormParser.LowerEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("<=");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//UpperEqual
	public static void visitUpperEqual( @NotNull TaxFormParser.UpperEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator(">=");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//Equal
	public static void visitEqual( @NotNull TaxFormParser.EqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("==");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//NotEqual
	public static void visitNotEqual( @NotNull TaxFormParser.NotEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		init(question);
		assign.setOperator("!=");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
