package com.form.language;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.ANTLRFileStream;

import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.error.CheckVariableErrors;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;
import com.form.language.error.CheckTypeErrors;

public class Test {
	public static void main(String[] args) throws IOException {
		
//		String program = "form asf { \n"
//				 +	"question \"asdf\" question1: Boolean \n"
//				 + 	"question \"asdf\" question2: Boolean \n"
//				 +	"if (question2) then asdf := Number 1 end \n"
//				 + "}";
//		CharStream charStream = 
//				new ANTLRInputStream(program);
			CharStream charStream = 
					new ANTLRFileStream("Testprograms\\program1.ql");
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		Form evaluator = parser.form().result;
		//System.out.println((evaluator.getType()));
		IdCollector ids = new IdCollector();		
		evaluator.collectIds(ids);
		IdTypeTable idTable = new IdTypeTable(ids);
		evaluator.setTypes(idTable);
		
		System.out.println(ids);
		System.out.println("\nIdTypeTable:\n" + idTable);
		ErrorCollector varErrors = CheckVariableErrors.containsUndeclaredVariables(ids, idTable);
		if(!varErrors.isEmpty()){
			varErrors.print();
		}

//		if(CheckTypeErrors.containsErrors(evaluator)){
//			System.err.println("there are errors:");
//			ErrorCollector errors = new ErrorCollector();
//			evaluator.getErrors(errors);
//			errors.print();
//		} else{
//			System.out.println("there are no errors:");
//			evaluator.showTypes();
//		}
//		RuntimeMemory mem = evaluator.initMemory();
//		System.out.println(mem);
//		System.out.println(m.showMemory());
//			
		
		
		
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