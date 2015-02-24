package test;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.QLLexer;
import antlr.QLParser;
import ast.Node;
import ast.builder.BuilderVisitor;
import ast.expression.binary.Greater;
import ast.expression.binary.Minus;
import ast.expression.binary.Multiply;
import ast.expression.binary.Plus;
import ast.expression.literal.IntLiteral;
import ast.visitor.Evaluator;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		ANTLRFileStream input = new ANTLRFileStream("scripts/quest1.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		ParseTree tree = parser.questionnaire();
		BuilderVisitor visitor = new BuilderVisitor();
		Node result = tree.accept(visitor);
		System.out.println(result);
		
		IntLiteral i1 = new IntLiteral(5);
		IntLiteral i2 = new IntLiteral(9);
		Plus p1 = new Plus(i1, i2);
		Minus p2 = new Minus(p1,i2);
		Multiply p3 = new Multiply(p1, p2);
		Evaluator e = new Evaluator();
		System.out.println("TEST VALUE1 " + p3.accept(e).getValue());
		
		Greater p4 = new Greater(p2, p3);
		System.out.println("TEST VALUE2 " + p4.accept(e).getValue());
		
	}

}
