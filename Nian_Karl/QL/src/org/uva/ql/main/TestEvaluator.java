package org.uva.ql.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.antlr.QLParser.QuestionnaireContext;
import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.value.Bool;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typecheck.TypeChecker;

public class TestEvaluator {

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		ANTLRFileStream input = new ANTLRFileStream("scripts/quest2.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);

		ParseTree tree = parser.questionnaire();
		QLImplVisitor visitor = new QLImplVisitor();
		Questionnaire finalTree = (Questionnaire) visitor.visitQuestionnaire((QuestionnaireContext) tree);
		System.out.println("FinalTree = " + finalTree);
		
//		for (Form form: finalTree.getForms()) {
//			printBlock(form.getBlock());
//		}
//		
		
		
		
		Node result = tree.accept(visitor);
		System.out.println(result);
		
		
		Evaluator e = new Evaluator();
		Identifier id1 = new Identifier("ID1", new CodePosition(0, 0));
		Identifier id2 = new Identifier("ID2", new CodePosition(0, 0));
//		Int v1 = new Int(11);
//		Int v2 = new Int(7);
		Bool b1 = new Bool(true);
		Bool b2 = new Bool(false);
		e.putValue(id1, b1);
		e.putValue(id2, b2);
		System.out.println("Bool Evaluation" + e.evaluate(new Equal(id1, id2, new CodePosition(0,0))));
		
//		System.out.println("Test Evaluator ID1 + ID2 = " + e.evaluate(new Plus(id1, id2)));
//		System.out.println("Test Evaluator ID1 - ID2 = " + e.evaluate(new Minus(id1, id2)));
//		System.out.println("Test Evaluator ID1 * ID2 = " + e.evaluate(new Multiply(id1, id2)));
//		System.out.println("Test Evaluator ID1 / ID2 = " + e.evaluate(new Divide(id1, id2)));
		
//		Plus p1 = new Plus(i1, i2);
//		Minus p2 = new Minus(p1,i2);
//		Multiply p3 = new Multiply(p1, p2);
//		System.out.println("TEST VALUE1 " + p3.accept(e).getValue());
//		
//		Greater p4 = new Greater(p2, p3);
//		System.out.println("TEST VALUE2 " + p4.accept(e).getValue());
		
	}
	
	public static void printBlock(Block block){
		TypeChecker typeChcker= new TypeChecker();
		
		for (Statement statement: block.getStatements()) {
			if (statement.getClass() == QuestionNormal.class) {
				QuestionNormal question = (QuestionNormal) statement;
				System.out.println(question.toString());
			}else if (statement.getClass() == QuestionCompute.class) {
				QuestionCompute question = (QuestionCompute) statement;
				Expression expr = question.getExpression();
				System.out.println(expr.accept(typeChcker));
				System.out.println(question.toString());
			}else if (statement.getClass() == IfStatement.class) {
				IfStatement ifstatement = (IfStatement) statement;				
				System.out.println(ifstatement.getExpr());
				printBlock(ifstatement.getIfBlock());		
			}if (statement.getClass() == IfElseStatement.class) {
				IfElseStatement ifElseStatement= (IfElseStatement) statement;				
				System.out.println(ifElseStatement.getExpr());
				printBlock(ifElseStatement.getIfBlock());	
				printBlock(ifElseStatement.getElseBLock());	
			}
			System.out.println();
		}
	}
}
