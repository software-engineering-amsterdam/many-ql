package ql;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ql.antlr.QLLexer;
import ql.antlr.QLParser;

public class Main {

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input1 = new ANTLRInputStream(System.in);
		ANTLRFileStream input2 = new ANTLRFileStream("scripts/questions.ql");
		QLLexer lexer = new QLLexer(input2);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		
		ParseTree tree = parser.form();
		System.out.println("Hello");
		System.out.println(tree.toStringTree(parser));
	}

}
