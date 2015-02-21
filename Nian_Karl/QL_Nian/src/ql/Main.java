package ql;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql.antlr.QLLexer;
import ql.antlr.QLParser;
import ql.antlr.QLParser.FormContext;
import ql.ast.Visitor;
import ql.ast.expression.Expression;

public class Main {

	public static void main(String[] args) throws Exception{
		//ANTLRInputStream input = new ANTLRInputStream(System.in);
		System.out.println("hello");
		ANTLRFileStream input = new ANTLRFileStream("scripts/test.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		//ParseTree tree = parser.form();
		FormContext tree = parser.form();
		Visitor visitor = new Visitor();
		Expression result = visitor.visit(tree);
		//System.out.println(tree.toStringTree(parser));
	}

}
