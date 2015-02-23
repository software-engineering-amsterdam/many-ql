package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;

import com.form.language.ast.expression.Expression;

public class Test {
	public static void main(String[] args) {
		CharStream charStream = 
				new ANTLRInputStream("-false");
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		Expression evaluator = parser.expression().result;
		System.out.println((evaluator.getType()));
		System.out.println((evaluator.evaluate()));
		//visitor.visit(tree);
	}
}