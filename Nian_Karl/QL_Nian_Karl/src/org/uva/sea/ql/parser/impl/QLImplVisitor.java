package org.uva.sea.ql.parser.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.uva.sea.ql.AST.Form;
import org.uva.sea.ql.AST.Visitable;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.Operator;
import org.uva.sea.ql.AST.expression.booleanexpression.AndExpression;
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
import org.uva.sea.ql.AST.statement.BlockStatement;
import org.uva.sea.ql.AST.statement.IfStatement;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.parser.antlr.QLBaseVisitor;
import org.uva.sea.ql.parser.antlr.QLParser.BlockContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExpressionContext;
import org.uva.sea.ql.parser.antlr.QLParser.FormContext;
import org.uva.sea.ql.parser.antlr.QLParser.IfStatementContext;
import org.uva.sea.ql.parser.antlr.QLParser.LiteralContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;
import org.uva.sea.ql.parser.antlr.QLParser.StatementContext;

public class QLImplVisitor extends QLBaseVisitor<Visitable> {

	private Form form;

	private QLFactory factory;

	@Override
	public Visitable visitForm(FormContext ctx) {
		if (ctx.block() != null) {
			System.out.println("going into block from form");
			form = new Form((BlockStatement) visitBlock(ctx.block()));
		}
		return form;
	}

	public QLImplVisitor() {
		this.factory = new QLFactory();
		
	}

	@Override
	public Visitable visitQuestion(QuestionContext ctx) {
		QuestionStatement statement = factory.getQuestion(ctx);
		return statement;
	}

	@Override
	public Visitable visitStatement(StatementContext ctx) {
		if (ctx.ifStatement() != null) {
			return visitIfStatement(ctx.ifStatement());
		} else if (ctx.question() != null) {
			return visitQuestion(ctx.question());
		}
		return visitChildren(ctx);
	}

	@Override
	public Visitable visitExpression(ExpressionContext ctx) {
		if (ctx.op != null) {
			Operator operator = factory.getOperator(ctx.op.getText());
			switch (operator) {
			case AND:
				return new AndExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			case OR:
				return new OrExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			case EQUAL_COND:
				return new EqualExpression((Expression) visitExpression(ctx.Left),
						(Expression) visitExpression(ctx.Left));
			case GREATER:
				return new GreaterExpression((Expression) visitExpression(ctx.Left),
						(Expression) visitExpression(ctx.Left));
			case GREAT_EQUAL:
				return new GreaterEqualExpression((Expression) visitExpression(ctx.Left),
						(Expression) visitExpression(ctx.Left));
			case LESS_EQUAL:
				return new LessEqualExpression((Expression) visitExpression(ctx.Left),
						(Expression) visitExpression(ctx.Left));
			case LESS:
				return new LessExpression((Expression) visitExpression(ctx.Left),
						(Expression) visitExpression(ctx.Left));
			case PLUS:
				return new AddExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			case MINUS:
				return new SubExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			case MULTIPLY:
				return new MulExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			case DIVIDE:
				return new DivExpression((Expression) visitExpression(ctx.Left), (Expression) visitExpression(ctx.Left));
			default:
				break;
			}

		} else if (ctx.singleExpr != null) {
			return visitExpression(ctx.singleExpr);
		} else {
			return visitLiteral(ctx.Literal);
		}
		System.out.println("Yolo");
		return super.visitChildren(ctx);
	}

	@Override
	public Visitable visitIfStatement(IfStatementContext ctx) {
		Expression expr = (Expression) visitExpression(ctx.expression());
		BlockStatement block = (BlockStatement) visitBlock(ctx.block());
		return new IfStatement(expr, block);
	}

	@Override
	public Visitable visitBlock(BlockContext ctx) {
		BlockStatement block = new BlockStatement();
		for (StatementContext statementContext : ctx.statement()) {
			if (statementContext.question() != null) {
				block.addStatement((QuestionStatement) visitQuestion(statementContext.question()));
			} else if (statementContext.ifStatement() != null) {
				block.addStatement((IfStatement) visitIfStatement(statementContext.ifStatement()));
			}
		}
		return block;
	}

	@Override
	public Visitable visitLiteral(LiteralContext ctx) {
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
