package com.form.language;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.ast.Form;
import com.form.language.error.CheckTypeErrors;
import com.form.language.error.CheckVariableErrors;
import com.form.language.error.ErrorCollector;
import com.form.language.memory.IdCollector;
import com.form.language.memory.IdTypeTable;
import com.form.language.memory.RuntimeMemory;

public class Test {
	public static void main(String[] args) throws IOException {
		
		//Initialize ANTLR stuff.
		CharStream charStream = new ANTLRFileStream("Testprograms\\program1.ql");
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		
		//Parse the form
		Form form = parser.form().result;
		
		//Collect all the variables
		IdCollector ids = new IdCollector();		
		form.collectIds(ids);
		
		//Set the types of the referencing variables in the form
		IdTypeTable idTable = new IdTypeTable(ids);
		form.setTypes(idTable);
		
		//Check for undeclared variables, exit program and show errors if any are found.
		ErrorCollector varErrors = CheckVariableErrors.containsUndeclaredVariables(ids, idTable);
		if(!varErrors.isEmpty()){
			varErrors.print();
			System.err.println("exit program.");
			System.exit(0);
		}
		
		//Check for type errors, exit program and show errors if any are found.
		if(CheckTypeErrors.containsErrors(form)){
			System.err.println("there are type errors:");
			ErrorCollector errors = new ErrorCollector();
			form.getErrors(errors);
			errors.print();
			System.err.println("exit program.");
			System.exit(0);
		} 
		
		RuntimeMemory mem = form.initMemory();
		System.out.println(mem);
			
		
		
		
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