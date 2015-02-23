package org.uva.sea.ql.parser;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.uva.sea.ql.AST.Form;
import org.uva.sea.ql.AST.statement.BlockStatement;
import org.uva.sea.ql.AST.statement.IfStatement;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.AST.statement.Statement;
import org.uva.sea.ql.parser.antlr.QLLexer;
import org.uva.sea.ql.parser.antlr.QLParser;
import org.uva.sea.ql.parser.antlr.QLParser.FormContext;
import org.uva.sea.ql.parser.impl.QLImplVisitor;

public class Main {
	public static void main(String[] args) throws IOException {
		ANTLRInputStream is = new ANTLRFileStream("Demo.QL");

		QLLexer lexer = new QLLexer(is);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		FormContext form = parser.form();
		QLImplVisitor visitor = new QLImplVisitor();
		Form AST = (Form) visitor.visitForm(form);
		if (AST == null) {
			System.out.println("Omg.");
		} else {
			printBlock(AST.getBlock());
			System.out.println("wait wut");
		}
		
	}
	
	public static void printBlock(BlockStatement block){
		for (Statement statement: block.getStatementList()) {
			if (statement.getClass() == QuestionStatement.class) {
				QuestionStatement question = (QuestionStatement) statement;
				System.out.println(question.toString());
			}else if (statement.getClass() == IfStatement.class) {
				IfStatement ifstatement = (IfStatement) statement;				
				System.out.println(ifstatement.getExpr());
				printBlock(ifstatement.getBlock());
				
			}
		}
	}
}


