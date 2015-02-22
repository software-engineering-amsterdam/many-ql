package uva.TaxForm.AST.Visitors;

import org.antlr.v4.runtime.misc.NotNull;

import uva.TaxForm.AST.NodeForm;
import uva.TaxForm.AST.NodeExp.Expression;
import uva.TaxForm.AST.NodeExp.Operations.OpBoolean;
import uva.TaxForm.AST.NodeQuestion.Question;
import uva.TaxForm.antlr4.TaxFormParser;
import uva.TaxForm.antlr4.TaxFormParser.AllMightyContext;

public class VisitorBoolean {

	public static void visitAnd( @NotNull TaxFormParser.AndExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		Expression<?> exp = question.getExpression();
		OpBoolean assign = new OpBoolean();
		exp.add(assign);
		assign.setOperator("&&");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public static void visitOr( @NotNull TaxFormParser.OrExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		Expression<?> exp = question.getExpression();
		OpBoolean assign = new OpBoolean();
		exp.add(assign);
		assign.setOperator("||");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
	
	public static void visitNot( @NotNull TaxFormParser.NotExpressionContext ctx, Question<?> question, NodeForm form ) {
		
		Expression<?> exp = question.getExpression();
		OpBoolean assign = new OpBoolean();
		exp.add(assign);
		assign.setOperator("!");
		
		CommonTaxFormVisitor.visitAllMighty((AllMightyContext) ctx.allMighty(), question, form);
	}
}
