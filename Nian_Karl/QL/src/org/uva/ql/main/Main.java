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
import org.uva.ql.ast.statement.BlockStatement;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.visitor.EvaluatorVisitor;
import org.uva.ql.ast.visitor.TypeCheckerVisitor;

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
		System.out.println(finalTree.getFormList().size());
		
		for (Form form: finalTree.getFormList()) {
			printBlock(form.getBlock());
		}
		
		
//		Node result = tree.accept(visitor);
//		System.out.println(result);
//		
//		IntLiteral i1 = new IntLiteral(5);
//		IntLiteral i2 = new IntLiteral(9);
//		Plus p1 = new Plus(i1, i2);
//		Minus p2 = new Minus(p1,i2);
//		Multiply p3 = new Multiply(p1, p2);
//		Evaluator e = new Evaluator();
//		System.out.println("TEST VALUE1 " + p3.accept(e).getValue());
//		
//		Greater p4 = new Greater(p2, p3);
//		System.out.println("TEST VALUE2 " + p4.accept(e).getValue());
		
	}
	
	public static void printBlock(BlockStatement block){
		TypeCheckerVisitor typeChcker= new TypeCheckerVisitor();
		
		for (Statement statement: block.getStatementList()) {
			if (statement.getClass() == QuestionNormal.class) {
				QuestionNormal question = (QuestionNormal) statement;
				System.out.println("Question string: " +question.toString());
			}else if (statement.getClass() == QuestionCompute.class) {
				QuestionCompute question = (QuestionCompute) statement;
				Expression expr = question.getExpression();
				System.out.println(expr.accept(typeChcker));
				System.out.println("Question string: " +question.toString());
			}else if (statement.getClass() == IfStatement.class) {
				IfStatement ifstatement = (IfStatement) statement;				
				System.out.println("expression" + ifstatement.getExpr());
				printBlock(ifstatement.getIfBlock());		
			}if (statement.getClass() == IfElseStatement.class) {
				IfElseStatement ifElseStatement= (IfElseStatement) statement;				
				System.out.println("expression" + ifElseStatement.getExpr());
				printBlock(ifElseStatement.getIfBlock());	
				printBlock(ifElseStatement.getElseBLock());	
			}
			System.out.println();
		}
	}
}
