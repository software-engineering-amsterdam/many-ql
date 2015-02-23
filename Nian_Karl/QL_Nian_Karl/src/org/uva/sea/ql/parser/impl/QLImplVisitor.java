package org.uva.sea.ql.parser.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.uva.sea.ql.AST.Node;
import org.uva.sea.ql.AST.QuestionType;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.booleanexpression.EqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.GreaterEqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.GreaterExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.LessEqualExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.LessExpression;
import org.uva.sea.ql.AST.expression.booleanexpression.OrExpression;
import org.uva.sea.ql.AST.expression.mathexpression.AddExpression;
import org.uva.sea.ql.AST.expression.mathexpression.DivExpression;
import org.uva.sea.ql.AST.expression.mathexpression.MulExpression;
import org.uva.sea.ql.AST.expression.mathexpression.SubExpression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.literal.DateLiteral;
import org.uva.sea.ql.AST.literal.DecimalLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.literal.StringLitereal;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.parser.antlr.QLBaseVisitor;
import org.uva.sea.ql.parser.antlr.QLParser.ExprAndContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprDivideContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprEqContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprGreaterContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprGreaterEqualContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprLessContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprLessEqualContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprMinusContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprMultiplyContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprNegContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprNotContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprOrContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprParenthesesContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExprPlusContext;
import org.uva.sea.ql.parser.antlr.QLParser.IfStatementContext;
import org.uva.sea.ql.parser.antlr.QLParser.LiteralContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;

public class QLImplVisitor extends QLBaseVisitor<Node> {

	private QLFactory factory;

	public QLImplVisitor() {
		this.factory = new QLFactory();
	}

	@Override
	public Node visitExprDivide(ExprDivideContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new DivExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprGreater(ExprGreaterContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new GreaterExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprMultiply(ExprMultiplyContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new MulExpression(left, right);
		return result;

	}

	@Override
	public Node visitExprGreaterEqual(ExprGreaterEqualContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new GreaterEqualExpression(left, right);
		return result;

	}

	@Override
	public Node visitExprMinus(ExprMinusContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new SubExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprEq(ExprEqContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new EqualExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprLessEqual(ExprLessEqualContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new LessEqualExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprLess(ExprLessContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new LessExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprNeg(ExprNegContext ctx) {
		return super.visitExprNeg(ctx);
	}

	@Override
	public Node visitExprNot(ExprNotContext ctx) {
		return super.visitExprNot(ctx);
	}

	
	
	@Override
	public Node visitExprOr(ExprOrContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new OrExpression(left, right);
		return result;
		}

	@Override
	public Node visitExprPlus(ExprPlusContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new AddExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprAnd(ExprAndContext ctx) {
		Expression left = (Expression) ctx.Left.accept(this);
		Expression right = (Expression) ctx.Right.accept(this);
		Expression result = new AddExpression(left, right);
		return result;
	}

	@Override
	public Node visitExprParentheses(ExprParenthesesContext ctx) {
		Expression expr = (Expression) ctx.singleExpr.accept(this);
		return expr;
	}

	@Override
	public Node visitIfStatement(IfStatementContext ctx) {
		// ExpressionContext expressionContext = ctx.expression();
		// Expression expr = (Expression) visitExpression(expressionContext);
		// IfStatement statement = new IfStatement(expr);
		// System.out.println(expr.interpretExpression().getValue());
		return null;
	}

	@Override
	public Node visitQuestion(QuestionContext ctx) {
		String questionLabel = ctx.questionLabel().getText();
		String identifier = ctx.questionName().getText();
		QuestionType questionType = factory.getQuestionType(ctx.questionType()
				.getText());
		QuestionStatement question = new QuestionStatement(questionType,
				identifier, questionLabel);
		return question;
	}

	@Override
	public Node visitLiteral(LiteralContext ctx) {
		if (ctx.IntegerLiteral() != null) {
			return new NumberLiteral(Integer.parseInt(ctx.getText()));

		} else if (ctx.DecimalLiteral() != null) {
			return new DecimalLiteral(Double.parseDouble(ctx.getText()));

		} else if (ctx.BooleanLiteral() != null) {
			return new BooleanLiteral(factory.stringToBoolean(ctx.getText()));

		} else if (ctx.StringLiteral() != null) {
			return new StringLitereal(ctx.getText());

		} else if (ctx.DateLiteral() != null) {
			String dateString = ctx.getText();
			// need to reconsider this
			SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
			Date date = null;
			try {
				date = format.parse(dateString);
			} catch (ParseException e) {
				// input was wrong
				e.printStackTrace();
			}
			if (date != null) {
				return new DateLiteral(date);
			} else {
				return new DateLiteral(new Date());
			}
		}
		return super.visitLiteral(ctx);
	}
}
