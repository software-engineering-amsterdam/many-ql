package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;

public class Test {
	public static void main(String[] args) {
		
		String program = "form asf { \n"
				 +	"question \"asdf\" question1: Boolean \n"
				 + 	"question \"asdf\" question2: Boolean \n"
				 +	"if (question2) then asdf := Number 1 end \n"
				 + "}";
		CharStream charStream = 
				new ANTLRInputStream(program);
		
		System.out.println(program);
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		Form evaluator = parser.form().result;
		//System.out.println((evaluator.getType()));
		
		IdCollector ids = new IdCollector();		
		evaluator.collectIds(ids);
		IdTypeTable idTable = new IdTypeTable(ids);
		evaluator.setTypes(idTable);
		evaluator.showTypes();
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