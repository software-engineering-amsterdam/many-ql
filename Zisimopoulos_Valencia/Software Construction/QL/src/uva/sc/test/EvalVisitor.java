package uva.sc.test;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import uva.sc.logic.Node;
import uva.sc.logic.Expression;
import uva.sc.logic.Form;
import uva.sc.logic.If_Statement;
import uva.sc.logic.Literal;
import uva.sc.logic.Question;
import uva.sc.logic.Statement;
import uva.sc.logic.Type;
import uva.sc.logic.binaryExpressions.*;
import uva.sc.logic.unaryExpressions.*;
import uva.sc.parser.GrammarBaseVisitor;
import uva.sc.parser.GrammarParser;

public class EvalVisitor extends GrammarBaseVisitor<Node> {

/*========================== Parsing blocks ============================*/
	
	@Override
	public Form visitForm(GrammarParser.FormContext ctx) {
		List<Statement> statementList = new ArrayList<Statement>();
		for (int i = 0 ; i < ctx.sts.size() ; i++) 
			statementList.add((Statement)visitStat(ctx.sts.get(i)));
		return new Form(ctx.ID().getText(), statementList);
	}
	
	@Override
	public Question visitQuestion(GrammarParser.QuestionContext ctx) {
		String label = ctx.STRING().getText();
		String id = ctx.ID().getText();
		Type type = (Type)this.visit(ctx.type());
		Expression expression = (Expression)this.visit(ctx.expr());
		return new Question (label, id, type, expression);
	}
	
	@Override
	public If_Statement visitIf_stat(GrammarParser.If_statContext ctx) {
		Expression expr = (Expression)this.visit(ctx.expr());
		List<Question> questionList = new ArrayList<Question>();
		for (int i = 0 ; i < ctx.qs.size() ; i++)
			questionList.add((Question)visitQuestion(ctx.qs.get(i)));
		return new If_Statement(expr, questionList);
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
		Node result = null;
		if (ctx.getText().contains("."))
			result = new Literal(Double.valueOf(ctx.getText()));
		else
			result= new Literal(Integer.valueOf(ctx.getText()));
		return result;
	}
	
	@Override
	public Node visitBoolean(GrammarParser.BooleanContext ctx) {
		return new Literal(Boolean.valueOf(ctx.getText()));
	}
	
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
	public Node visitEquality(GrammarParser.EqualityContext ctx) {
		Node result = null;
		Node firstOperand = this.visit(ctx.expr(0));
		Node secondOperand = this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.EQ:
			result = new Equals(firstOperand, secondOperand);
		case GrammarParser.NEQ:
			result = new NotEquals(firstOperand, secondOperand);
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
	public Node visitParenthesis(GrammarParser.ParenthesisContext ctx) { 
		return this.visit(ctx.expr()); 
	}

	/*@Override
	public Addition visitId(GrammarParser.IdContext ctx) {
		Value returnValue = null;
		String id = ctx.ID().getText();
		if (memory.containsKey(id))
			returnValue = memory.get(id); 
		return returnValue;
	}*/
}
