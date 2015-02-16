package nl.uva.se.visitor;

import nl.uva.se.parser.QLBaseVisitor;
import nl.uva.se.parser.QLParser.FormTypeContext;
import nl.uva.se.parser.QLParser.IfClauseTypeContext;
import nl.uva.se.parser.QLParser.QuestionTypeContext;

public class QLVisitorImpl extends QLBaseVisitor<Object> {
	
	private int i = 1;

	@Override
	public Object visitFormType(FormTypeContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitQuestionType(QuestionTypeContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}

	@Override
	public Object visitIfClauseType(IfClauseTypeContext ctx) {
		System.out.println(i + ": " + ctx.getText());
		i++;
		return visitChildren(ctx);
	}
	
	

}
