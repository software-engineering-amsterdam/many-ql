package org.uva.ql.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLImplErrorListener;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.typechecker.TypeChecker;
import org.uva.ql.view.GUIVisitor;

public class Main {

	public static void main(String[] args) throws IOException {

		QLImplErrorListener errorListener = new QLImplErrorListener();
		ANTLRFileStream input = new ANTLRFileStream("scripts/ql/quest1.ql");
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		parser.addErrorListener(errorListener);
		ParseTree tree = parser.questionnaire();
		QLImplVisitor visitor = new QLImplVisitor();
		Questionnaire questionnaire = (Questionnaire) tree.accept(visitor);
		TypeChecker typeChecker = new TypeChecker();
		if (questionnaire.accept(typeChecker)) {
			GUIVisitor guiVisitor = new GUIVisitor();
			questionnaire.accept(guiVisitor);
		}
		typeChecker.printMessages();
	}

}
