package ql;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql.antlr.QLLexer;
import ql.antlr.QLParser;
import ql.antlr.QLParser.FormContext;
import ql.ast.ASTBuilder;
import ql.ast.ASTNode;
import ql.ast.expression.binary.Plus;
import ql.ast.expression.literal.IntLiteral;
import ql.ast.visitor.Evaluator;

public class Main {

	public static void main(String[] args) throws Exception{
		//ANTLRInputStream input = new ANTLRInputStream(System.in);
		System.out.println("Start");
		ANTLRFileStream input = new ANTLRFileStream("scripts/test.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		//ParseTree tree = parser.form();
		FormContext tree = parser.form();
		ASTBuilder visitor = new ASTBuilder();
		//System.out.println(tree.accept(visitor));
		ASTNode result = visitor.visit(tree);
		System.out.println(result);
		
		IntLiteral i1 = new IntLiteral(5);
		IntLiteral i2 = new IntLiteral(9);
		Plus p1 = new Plus(i1, i2);
		Plus p2 = new Plus(p1,i2);
		Evaluator e = new Evaluator();
		System.out.println("TEST VALUE" + p2.accept(e).getValue());
		
		//System.out.println(tree.accept(visitor));
		//System.out.println(tree.toStringTree(parser));
	}

}
