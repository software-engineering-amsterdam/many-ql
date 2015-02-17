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
import uva.sc.logic.binaryExpressions.Addition;
import uva.sc.logic.binaryExpressions.Power;
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
	
	@Override
	public Node visitPower(GrammarParser.PowerContext ctx) {
		Node base = this.visit(ctx.expr(0));
		Node exponent = this.visit(ctx.expr(1));
		return new Power(base, exponent);
	}
	
/*----------------------------------------------------------*/
	
	
	
	
	
	
	@Override
	public Addition visitAdditive(GrammarParser.AdditiveContext ctx) {
		Value firstOperand = this.visit(ctx.expr(0));
		Value secondOperand = this.visit(ctx.expr(1));
		NodeTree<String> tree = new NodeTree<String>(new String("+"));
		tree.addChild(firstOperand);
		tree.addChild(secondOperand);
		return null;
	}
	
	@Override 
	public Question visitQuestion(GrammarParser.QuestionContext ctx) {
		return new Question(ctx.STRING(), ctx.ID(), visitType(ctx.type()), visit ctx.expr());
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
	public Value visitMultiplication(@NotNull GrammarParser.MultiplicationContext ctx) {
		Value firstOperand = this.visit(ctx.expr(0));
		Value secondOperand = this.visit(ctx.expr(1));
		Value returnValue = null;
		switch (ctx.op.getType()) {
			case GrammarParser.MULT:
				returnValue = new Value(firstOperand.asDouble() * secondOperand.asDouble());
			case GrammarParser.DIV:
				returnValue = new Value(firstOperand.asDouble() / secondOperand.asDouble());
			case GrammarParser.MOD:
				returnValue = new Value(firstOperand.asDouble() % secondOperand.asDouble());
			default:
		}
		return returnValue;
	}
	
	@Override
	public Value visitAnd(GrammarParser.AndContext ctx) {
		Value firstExpression = this.visit(ctx.expr(0));
		Value secondExpression = this.visit(ctx.expr(1));
		return new Value(firstExpression.asBoolean() && secondExpression.asBoolean());
	}
	
	@Override
	public Value visitOr(GrammarParser.OrContext ctx) {
		Value firstExpression = this.visit(ctx.expr(0));
		Value secondExpression = this.visit(ctx.expr(1));
		return new Value(firstExpression.asBoolean() || secondExpression.asBoolean());
	}
	
	@Override
	public Value visitIf_stat(GrammarParser.If_statContext ctx) {
		List<GrammarParser.ExprContext> expressions = ctx.expr();
		boolean result = false;
		for (GrammarParser.ExprContext expression : expressions) {
			
		}
	}
}
