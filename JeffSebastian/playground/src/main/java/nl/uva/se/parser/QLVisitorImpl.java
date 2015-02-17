package nl.uva.se.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.LogicalOperators.And;
import nl.uva.se.ast.expression.LogicalOperators.Equal;
import nl.uva.se.ast.expression.LogicalOperators.GreaterOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.GreaterThen;
import nl.uva.se.ast.expression.LogicalOperators.LessOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.LessThen;
import nl.uva.se.ast.expression.LogicalOperators.NotEqual;
import nl.uva.se.ast.expression.LogicalOperators.Or;
import nl.uva.se.ast.expression.MathematicalOperators.Divide;
import nl.uva.se.ast.expression.MathematicalOperators.Modulo;
import nl.uva.se.ast.expression.MathematicalOperators.Multiply;
import nl.uva.se.ast.expression.MathematicalOperators.Power;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.literal.BooleanLiteral;
import nl.uva.se.ast.literal.DecimalLiteral;
import nl.uva.se.ast.literal.IntegerLiteral;
import nl.uva.se.ast.literal.StringLiteral;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;
import nl.uva.se.ast.statement.Statement;
import nl.uva.se.constant.Operator;
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

		if (type == null) {
			throw new IllegalArgumentException("Type " + ctx.Type().getText() + " not supported!");
		}
		
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
		if (ctx.op == null) {
			return visitLiteral(ctx.singleLtr);
		}
		
		Operator operator = Operator.getByName(ctx.op.getText());
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		
		if (ctx.singleLtr != null) {
			
		}
		
		if (operator == null) {
			throw new IllegalArgumentException("Operator " + ctx.op.getText() + " not supported!");
		}
		
		switch (operator) {
			case AND:
				return new And(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case DIVIDE:
				return new Divide(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case EQUAL:
				return new Equal(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case GREATER_OR_EQUAL:
				return new GreaterOrEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case GREATER_THAN:
				return new GreaterThen(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case LESS_OR_EQUAL:
				return new LessOrEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case LESS_THEN:
				return new LessThen(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case MINUS:
				return null;
			case MODULO:
				return new Modulo(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case MULTIPLY:
				return new Multiply(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case NOT:
				return null;
			case NOT_EQUAL:
				return new NotEqual(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case OR:
				return new Or(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
			case PLUS:
				return null;
			case POWER:
				return new Power(lineNumber, offset, (Expression) visitExpression(ctx.left), 
						(Expression) visitExpression(ctx.right));
		}
		
		return super.visitExpression(ctx);
	}

	@Override
	public Node visitLiteral(LiteralContext ctx) {
		int lineNumber = ctx.start.getLine();
		int offset = ctx.start.getCharPositionInLine();
		
		if (ctx.Boolean() != null) {
			return new BooleanLiteral(lineNumber, offset, ctx.getText());
		}
		
		if (ctx.Decimal() != null) {
			return new DecimalLiteral(lineNumber, offset, ctx.getText());
		}
		
		if (ctx.Integer() != null) {
			return new IntegerLiteral(lineNumber, offset, ctx.getText());
		}
		
		return new StringLiteral(lineNumber, offset, ctx.getText());
	}

}