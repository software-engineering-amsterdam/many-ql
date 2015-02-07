package org.taz.exercises.TaZQL;

import java.io.IOException;
import java.io.InputStream;

import org.taz.exercises.TaZQL.TaZQLLexer;
import org.taz.exercises.TaZQL.TaZQLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;

public class TaZQL {
	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = null;
		
		try {
			
			InputStream inputStream = TaZQL.class.getResourceAsStream("source.tazql");
			String tazQLSourceCode = IOUtils.toString(inputStream, "UTF-8");
			input = new ANTLRInputStream(tazQLSourceCode);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		// create a lexer that feeds off of input CharStream
		TaZQLLexer lexer = new TaZQLLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		TaZQLParser parser = new TaZQLParser(tokens);

	 
	    // Specify our entry point
//	    DrinkSentenceContext drinkSentenceContext = parser.drinkSentence();
		
	    ParseTreeWalker walker = new ParseTreeWalker();
	    MyTaZQLListener listener = new MyTaZQLListener();
	    walker.walk(listener, parser.init());
		
//		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
	}
}
