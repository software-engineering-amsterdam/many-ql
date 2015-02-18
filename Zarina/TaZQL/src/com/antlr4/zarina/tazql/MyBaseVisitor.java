package com.antlr4.zarina.tazql;

import gui.MainFrame;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;

import ast.AST;
import ast.expression.variables.Id;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.TextType;
import ast.type.Type;

public class MyBaseVisitor extends TaZQLBaseVisitor<AST> {
	
	//Map<String,Object> memory = new HashMap<String, Object>();
	
	public MyBaseVisitor() {}

	@Override 
	public Form visitForm(@NotNull TaZQLParser.FormContext ctx) { 
		
	//	String formid = new String(ctx.ID().getText());
		ArrayList<Question> questions = new ArrayList<Question>();
		
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}
		//memory.put(formid, questions);

		return new Form(ctx.ID().getText(), questions);
	}
	
	@Override public SimpleQuestion visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx) { 
		//testing labels
		MainFrame mf = new MainFrame();
		mf.getLabel(ctx.TEXT().getText(), true);
		
		return new SimpleQuestion((Id) ctx.ID().accept(this), 
								  ctx.TEXT().getText(), 
								  (Type) ctx.type().accept(this)); 
		
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