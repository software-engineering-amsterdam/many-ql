package example1;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import example1.antlr.ArrayInitLexer;
import example1.antlr.ArrayInitParser;
import example1.ulti.ShortToUnicodeString;

public class Main {

	public static void main(String[] args) throws Exception{
		// create a CharStream that reads from standard input
		//ANTLRInputStream input1 = new ANTLRInputStream(System.in);
		ANTLRFileStream input2 = new ANTLRFileStream("scripts/test.emp1");
		
		// create a lexer that feeds off of input CharStream
		ArrayInitLexer lexer = new ArrayInitLexer(input2);
		
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		ArrayInitParser parser = new ArrayInitParser(tokens);
		
		// begin parsing at init rule
		ParseTree tree = parser.init();
		
		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(new ShortToUnicodeString(), tree);
		
	/*	// print LISP-style tree
		System.out.println(tree.toStringTree(parser));
	*/
		// print a \n after translation
		System.out.println();
	}

}
