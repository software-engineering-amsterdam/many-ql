package org.uva.ql.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.value.Int;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typecheck.TypeChecker;

public class MainTC {

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		ANTLRFileStream input = new ANTLRFileStream("scripts/type1.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		ParseTree tree = parser.questionnaire();
		QLImplVisitor visitor = new QLImplVisitor();
		//Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);
		Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);
		
		System.out.println("[Questionnaire] " + questionnaire);

		TypeChecker typeChecker = new TypeChecker();
		questionnaire.accept(typeChecker);
		
		typeChecker.printMessages();
//		Error a = new Error(Error.Type.CYCLIC, 37, "hasMoney", "isMarried");
//		Warning b = new Warning(Warning.Type.DUPLICATE, 74, "hasMoney");
//		System.out.println(a);
//		System.out.println(b);
		
		
//		TypeChecker tc = new TypeChecker();
//		tc.getType(new Identifier("asdsad", new CodePosition(1,1)));
//		tc.addMessage(a);
//		tc.addMessage(b);
//		tc.printMessages();
		
		tryEvaluator();
	}
	
	public static void tryEvaluator() {
		Evaluator e = new Evaluator();
		Identifier id1 = new Identifier("ID1", new CodePosition(0,0));
		Identifier id2 = new Identifier("ID2", new CodePosition(0,0));
		IntLiteral i1 = new IntLiteral(5, new CodePosition(0,0));
		IntLiteral i2 = new IntLiteral(9, new CodePosition(0,0));
		Int v1 = new Int(11);
		Int v2 = new Int(7);
		
		e.addValue(id1.toString(), v1);
		e.addValue(id2.toString(), v2);
		System.out.println("Test Evaluator ID1 + ID2 = " + e.evaluate(new Plus(id1, id2, new CodePosition(0,0))));
		System.out.println("Test Evaluator ID1 - ID2 = " + e.evaluate(new Minus(id1, id2, new CodePosition(0,0))));
		System.out.println("Test Evaluator ID1 * ID2 = " + e.evaluate(new Multiply(id1, id2, new CodePosition(0,0))));
		System.out.println("Test Evaluator ID1 / ID2 = " + e.evaluate(new Divide(id1, id2, new CodePosition(0,0))));
	}
}
