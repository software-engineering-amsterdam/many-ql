package astvisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.TaZQLBaseVisitor;
import main.TaZQLParser;

import org.antlr.v4.runtime.misc.NotNull;

import ast.AST;
import ast.expression.Binary;
import ast.expression.Brackets;
import ast.expression.Expression;
import ast.expression.arithmetic.Addition;
import ast.expression.arithmetic.Division;
import ast.expression.arithmetic.Multiplication;
import ast.expression.arithmetic.Substraction;
import ast.expression.comparison.Equal;
import ast.expression.comparison.GreaterEqual;
import ast.expression.comparison.GreaterThan;
import ast.expression.comparison.LessEqual;
import ast.expression.comparison.LessThan;
import ast.expression.comparison.NotEqual;
import ast.expression.logical.And;
import ast.expression.logical.Or;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.question.ComputationQuestion;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.IntegerType;
import ast.type.TextType;
import ast.type.Type;
import ast.unary.Minus;
import ast.unary.Not;
import ast.unary.Plus;
import ast.unary.Unary;

public class MyBaseVisitor extends TaZQLBaseVisitor<AST> {
	
	public MyBaseVisitor() {}

	@Override 
	public Form visitForm(@NotNull TaZQLParser.FormContext ctx) { 
		ArrayList<Question> questions = new ArrayList<Question>();
		
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}

		return new Form(ctx.ID().getText(), questions);
	}
	
	// QUESTION
	
	@Override 
	public SimpleQuestion visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx) { 
		Type type = (Type) ctx.type().accept(this);
		Id id = new Id(ctx.ID().getText(), type);
		this.putIdType(id.getID(), type);

		return new SimpleQuestion( 
				id,
				ctx.TEXT().getText().replaceAll("^\"|\"$", ""),
				(Type) ctx.type().accept(this)
				); 
	}
	@Override 
	public ComputationQuestion visitComputationQuestion(@NotNull TaZQLParser.ComputationQuestionContext ctx) {
		Type type = (Type) ctx.type().accept(this);
		Id id = new Id(ctx.ID().getText(), type);
		this.putIdType(id.getID(), type);

		return new ComputationQuestion( 
				id,
				ctx.TEXT().getText().replaceAll("^\"|\"$", ""), 
				(Type) ctx.type().accept(this), 
				(Expression) ctx.expression().accept(this)
				);  
	}
	
	@Override 
	public IfStatement visitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx) { 
		List<Question> questions = new ArrayList<Question>();
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}
		return new IfStatement((Expression) ctx.expression().accept(this), questions); 
	}
	
	@Override 
	public IfElseStatement visitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx) { 
		List<Question> ifQuestions = new ArrayList<Question>();
		for ( TaZQLParser.QuestionContext q : ctx.thenBranch ) {
			ifQuestions.add((Question) q.accept(this)); 
		}
		
		List<Question> elseQuestions = new ArrayList<Question>();
		for ( TaZQLParser.QuestionContext q : ctx.elseBranch ) {
		elseQuestions.add((Question) q.accept(this)); 
		}
		return new IfElseStatement(
				(Expression) ctx.cond.accept(this),
				ifQuestions, elseQuestions); 
	}
	
	
	// EXPRESSIONS
	
	@Override 
	public Brackets visitBracketsExpression(@NotNull TaZQLParser.BracketsExpressionContext ctx) { 
		return new Brackets((Expression) ctx.expression().accept(this));
	}
	
	
	@Override 
	public Binary visitAddSubExpression(@NotNull TaZQLParser.AddSubExpressionContext ctx) { 
		if (ctx.op.getText().equals("+")) {
		return new Addition( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
		}
		
		if (ctx.op.getText().equals("-")) {
			return new Substraction( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
		
		return null;
	}
	
	@Override 
	public Binary visitMultDivExpression(@NotNull TaZQLParser.MultDivExpressionContext ctx) { 
		if (ctx.op.getText().equals("*")) {
			return new Multiplication( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals("/")) {
			return new Division( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		return null;
	}
	
	@Override 
	public Binary visitComparissionExpression(@NotNull TaZQLParser.ComparissionExpressionContext ctx) { 
		if (ctx.op.getText().equals(">=")) {
			return new GreaterEqual( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals(">")) {
			return new GreaterThan( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
		if (ctx.op.getText().equals("<=")) {
			return new LessEqual( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals("<")) {
			return new LessThan( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}	
		return null; 
	}
	
	@Override 
	public Binary visitEquationExpression(@NotNull TaZQLParser.EquationExpressionContext ctx) { 
		if (ctx.op.getText().equals("!=")) {
			return new NotEqual( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals("==")) {
			return new Equal( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}	
		return null;  
	}
	
	
	@Override public Binary visitAndExpression(@NotNull TaZQLParser.AndExpressionContext ctx) { 
		return new And( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
	}
	
	@Override public Binary visitOrExpression(@NotNull TaZQLParser.OrExpressionContext ctx) { 
		return new Or( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
	}
	
	@Override public Unary visitUnaryExpression(@NotNull TaZQLParser.UnaryExpressionContext ctx) { 
		if (ctx.op.getText().equals("!")) {
			return new Not((Expression) ctx.expression().accept(this)); 
		}
		if (ctx.op.getText().equals("+")) {
			return new Plus( (Expression) ctx.expression().accept(this)); 
		}	
		if (ctx.op.getText().equals("-")) {
			return new Minus((Expression) ctx.expression().accept(this)); 
		}	
		return null; 
	}
	
	//
	 private final HashMap<String, Type> idType = new HashMap<>();
	
	 private void putIdType(String id, Type type) {
		 idType.put(id, type);
	 }
	
	 private Type getIdType(String id) {
		 return idType.containsKey(id) ? idType.get(id) : null;
	 }
	
	// *** expression variables ***
	
	@Override 
	public Id visitId(@NotNull TaZQLParser.IdContext ctx) { 
		String id = ctx.ID().getText();
		Type type = this.getIdType(id);
		return new Id(ctx.ID().getText(), type); 
	}
		
	@Override 
	public StringVariable visitText(@NotNull TaZQLParser.TextContext ctx) { 
		return new StringVariable(ctx.TEXT().getText().replaceAll("^\"|\"$", "")); 
	}
	
	@Override 
	public IntegerVariable visitNumber(@NotNull TaZQLParser.NumberContext ctx) { 
		return new IntegerVariable(Integer.valueOf(ctx.NUMBER().getText()));
	}
	
	@Override 
	public BooleanVariable visitBooleanExpression(@NotNull TaZQLParser.BooleanExpressionContext ctx) { 
		return new BooleanVariable(Boolean.valueOf(ctx.BOOLEAN().getText()));
	}
		
	
	//  *** Question types ***
	
	@Override 
	public ChoiceType visitBooleanType(@NotNull TaZQLParser.BooleanTypeContext ctx) { 
		return new ChoiceType(); 
	}
	
	@Override 
	public IntegerType visitIntegerType(@NotNull TaZQLParser.IntegerTypeContext ctx) { 
		return new IntegerType(); 
	}
	
	@Override 
	public TextType visitStringType(@NotNull TaZQLParser.StringTypeContext ctx) { 
		return new TextType(); 
	}
	
	
}