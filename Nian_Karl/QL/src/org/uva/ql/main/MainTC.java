package org.uva.ql.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.ql.antlr.QLLexer;
import org.uva.ql.antlr.QLParser;
import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.typecheck.message.Error;
import org.uva.ql.typecheck.message.Warning;

public class MainTC {

	public static void main(String[] args) throws IOException {
		System.out.println("Start");
		ANTLRFileStream input = new ANTLRFileStream("scripts/quest3.ql");
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
	}
}
