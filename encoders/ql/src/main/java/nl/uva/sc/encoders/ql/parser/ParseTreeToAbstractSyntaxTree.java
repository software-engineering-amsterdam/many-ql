package nl.uva.sc.encoders.ql.parser;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.EncodersQLBaseVisitor;
import nl.uva.sc.encoders.ql.EncodersQLParser.AddSubContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.AndContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.BracedExpressionContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.ConditionalBlockContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.ExpressionContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.LiteralExpressionContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.LtGtLeGeContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.MulDivContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.NameExpressionContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.NeEqContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.NotContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.OrContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.QuestionContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.QuestionnaireContext;
import nl.uva.sc.encoders.ql.EncodersQLParser.StatementContext;
import nl.uva.sc.encoders.ql.ast.AstNode;
import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.BinaryExpression;
import nl.uva.sc.encoders.ql.ast.expression.BracedExpression;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.LiteralExpression;
import nl.uva.sc.encoders.ql.ast.expression.NameExpression;
import nl.uva.sc.encoders.ql.ast.expression.UnaryExpression;
import nl.uva.sc.encoders.ql.ast.literal.Literal;
import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.operator.BinaryOperator;
import nl.uva.sc.encoders.ql.ast.operator.DivideOperator;
import nl.uva.sc.encoders.ql.ast.operator.EqualsOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.MultiplyOperator;
import nl.uva.sc.encoders.ql.ast.operator.NotEqualsOperator;
import nl.uva.sc.encoders.ql.ast.operator.NotOperator;
import nl.uva.sc.encoders.ql.ast.operator.OrOperator;
import nl.uva.sc.encoders.ql.ast.operator.SubstractOperator;
import nl.uva.sc.encoders.ql.ast.operator.UnaryOperator;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.ast.type.DataType;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ParseTreeToAbstractSyntaxTree extends EncodersQLBaseVisitor<AstNode> {

	private static final String ESCAPED_QUOTE = "\\\\\"";
	private static final String UNESCAPED_QUOTE = "\\\"";

	@Override
	public Questionnaire visitQuestionnaire(QuestionnaireContext ctx) {
		String name = ctx.name.getText();

		List<Statement> statements = new ArrayList<>();
		for (StatementContext statementContext : ctx.statement()) {
			Statement statement = (Statement) statementContext.accept(this);
			statements.add(statement);
		}

		TextLocation textLocation = getTextLocation(ctx);
		Questionnaire questionnaire = new Questionnaire(textLocation, name, statements);
		return questionnaire;
	}

	@Override
	public ConditionalBlock visitConditionalBlock(ConditionalBlockContext ctx) {
		Expression condition = (Expression) visit(ctx.expression());
		List<Question> questions = new ArrayList<>();
		for (QuestionContext questionContext : ctx.question()) {
			Question question = (Question) visit(questionContext);
			questions.add(question);
		}
		TextLocation textLocation = getTextLocation(ctx);
		ConditionalBlock cb = new ConditionalBlock(textLocation, condition, questions);
		return cb;
	}

	@Override
	public Question visitQuestion(QuestionContext ctx) {
		String questionName = ctx.name.getText();
		DataType dataType = ctx.type.accept(new TypeParser());
		String questionLabel = ctx.label.getText();
		questionLabel = removeFirstAndListCharOfString(questionLabel);
		questionLabel = unescapedString(questionLabel);

		Expression computed = null;
		TextLocation textLocation = getTextLocation(ctx);
		ExpressionContext computedCtx = ctx.computed;
		if (computedCtx != null) {
			computed = (Expression) visit(computedCtx);
		}
		Question question = new Question(textLocation, questionName, dataType, questionLabel, computed);
		return question;
	}

	private String removeFirstAndListCharOfString(String string) {
		return string.substring(1, string.length() - 1);
	}

	private String unescapedString(String escapedString) {
		return escapedString.replaceAll(ESCAPED_QUOTE, UNESCAPED_QUOTE);
	}

	@Override
	public BracedExpression visitBracedExpression(BracedExpressionContext ctx) {
		Expression expression = (Expression) visit(ctx.expression());
		TextLocation textLocation = getTextLocation(ctx);
		return new BracedExpression(textLocation, expression);
	}

	@Override
	public NameExpression visitNameExpression(NameExpressionContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		String text = ctx.name.getText();
		return new NameExpression(textLocation, text);
	}

	@Override
	public BinaryExpression visitNeEq(NeEqContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public BinaryExpression visitMulDiv(MulDivContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public BinaryExpression visitLtGtLeGe(LtGtLeGeContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public BinaryExpression visitOr(OrContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public BinaryExpression visitAddSub(AddSubContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public BinaryExpression visitAnd(AndContext ctx) {
		String operator = ctx.operator.getText();
		BinaryOperator binaryOperator = getBinaryOperator(operator);
		Expression leftHand = (Expression) visit(ctx.leftHand);
		Expression rightHand = (Expression) visit(ctx.rightHand);
		TextLocation textLocation = getTextLocation(ctx);
		return new BinaryExpression(textLocation, leftHand, rightHand, binaryOperator);
	}

	@Override
	public UnaryExpression visitNot(NotContext ctx) {
		String operator = ctx.operator.getText();
		UnaryOperator unaryOperator = getUnaryOperator(operator);
		Expression expression = (Expression) visit(ctx.expr);
		TextLocation textLocation = getTextLocation(ctx);
		return new UnaryExpression(textLocation, unaryOperator, expression);
	}

	@Override
	public LiteralExpression visitLiteralExpression(LiteralExpressionContext ctx) {
		TextLocation textLocation = getTextLocation(ctx);
		Literal literal = ctx.literal().accept(new LiteralParser());
		return new LiteralExpression(textLocation, literal);
	}

	private TextLocation getTextLocation(ParserRuleContext ctx) {
		Token start = ctx.getStart();
		int line = start.getLine();
		int column = start.getCharPositionInLine();
		return new TextLocation(line, column);
	}

	private BinaryOperator getBinaryOperator(String operator) {
		switch (operator) {
		case "*":
			return new MultiplyOperator(operator);
		case "/":
			return new DivideOperator(operator);
		case "+":
			return new AddOperator(operator);
		case "-":
			return new SubstractOperator(operator);
		case "&&":
			return new AndOperator(operator);
		case "||":
			return new OrOperator(operator);
		case "<":
			return new LessThanOperator(operator);
		case ">":
			return new GreaterThanOperator(operator);
		case "<=":
			return new LessOrEqualOperator(operator);
		case ">=":
			return new GreaterOrEqualOperator(operator);
		case "!=":
			return new NotEqualsOperator(operator);
		case "==":
			return new EqualsOperator(operator);
		default:
			throw new AssertionError("Operator " + operator + " is not suppoerted.");
		}
	}

	private UnaryOperator getUnaryOperator(String operator) {
		switch (operator) {
		case "!":
			return new NotOperator(operator);
		default:
			throw new AssertionError("Operator " + operator + " is not suppoerted.");
		}
	}
}
