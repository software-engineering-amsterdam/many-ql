package org.uva.sea.ql.parser.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.uva.sea.ql.parser.antlr.DrinkParser.DrinkSentenceContext;

public class Drink {

	private static void drink(String str) {
		DrinkLexer lexer = new DrinkLexer(new ANTLRInputStream(str));
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		DrinkParser parser = new DrinkParser(tokenStream);
		DrinkSentenceContext context = parser.drinkSentence();
		ParseTreeWalker walker = new ParseTreeWalker();
		DrinkBaseListener listener = new DrinkBaseListener();
		walker.walk(listener, context);
	}

	public static void main(String[] args) {
		drink("a cup of thee");
	}
}
