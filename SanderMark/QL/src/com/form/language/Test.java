package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;

import com.form.language.node.AST;

public class Test {
	public static void main(String[] args) {
		CharStream charStream = 
				new ANTLRInputStream("8+6*3");
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		AST evaluator = parser.syntaxtree().ast;
		System.out.println(evaluator.evaluate());
		//visitor.visit(tree);
	}
}
