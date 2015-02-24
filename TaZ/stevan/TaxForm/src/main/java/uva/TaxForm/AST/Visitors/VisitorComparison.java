package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Nodes.NodeForm;
import uva.TaxForm.AST.Nodes.NodeExp.Expression;
import uva.TaxForm.AST.Nodes.NodeExp.Operations.OpComparison;
import uva.TaxForm.AST.Nodes.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorComparison {
	
	private Expression<?> exp = new Expression<>();;
	private OpComparison assign = new OpComparison();
	
	public VisitorComparison( Question<?> question ) {
		
		exp = question.getExpression();
		exp.add(assign);
	}
	
	//Lower
	public void visitLower( @NotNull TaxFormParser.LowerExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("<");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//Upper
	public void visitUpper( @NotNull TaxFormParser.UpperExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator(">");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//LowerEqual
	public void visitLowerEqual( @NotNull TaxFormParser.LowerEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("<=");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//UpperEqual
	public void visitUpperEqual( @NotNull TaxFormParser.UpperEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator(">=");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//Equal
	public void visitEqual( @NotNull TaxFormParser.EqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("==");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	//NotEqual
	public void visitNotEqual( @NotNull TaxFormParser.NotEqualExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("!=");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
