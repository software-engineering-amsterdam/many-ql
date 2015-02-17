package com.antlr4.zarina.tazql;

import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;

import ast.AST;
import ast.form.Form;
import ast.question.Question;

public class MyBaseVisitor extends TaZQLBaseVisitor<AST> {
	
	//Map<String,Object> memory = new HashMap<String, Object>();
	
	public MyBaseVisitor() {}
	
	@Override 
	public Form visitForm(@NotNull TaZQLParser.FormContext ctx) { 
		
		String formid = new String(ctx.ID().getText());
		ArrayList<Question> questions = new ArrayList<Question>();
		
		for ( TaZQLParser.QuestionContext q : ctx.question() ) {
			questions.add((Question) q.accept(this)); 
		}
		//memory.put(formid);
		Form form =  new Form(formid, questions);  // to be fixed...
		return form;
	}
	
}