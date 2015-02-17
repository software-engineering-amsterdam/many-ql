package org.uva.sea.ql.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.factory.QLFactory;
import org.uva.sea.ql.model.expression.Expression;
import org.uva.sea.ql.model.expression.mathexpression.AddExpression;
import org.uva.sea.ql.model.literal.NumberLiteral;
import org.uva.sea.ql.model.statement.IfStatement;
import org.uva.sea.ql.model.statement.Statement;
import org.uva.sea.ql.parser.antlr.QLBaseVisitor;
import org.uva.sea.ql.parser.antlr.QLParser.StatementContext;


public class QLImplVisitor extends QLBaseVisitor<List<Statement>> {

	private List<Statement> statementList; 
	private QLFactory factory;

	
	public QLImplVisitor() {
		this.statementList  = new ArrayList<Statement>();
		this.factory = new QLFactory();
	}
	
	
	@Override
	public List<Statement> visitStatement(StatementContext ctx) {
		System.out.println("This is the statement: "+ctx.getText());
		if (ctx.question() != null) {
			System.out.println("Question");
			statementList.add(factory.getQuestion(ctx.question()));
		}
		if (ctx.ifStatement() != null) {

			String leftString = ctx.ifStatement().expression().expression(0).getText();
			Expression leftExpression = new NumberLiteral(Integer.parseInt(leftString));
			String rightString = ctx.ifStatement().expression().expression(1).getText();
			Expression rightExpression = new NumberLiteral(Integer.parseInt(rightString));
			Expression expr = new AddExpression(leftExpression, rightExpression);
			IfStatement ifstatement = new IfStatement(expr);
			
			System.out.println(ctx.ifStatement().expression().getText());
			// recursiev method to get all the questions + if statements inside the ifstatement.
			System.out.println("Ifstatement");
		}
		return statementList;
	}
	
}
