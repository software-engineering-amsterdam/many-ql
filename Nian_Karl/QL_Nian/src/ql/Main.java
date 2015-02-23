package ql;

import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql.antlr.QLBaseVisitor;
import ql.antlr.QLLexer;
import ql.antlr.QLParser;
import ql.antlr.QLParser.FormContext;
import ql.ast.ASTBuilder;
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
		ASTBuilder visitor = new ASTBuilder();
		//System.out.println(tree.accept(visitor));
		ArrayList<Expression> result = visitor.visit(tree);
		
		for (Expression e : result){
			System.out.println(e.evaluate().getValue());
		}
		//System.out.println(tree.accept(visitor));
		//System.out.println(tree.toStringTree(parser));
	}

}
