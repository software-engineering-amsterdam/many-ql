package ast.treevisitor;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;

import ast.AST;
import ast.expression.BinaryExpression;
import ast.expression.BracketsExpression;
import ast.expression.Expression;
import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.Id;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.question.ComputationQuestion;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.TextType;
import ast.type.Type;
import ast.unary.MinusExpression;
import ast.unary.NotExpression;
import ast.unary.PlusExpression;
import ast.unary.UnaryExpression;

import com.antlr4.zarina.tazql.TaZQLBaseVisitor;
import com.antlr4.zarina.tazql.TaZQLParser;

public class MyBaseVisitor extends TaZQLBaseVisitor<AST> {
	
	//Map<String,Object> memory = new HashMap<String, Object>();
	
	public MyBaseVisitor() {}

	@Override 
	public Form visitForm(@NotNull TaZQLParser.FormContext ctx) { 
		ArrayList<Question> questions = new ArrayList<Question>();
		
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}
		//memory.put(formid, questions);

		return new Form(ctx.ID().getText(), questions);
	}
	
	// QUESTION   ****todo: fix double quotes...****
	
	@Override 
	public SimpleQuestion visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx) { 
		return new SimpleQuestion( ctx.ID().getText(), 
								  ctx.TEXT().getText(), 
								  (Type) ctx.type().accept(this)); 
		
	}
	@Override 
	public ComputationQuestion visitComputationQuestion(@NotNull TaZQLParser.ComputationQuestionContext ctx) {
		return new ComputationQuestion( ctx.ID().getText(), 
				  						ctx.TEXT().getText(), 
				  						(Type) ctx.type().accept(this),
				  						(Expression) ctx.expression().accept(this));  
	}
	
	@Override 
	public IfStatement visitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx) { 
		ArrayList<Question> questions = new ArrayList<Question>();
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}
		return new IfStatement((Expression) ctx.expression().accept(this), questions); 
	}
	
	/*
	@Override 
	public IfElseStatement visitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx) { 
		
		return new IfElseStatement((Expression) ctx.expression().accept(this), questions); 
	}
	*/
	
	// EXPRESSIONS
	
	@Override 
	public BracketsExpression visitBracketsExpression(@NotNull TaZQLParser.BracketsExpressionContext ctx) { 
		return new BracketsExpression((Expression) ctx.expression().accept(this));
	}
	
	
	@Override 
	public BinaryExpression visitAddSubExpression(@NotNull TaZQLParser.AddSubExpressionContext ctx) { 
		if (ctx.op.getText().equals("+")) {
		return new AdditionExpression( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
		}
		
		if (ctx.op.getText().equals("-")) {
			return new SubstractionExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
		
		return null;
	}
	
	@Override 
	public BinaryExpression visitMultDivExpression(@NotNull TaZQLParser.MultDivExpressionContext ctx) { 
		if (ctx.op.getText().equals("*")) {
			return new MultiplicationExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals("/")) {
			return new DivisionExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		return null;
	}
	
	@Override 
	public BinaryExpression visitComparissionExpression(@NotNull TaZQLParser.ComparissionExpressionContext ctx) { 
		if (ctx.op.getText().equals(">=")) {
			return new GreaterEqualExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals(">")) {
			return new GreaterThanExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
		if (ctx.op.getText().equals("<=")) {
			return new LessEqualExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}
			
		if (ctx.op.getText().equals("<")) {
			return new LessThanExpression( 
					(Expression) ctx.expression(0).accept(this), 
					(Expression) ctx.expression(1).accept(this)); 
		}	
		return null; 
	}
	
	@Override public BinaryExpression visitAndExpression(@NotNull TaZQLParser.AndExpressionContext ctx) { 
		return new AndExpression( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
	}
	
	@Override public BinaryExpression visitOrExpression(@NotNull TaZQLParser.OrExpressionContext ctx) { 
		return new OrExpression( 
				(Expression) ctx.expression(0).accept(this), 
				(Expression) ctx.expression(1).accept(this)); 
	}
	
	@Override public UnaryExpression visitUnaryExpression(@NotNull TaZQLParser.UnaryExpressionContext ctx) { 
		if (ctx.op.getText().equals("!")) {
			return new NotExpression((Expression) ctx.expression().accept(this)); 
		}
		if (ctx.op.getText().equals("+")) {
			return new PlusExpression( (Expression) ctx.expression().accept(this)); 
		}	
		if (ctx.op.getText().equals("-")) {
			return new MinusExpression((Expression) ctx.expression().accept(this)); 
		}	
		return null; 
	}
	
	
	@Override 
	public Id visitId(@NotNull TaZQLParser.IdContext ctx) { 
		return new Id(ctx.ID().getText()); 
	}
	
	
	@Override 
	public StringVariable visitText(@NotNull TaZQLParser.TextContext ctx) { 
		return new StringVariable(ctx.TEXT().getText().substring(1, ctx.getText().length()-1)); // removing first and last characters
	}
	
	// Question types. 
	@Override public ChoiceType visitBooleanType(@NotNull TaZQLParser.BooleanTypeContext ctx) { return new ChoiceType(); }
	
	@Override public DigitsType visitIntegerType(@NotNull TaZQLParser.IntegerTypeContext ctx) { return new DigitsType(); }
	
	@Override public TextType visitStringType(@NotNull TaZQLParser.StringTypeContext ctx) { return new TextType(); }
	
	
}