package nl.uva.se.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.statement.Statement;
import nl.uva.se.constant.Type;
import nl.uva.se.parser.QLParser.ConditionContext;
import nl.uva.se.parser.QLParser.ExpressionContext;
import nl.uva.se.parser.QLParser.FormContext;
import nl.uva.se.parser.QLParser.LiteralContext;
import nl.uva.se.parser.QLParser.QuestionContext;
import nl.uva.se.parser.QLParser.StatementContext;

public class QLVisitorImpl extends QLBaseVisitor<Node> {

	@Override
	public Node visitForm(FormContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		String id = ctx.Identifier().getText();
		List<StatementContext> contexts = ctx.statement();
		List<Statement> statements = new ArrayList<Statement>();

		for (StatementContext context : contexts) {
			statements.add((Statement) visitStatement(context));
		}

		Form form = new Form(id, lineNumber, offset, statements);
		return form;
	}

	@Override
	public Node visitQuestion(QuestionContext ctx) {
		Type type = Type.getByName(ctx.Type().getText());
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		String id = ctx.Identifier().getText();
		String question = ctx.String().getText();

		if (ctx.expression() != null) {
			return new CalculatedQuestion(lineNumber, offset, id, type,
					question, (Expression) visitExpression(ctx.expression()));
		}

		return new Question(lineNumber, offset, id, type, question);
	}

	@Override
	public Node visitCondition(ConditionContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();

		return new Condition(lineNumber, offset,
				(Expression) visitExpression(ctx.expression()));
	}

	@Override
	public Node visitStatement(StatementContext ctx) {
		if (ctx.question() != null) {
			return visitQuestion(ctx.question());
		}
		return visitCondition(ctx.condition());
	}

	@Override
	public Node visitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Node visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLiteral(ctx);
	}

}