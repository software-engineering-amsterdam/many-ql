package org.uva.qls.main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.qls.antlr.QLSBaseVisitor;
import org.uva.qls.antlr.QLSLexer;
import org.uva.qls.antlr.QLSParser;

public class Main {

	public static void main(String[] args) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream("scripts/qls/style1.qls");
		QLSLexer lexer = new QLSLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLSParser parser = new QLSParser(tokens);
		ParseTree tree = parser.sheet();
		QLSBaseVisitor visitor = new QLSBaseVisitor();
		ParseTree sheet = (ParseTree) tree.accept(visitor);
		System.out.println("");
	}
}
