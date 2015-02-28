package org.uva.ql.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.antlr.QLParser.QuestionnaireContext;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.visitor.TypeChecker;
import org.uva.ql.view.FormView;
import org.uva.ql.view.QuestionView;

public class Main {

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
		FormView formView = new FormView();
		for (Form form: finalTree.getForms()) {
			for (Statement statement : form.getBlock().getStatements()) {
				if (statement.getClass() == QuestionNormal.class) {
					QuestionView questionView = new QuestionView((QuestionNormal) statement);
					formView.add(questionView);
				}
			}
		}
		
//		for (Form form: finalTree.getFormList()) {
//			printBlock(form.getBlock());
//		}

//		for (Form form: finalTree.getForms()) {
//			printBlock(form.getBlock());
//		}
//		
//		Node result = tree.accept(visitor);
//		// dummy position
//		CodePosition pos = new CodePosition(0, 0);
//		System.out.println(result);
//		Evaluator e = new Evaluator();
//		Identifier id1 = new Identifier("ID1",pos);
//		Identifier id2 = new Identifier("ID2",pos);
//		IntLiteral i1 = new IntLiteral(5,pos);
//		IntLiteral i2 = new IntLiteral(9,pos);
//		Int v1 = new Int(11);
//		Int v2 = new Int(7);
//		
//		e.putValue(id1, v1);
//		e.putValue(id2, v2);
//		System.out.println("Test Evaluator ID1 + ID2 = " + e.evaluate(new Plus(id1, id2,pos)));
//		System.out.println("Test Evaluator ID1 - ID2 = " + e.evaluate(new Minus(id1, id2,pos)));
//		System.out.println("Test Evaluator ID1 * ID2 = " + e.evaluate(new Multiply(id1, id2,pos)));
//		System.out.println("Test Evaluator ID1 / ID2 = " + e.evaluate(new Divide(id1, id2,pos)));
		
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
