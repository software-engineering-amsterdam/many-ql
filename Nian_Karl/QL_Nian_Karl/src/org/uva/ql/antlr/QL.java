package org.uva.ql.antlr;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.listener.QLImplListener;
import org.uva.ql.visitor.QLImplVisitor;


public class QL {

	private static void parseQL(String path) throws Exception{
		ANTLRInputStream is = null;
		path.equals("");
		if (path.equals("")) {
			is = new ANTLRFileStream("Demo.QL");	
		}else{
			is = new ANTLRFileStream(path);
		}		 
		QLLexer lexer = new QLLexer(is);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.form();
		parser.addParseListener(new QLImplListener());
		System.out.println(new QLImplVisitor().visit(tree));
	}

	public static void main(String[] args) {
		
		try {
			parseQL("");
		} catch (Exception e) {
			System.out.println("There is something wrong with the file!");
		}
	}
}
