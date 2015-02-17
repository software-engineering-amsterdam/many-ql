package nl.uva.se.parser;

import nl.uva.se.parser.QLParser.ConditionContext;
import nl.uva.se.parser.QLParser.ExpressionContext;
import nl.uva.se.parser.QLParser.FormContext;
import nl.uva.se.parser.QLParser.QuestionContext;


public class QLVisitorImpl extends QLBaseVisitor<Object> {

	@Override
	public Object visitForm(FormContext ctx) {
		System.out.println("Form: " + ctx.getText());
		return super.visitForm(ctx);
	}

	@Override
	public Object visitQuestion(QuestionContext ctx) {
		System.out.println("Question: " + ctx.getText());
		return super.visitQuestion(ctx);
	}

	@Override
	public Object visitCondition(ConditionContext ctx) {
		System.out.println("Condition: " + ctx.getText());
		return super.visitCondition(ctx);
	}

	@Override
	public Object visitExpression(ExpressionContext ctx) {
		System.out.println("Expression: " + ctx.getText());
		return super.visitExpression(ctx);
	}

}
