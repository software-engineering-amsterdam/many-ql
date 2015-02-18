package uva.sc.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;

import uva.sc.logic.Node;
import uva.sc.ast.NodeTree;
import uva.sc.logic.Form;
import uva.sc.logic.Literal;
import uva.sc.logic.Question;
import uva.sc.logic.Statement;
import uva.sc.logic.binaryExpressions.*;
import uva.sc.logic.unaryExpressions.*;
import uva.sc.parser.GrammarBaseVisitor;
import uva.sc.parser.GrammarParser;
import uva.sc.parser.GrammarParser.StatContext;

public class EvalVisitor extends GrammarBaseVisitor<Node> {
	
	@Override
	public Form visitForm(GrammarParser.FormContext ctx) {
		List<Statement> statementList = new ArrayList<Statement>();
		for (int i = 0 ; i < ctx.sts.size() ; i++) 
			statementList.add((Statement)visitStat(ctx.sts.get(i)));
		return new Form(ctx.ID().getText(), statementList);
	}

	
/*============================ Literals ================================*/

	@Override
	public Node visitString(GrammarParser.StringContext ctx) {
		String str = ctx.getText();
		str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
		return new Literal(str);
	}
	
	@Override
	public Node visitNumber(GrammarParser.NumberContext ctx) {
		return new Literal(Double.valueOf(ctx.getText()));
	}
	
	@Override
	public Node visitBoolean(GrammarParser.BooleanContext ctx) {
		return new Literal(Boolean.valueOf(ctx.getText()));
	}
	
/*======================================================================*/


	
/*======================== Expressions =================================*/
	@Override
	public Node visitPower(GrammarParser.PowerContext ctx) {
		Node firstOperand = this.visit(ctx.expr(0));
		Node secondOperand = this.visit(ctx.expr(1));
		return new Power(firstOperand, secondOperand);
	}
	
	@Override
	public Minus visitUnaryMinus(GrammarParser.UnaryMinusContext ctx) {
		return new Minus(this.visit(ctx.expr()));		
	}
	
	@Override
	public Not visitNot(GrammarParser.NotContext ctx) {
		return new Not(this.visit(ctx.expr()));	
	}
	@Override
	public Node visitMultiplication(@NotNull GrammarParser.MultiplicationContext ctx) {
		Node result = null;
		Node firstOperand = this.visit(ctx.expr(0));
		Node secondOperand = this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.MULT:
			result = new Multiplication(firstOperand, secondOperand);
		case GrammarParser.DIV:
			result = new Division(firstOperand, secondOperand);
		case GrammarParser.MOD:
			result = new Modulus(firstOperand, secondOperand);
		}
		return result;
	}
	
	@Override
	public Node visitAdditive(@NotNull GrammarParser.AdditiveContext ctx) {
		Node result = null;
		Node firstOperand = this.visit(ctx.expr(0));
		Node secondOperand = this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.ADD:
			result = new Addition(firstOperand, secondOperand);
		case GrammarParser.SUB:
			result = new Substraction(firstOperand, secondOperand);
		}
		return result;
	}
	
	@Override
	public Node visitRelational(GrammarParser.RelationalContext ctx) {
		Node result = null;
		Node firstOperand = this.visit(ctx.expr(0));
		Node secondOperand = this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.LTE:
			result = new LesserThanEquals(firstOperand, secondOperand);
		case GrammarParser.GTE:
			result = new GreaterThanEquals(firstOperand, secondOperand);
		case GrammarParser.LT:
			result = new LesserThan(firstOperand, secondOperand);
		case GrammarParser.GT:
			result = new GreaterThan(firstOperand, secondOperand);
		}
		return result;
	}
	
	@Override
	public And visitAnd(GrammarParser.AndContext ctx) {
		Node firstExpression = this.visit(ctx.expr(0));
		Node secondExpression = this.visit(ctx.expr(1));
		return new And(firstExpression, secondExpression);
	}
	
	@Override
	public Or visitOr(GrammarParser.OrContext ctx) {
		Node firstExpression = this.visit(ctx.expr(0));
		Node secondExpression = this.visit(ctx.expr(1));
		return new Or(firstExpression, secondExpression);
	}

	@Override
	public Addition visitId(GrammarParser.IdContext ctx) {
		Value returnValue = null;
		String id = ctx.ID().getText();
		if (memory.containsKey(id))
			returnValue = memory.get(id); 
		return returnValue;
	}
	
	@Override 
	public Node visitQuestion(GrammarParser.QuestionContext ctx) {
		return new Question (ctx.STRING(), ctx.ID(), this.visit(ctx.type()), visitChildren(ctx));
		//return visitChildren(ctx);
	}
}
