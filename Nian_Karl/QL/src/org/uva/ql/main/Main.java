package org.uva.ql.main;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.evaluation.Evaluator;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.view.FormFrame;
import org.uva.ql.view.GUIVisitor;

public class Main {

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream("scripts/quest1.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.questionnaire();
		QLImplVisitor visitor = new QLImplVisitor();
		Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);
		
		TypeChecker checker = new TypeChecker();
		// Nian implement typechecker;

		Evaluator evaluator = new Evaluator();
		
		GUIVisitor guiVisitor = new GUIVisitor(evaluator);
		ArrayList<FormFrame> formList = ((ArrayList<FormFrame>) questionnaire.accept(guiVisitor));

	}
}
