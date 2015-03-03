package uva.sc.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import uva.sc.ast.INode;
import uva.sc.atom.BooleanAtom;
import uva.sc.atom.ID;
import uva.sc.atom.NumberAtom;
import uva.sc.atom.StringAtom;
import uva.sc.gui.GUIVisitor;
import uva.sc.logic.Expression;
import uva.sc.logic.Form;
import uva.sc.logic.If_Statement;
import uva.sc.logic.Question;
import uva.sc.logic.Statement;
import uva.sc.logic.binaryExpressions.*;
import uva.sc.logic.unaryExpressions.*;
import uva.sc.types.Type;
import uva.sc.types.Unidentified;

public class QLVisitor extends GrammarBaseVisitor<INode> {

	private static QLVisitor instance = null;
	
	public static QLVisitor getInstance() {
		if (instance == null) {
			instance = new QLVisitor();
		}
		return instance;
	}
	
/*========================== Parsing blocks ============================*/
	
	public Form visitForm(@NotNull GrammarParser.FormContext ctx) {
		List<Statement> statementList = new ArrayList<Statement>();
		for (int i = 0 ; i < ctx.sts.size() ; i++)
			statementList.add((Statement)visitStat(ctx.sts.get(i)));
		return new Form(new ID(ctx.ID().getText()), statementList);
	}
	
	public Question visitQuestion(@NotNull GrammarParser.QuestionContext ctx) {
		String label = ctx.STRING().getText();
		ID id = new ID(ctx.ID().getText());
		Type type = (Type)(visitType(ctx.type()));
		if (ctx.expr() != null) {
			Expression expression = (Expression)this.visit(ctx.expr());
			return new Question (label, id, type, expression);
		}
		else
			return new Question (label, id, type);
	}
	
	public If_Statement visitIf_stat(@NotNull GrammarParser.If_statContext ctx) {
		Expression expr = (Expression)this.visit(ctx.expr());
		List<Question> questionList = new ArrayList<Question>();
		for (int i = 0 ; i < ctx.qs.size() ; i++)
			questionList.add((Question)visitQuestion(ctx.qs.get(i)));
		return new If_Statement(expr, questionList);
	}
	 
	public Type visitType(@NotNull GrammarParser.TypeContext ctx) { 
		String type = ctx.getText();
		Type result = new Unidentified();
		switch (type){
			case "boolean": 
				result = new uva.sc.types.Boolean(); 
				break;
			case "number" : 
				result = new uva.sc.types.Number(); 	
				break;
			case "string" : 
				result = new uva.sc.types.String(); 
				break;
		}
		return result;
	}

/*============================ Literals ================================*/

	public INode visitString(@NotNull GrammarParser.StringContext ctx) {
		String str = ctx.getText();
		str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
		return new StringAtom(str);
	}
	
	public INode visitNumber(@NotNull GrammarParser.NumberContext ctx) {
		INode result = null;
		if (ctx.getText().contains("."))
			result = new NumberAtom(ctx.getText());
		else
			result= new NumberAtom(ctx.getText());
		return result;
	}
	
	public INode visitBoolean(GrammarParser.BooleanContext ctx) {
		return new BooleanAtom(Boolean.valueOf(ctx.getText()));
	}
	
/*======================== Expressions =================================*/
	public INode visitPower(@NotNull GrammarParser.PowerContext ctx) {
		Expression firstOperand = (Expression)this.visit(ctx.expr(0));
		Expression secondOperand = (Expression)this.visit(ctx.expr(1));
		return new Power(firstOperand, secondOperand);
	}
	
	public Minus visitUnaryMinus(@NotNull GrammarParser.UnaryMinusContext ctx) {
		return new Minus((Expression)this.visit(ctx.expr()));		
	}
	
	public Not visitNot(@NotNull GrammarParser.NotContext ctx) {
		return new Not((Expression)this.visit(ctx.expr()));	
	}
	public INode visitMultiplication(@NotNull GrammarParser.MultiplicationContext ctx) {
		INode result = null;
		Expression firstOperand = (Expression)this.visit(ctx.expr(0));
		Expression secondOperand = (Expression)this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.MULT:
			result = new Multiplication(firstOperand, secondOperand);
			break;
		case GrammarParser.DIV:
			result = new Division(firstOperand, secondOperand);
			break;
		case GrammarParser.MOD:
			result = new Modulus(firstOperand, secondOperand);
			break;
		}
		return result;
	}
	
	public INode visitAdditive(@NotNull GrammarParser.AdditiveContext ctx) {
		Expression result = null;
		Expression firstOperand = (Expression)this.visit(ctx.expr(0));
		Expression secondOperand = (Expression)this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.ADD:
			result = new Addition(firstOperand, secondOperand);
			break;
		case GrammarParser.SUB:
			result = new Substraction(firstOperand, secondOperand);
			break;
		}
		return result;
	}
	
	public INode visitRelational(@NotNull GrammarParser.RelationalContext ctx) {
		INode result = null;
		Expression firstOperand = (Expression)this.visit(ctx.expr(0));
		Expression secondOperand = (Expression)this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.LTE:
			result = new LesserThanEquals(firstOperand, secondOperand);
			break;
		case GrammarParser.GTE:
			result = new GreaterThanEquals(firstOperand, secondOperand);
			break;
		case GrammarParser.LT:
			result = new LesserThan(firstOperand, secondOperand);
			break;
		case GrammarParser.GT:
			result = new GreaterThan(firstOperand, secondOperand);
			break;
		}
		return result;
	}
	
	public INode visitEquality(@NotNull GrammarParser.EqualityContext ctx) {
		INode result = null;
		Expression firstOperand = (Expression)this.visit(ctx.expr(0));
		Expression secondOperand = (Expression)this.visit(ctx.expr(1));
		switch (ctx.op.getType()) {
		case GrammarParser.EQ:
			result = new Equals(firstOperand, secondOperand); 
			break;
		case GrammarParser.NEQ:
			result = new NotEquals(firstOperand, secondOperand); 
			break;
		}
		return result;
	}
	
	public And visitAnd(@NotNull GrammarParser.AndContext ctx) {
		Expression firstExpression = (Expression)this.visit(ctx.expr(0));
		Expression secondExpression = (Expression)this.visit(ctx.expr(1));
		return new And(firstExpression, secondExpression);
	}
	
	public Or visitOr(@NotNull GrammarParser.OrContext ctx) {
		Expression firstExpression = (Expression)this.visit(ctx.expr(0));
		Expression secondExpression = (Expression)this.visit(ctx.expr(1));
		return new Or(firstExpression, secondExpression);
	}
		
	public INode visitParenthesis(@NotNull GrammarParser.ParenthesisContext ctx) { 
		return this.visit(ctx.expr()); 
	}

	public ID visitId(@NotNull GrammarParser.IdContext ctx) { 
		return new ID(ctx.ID().getText());
	}
}
