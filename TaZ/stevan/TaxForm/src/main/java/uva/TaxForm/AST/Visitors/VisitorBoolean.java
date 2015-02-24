package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.Nodes.NodeForm;
import uva.TaxForm.AST.Nodes.NodeExp.Expression;
import uva.TaxForm.AST.Nodes.NodeExp.Operations.OpBoolean;
import uva.TaxForm.AST.Nodes.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorBoolean {
	
	private Expression<?> exp = new Expression<>();;
	private OpBoolean assign = new OpBoolean();
	
	public VisitorBoolean( Question<?> question ) {
		
		exp = question.getExpression();
		exp.add(assign);
	}

	public void visitAnd( @NotNull TaxFormParser.AndExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("&&");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public void visitOr( @NotNull TaxFormParser.OrExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("||");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public void visitNot( @NotNull TaxFormParser.NotExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		assign.setOperator("!");
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
