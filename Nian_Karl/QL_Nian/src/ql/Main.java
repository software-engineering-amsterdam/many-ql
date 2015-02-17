package ql;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ql.antlr.QLLexer;

public class Main {

	public static void main(String[] args) throws Exception{
		//ANTLRInputStream input = new ANTLRInputStream(System.in);
		System.out.println("hello");
		ANTLRFileStream input = new ANTLRFileStream("scripts/test.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//QLParser parser = new QLParser(tokens);
		Printer parser = new Printer(tokens);
		parser.form();
		//ParseTree tree = parser.form();
		//System.out.println(tree.toStringTree(parser));
	}

}
