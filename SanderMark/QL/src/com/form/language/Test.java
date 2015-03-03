package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.ast.expression.Expression;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;

public class Test {
	public static void main(String[] args) {
		
		CharStream charStream = 
				new ANTLRInputStream("hasSoldHouse == true && hasBoughtHouse == true");
	
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		Expression evaluator = parser.expression().result;
		//System.out.println((evaluator.getType()));
		
		IdCollector m = new IdCollector();		
		evaluator.collectIds(m);
//		System.out.println(m.showMemory());
//			
//		ErrorCollector errors = new ErrorCollector();
//		evaluator.getErrors(errors);
//		errors.print();
		
		
		
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