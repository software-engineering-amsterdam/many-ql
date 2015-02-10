package example.test;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import example.antlr.ArrayInitLexer;
import example.antlr.ArrayInitParser;



public class Test {
	public static void main(String[] args) throws Exception{
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		
		// create a lexer that feeds off of input CharStream
		ArrayInitLexer lexer = new ArrayInitLexer(input);
		
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		ArrayInitParser parser = new ArrayInitParser(tokens);
		
		// begin parsing at init rule
		ParseTree tree = parser.init();
		
		// print LISP-style tree
		System.out.println(tree.toStringTree(parser));
	}
}
