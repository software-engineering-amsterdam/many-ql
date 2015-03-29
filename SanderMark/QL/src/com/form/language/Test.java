package com.form.language;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.form.language.ast.form.Form;
import com.form.language.memory.Context;

public class Test {
    public static void main(String[] args) throws IOException {

	// Initialize ANTLR stuff.
	CharStream charStream = new ANTLRFileStream("Testprograms\\program1.ql");
	GrammarLexer lexer = new GrammarLexer(charStream);
	TokenStream tokenStream = new CommonTokenStream(lexer);
	GrammarParser parser = new GrammarParser(tokenStream);

	// Parse the form
	Form form = parser.form().result;
	
	// Create memory for the form
	Context context = new Context();
	
	// Check types and errors on the form, using the memory
	form.getTypes(context);
	if (context.hasErrors()) {
	    System.err.println("there are type errors:");
	    System.out.println(context.getErrors());
	} else {
	    System.out.println("Input successfully interpreted");
	}
    }
}