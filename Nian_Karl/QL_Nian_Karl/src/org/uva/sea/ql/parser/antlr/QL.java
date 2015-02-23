package org.uva.sea.ql.parser.antlr;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.uva.sea.ql.AST.statement.Statement;
import org.uva.sea.ql.parser.antlr.QLParser.FormContext;
import org.uva.sea.ql.parser.impl.QLImplListener;
import org.uva.sea.ql.parser.impl.QLImplVisitor;


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
		QLImplListener listener = new QLImplListener();
		FormContext form = parser.form();
		
		QLImplVisitor visitor = new QLImplVisitor();
		List<Statement> result = visitor.visit(form);
		
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener,form);
		System.out.println("Omg.");
	}

//	public static void main(String[] args) {
//		try {
//			parseQL("");
//		} catch (Exception e) {
//			System.out.println("There is something wrong with the file!");
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		ANTLRInputStream is = new ANTLRFileStream("Demo.QL");	

		QLLexer lexer = new QLLexer(is);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		QLImplListener listener = new QLImplListener();
		FormContext form = parser.form();
		
		QLImplVisitor visitor = new QLImplVisitor();
		List<Statement> result = visitor.visit(form);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener,form);
		System.out.println("Omg.");
	}
}
