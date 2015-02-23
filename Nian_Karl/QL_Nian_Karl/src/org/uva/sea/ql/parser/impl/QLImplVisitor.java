package org.uva.sea.ql.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.booleanexpression.AndExpression;
import org.uva.sea.ql.AST.expression.mathexpression.AddExpression;
import org.uva.sea.ql.AST.literal.BooleanLiteral;
import org.uva.sea.ql.AST.literal.NumberLiteral;
import org.uva.sea.ql.AST.statement.Statement;
import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.parser.antlr.QLBaseVisitor;
import org.uva.sea.ql.parser.antlr.QLParser.ExprAndContext;
import org.uva.sea.ql.parser.antlr.QLParser.ExpressionContext;
import org.uva.sea.ql.parser.antlr.QLParser.StatementContext;

public class QLImplVisitor extends QLBaseVisitor<List<Statement>> {

	private List<Statement> statementList;
	private QLFactory factory;

	public QLImplVisitor() {
		this.statementList = new ArrayList<Statement>();
		this.factory = new QLFactory();
	}
	

	@Override
	public List<Statement> visitStatement(StatementContext ctx) {
		if (ctx.question() != null) {
			statementList.add(factory.getQuestion(ctx.question()));
		}
		if (ctx.ifStatement() != null) {
			// Nian: Try to parse these crazy expressions like:
			// "if((100 > 5) && ((5+6) < 10))"
			// and get a boolean out of it.
			ExpressionContext exp = ctx.ifStatement().expression();
			
			System.out.println(exp.children);
			String leftString = ctx.ifStatement().expression().getChild(0).getText();
			String rightString = ctx.ifStatement().expression().getChild(2).getText();
			System.out.println(leftString);
			System.out.println(rightString);
//			Expression leftExpression = new NumberLiteral(
//					Integer.parseInt(leftString));
//
//			Expression rightExpression = new NumberLiteral(
//					Integer.parseInt(rightString));
//
//			Expression expr = new AddExpression(leftExpression, rightExpression);
			Expression left = new BooleanLiteral(stringToBoolean(leftString));
			System.out.println("??" +stringToBoolean(leftString));
			Expression right = new BooleanLiteral(stringToBoolean(rightString));
			Expression expr = new AndExpression(left, right);
			System.out.println(expr.interpretExpression().getValue());
			System.out.println("test");
			System.out.println((false && false));
//			IfStatement statement = new IfStatement(expr);
//			for (int i = 0; i < ctx.ifStatement().block().size(); i++) {
//				List<Statement> statements2 = visitStatement(ctx.ifStatement()
//						.block().get(i).statement(i));
//				for (int j = 0; j < statements2.size(); j++) {
//					if (statements2.get(i).getClass() == QuestionStatement.class) {
//
//					}
//				}
//			}
//			statementList.add(statement);
			// Recursive method to get all the questions + if statements inside
			// the ifstatement.
		}
		return statementList;
	}
	
	@Override
	public List<Statement> visitExprAnd(ExprAndContext ctx) {
		System.out.println("Some strange behavior here.");
		System.out.println("And" + ctx.getText());
		return super.visitExprAnd(ctx);
	}
	
	public boolean stringToBoolean(String s){
		if (s.equals( "true")){
			return true;
		} else {
			return false;
		}
	}
}
