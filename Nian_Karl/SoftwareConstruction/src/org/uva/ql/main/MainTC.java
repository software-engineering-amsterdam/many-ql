package org.uva.ql.main;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.value.IntValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typechecker.TypeChecker;

public class MainTC {

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream("scripts/type1.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		ParseTree tree = parser.questionnaire();
		QLImplVisitor visitor = new QLImplVisitor();
		//Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);
		Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);

		TypeChecker typeChecker = new TypeChecker();
//		questionnaire.accept(typeChecker);
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		System.out.println(a.get(a.size()-1));
		
		if (typeChecker.check(questionnaire)) {
			System.out.println("OMG!");
		}
		typeChecker.printMessages();
		
//		typeChecker.getCC().check();
//		typeChecker.getCC().print();
//		typeChecker.getCC().printCyclic();
		//typeChecker.printAll();
		//tryEvaluator();
	}
	
	public static void tryEvaluator() {
		Evaluator e = new Evaluator();
		Identifier id1 = new Identifier("ID1", new CodePosition(0,0));
		Identifier id2 = new Identifier("ID2", new CodePosition(0,0));
		IntValue v1 = new IntValue(11);
		IntValue v2 = new IntValue(7);
		
		e.addValue(id1.toString(), v1);
		e.addValue(id2.toString(), v2);
		System.out.println("Test Evaluator ID1 + ID2 = " + e.evaluate(new Plus(id1, id2, new CodePosition(0,0))));
		System.out.println("Test Evaluator ID1 - ID2 = " + e.evaluate(new Minus(id1, id2, new CodePosition(0,0))));
		System.out.println("Test Evaluator ID1 * ID2 = " + e.evaluate(new Multiply(id1, id2, new CodePosition(0,0))));
		Value a = e.evaluate(new Equal(id1, id2, new CodePosition(0,0)));
		System.out.println(a.getValue());
		if ((boolean) a.getValue() == true) {
			System.out.println("TURE");
		} else {
			System.out.println("FALSE");
		}
	}
	
//	public static void tryTypeChecker() {
//		Error a = new Error(Error.Type.CYCLIC, 37, "hasMoney", "isMarried");
//		Warning b = new Warning(Warning.Type.DUPLICATE, 74, "hasMoney");
//		System.out.println(a);
//		System.out.println(b);
//	}
}
