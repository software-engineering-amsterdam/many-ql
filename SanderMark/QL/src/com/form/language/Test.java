package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.Question;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.Memory;
import com.form.language.test.AstTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {
	public static void main(String[] args) {
		
		CharStream charStream = 
				new ANTLRInputStream("form taxOfficeExample {"
  + "xX := Boolean true \n"						
  + "question \"Did you sell a house in 2010?\" hasSoldHouse : Boolean"
  + "question \"Did you buy a house in 2010?\"  hasBoughtHouse : Boolean"
  + "question \"Did you enter a loan?\" hasMaintLoan : Boolean"
  + "if hasSoldHouse == true && hasBoughtHouse then bla end"
  + "}");
	
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		Form evaluator = parser.form().result;
		//System.out.println((evaluator.getType()));
		
		Memory m = new Memory();		
		evaluator.fillMemory(m);
		System.out.println(m.showMemory());
			
		ErrorCollector errors = new ErrorCollector();
		evaluator.getErrors(errors);
		errors.print();
		
		
		
//		Result result = JUnitCore.runClasses(AstTest.class);
//	    for (Failure failure : result.getFailures()) {
//	      System.out.println(failure.toString());
//	    }
		
//		CharStream charStream = new ANTLRInputStream("question" + "\"Did you sell a house in 2010?\"" + "hasSoldHouse Boolean");
//		GrammarLexer lexer = new GrammarLexer(charStream);
//		TokenStream tokenStream = new CommonTokenStream(lexer);
//		GrammarParser parser = new GrammarParser(tokenStream);
//		Question question = parser.question().result;
/*		System.out.println((evaluator.getType()));
		System.out.println((evaluator.evaluate()));*/
		
	}
}