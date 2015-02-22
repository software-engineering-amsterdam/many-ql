package uva.TaxForm.AST.Visitors;

import uva.TaxForm.AST.Node;
import uva.TaxForm.antlr4.TaxFormParser.IfConditionContext;
import uva.TaxForm.antlr4.TaxFormParser.QuestionContext;

public class VisitorCondition {

	//IfConditionContext
	public static void ifVisit(CommonTaxFormVisitor ctfv, IfConditionContext ctx, Node form) {
		
		for ( int i=0; i<ctx.children.size(); i++ ) {
			
			//QuestionContext
			if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.QuestionContext.class)) {
				ctfv.visitQuestion((QuestionContext) ctx.getChild(i), form);
			}
			//IfConditionContext
			else if (ctx.getChild(i).getClass().equals(uva.TaxForm.antlr4.TaxFormParser.IfConditionContext.class)) {
				ctfv.visitIfCondition((IfConditionContext) ctx.getChild(i), form);
			}
		}
	}
}
