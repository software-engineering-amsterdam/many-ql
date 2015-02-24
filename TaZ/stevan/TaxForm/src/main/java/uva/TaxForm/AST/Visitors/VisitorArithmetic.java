package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Nodes.NodeForm;
import uva.TaxForm.AST.Nodes.NodeExp.Expression;
import uva.TaxForm.AST.Nodes.NodeExp.Operations.OpArithmetic;
import uva.TaxForm.AST.Nodes.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorArithmetic {
	
	private Expression<?> exp = new Expression<>();;
	private OpArithmetic assign = new OpArithmetic();
	
	public VisitorArithmetic( Question<?> question ) {
		
		exp = question.getExpression();
		exp.add(assign);
	}
	
	public void visitMinus( @NotNull TaxFormParser.MinusExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("-");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}

	public void visitAdd( @NotNull TaxFormParser.AddExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("+");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public void visitMultiply( @NotNull TaxFormParser.MultiplyExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("*");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public void visitDivide( @NotNull TaxFormParser.DivideExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("/");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
