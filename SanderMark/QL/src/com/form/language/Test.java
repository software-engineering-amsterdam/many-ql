package com.form.language;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStream;

import com.form.language.ast.expression.PrimitiveExpression;
import com.form.language.ast.values.IntValue;

public class Test {
	public static void main(String[] args) {
		CharStream charStream = 
				new ANTLRInputStream("8+6");
		GrammarLexer lexer = new GrammarLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokenStream);
		PrimitiveExpression evaluator = parser.syntaxtree().expression().pExp;
		System.out.println(((IntValue)evaluator.evaluate()).evaluate());
		//visitor.visit(tree);
	}
}
