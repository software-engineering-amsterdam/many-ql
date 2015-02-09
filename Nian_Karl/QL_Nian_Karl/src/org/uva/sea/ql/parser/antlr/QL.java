package org.uva.sea.ql.parser.antlr;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.sea.ql.parser.impl.QLImplVisitor;


public class QL {

	private static void drink() throws Exception{
		ANTLRInputStream is = new ANTLRFileStream("Demo.QL");
		QLLexer lexer = new QLLexer(is);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.addition();
		System.out.println(new QLImplVisitor().visit(tree));
	}

	public static void main(String[] args) {
		try {
			drink();
		} catch (Exception e) {
			System.out.println("Dude, you deleted/renamed/replaced the demo file.");
		}
	}
}
