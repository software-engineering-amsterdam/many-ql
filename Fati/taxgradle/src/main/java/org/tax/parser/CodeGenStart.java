package org.tax.parser;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tax.taxgen.TaxLexer;
import org.tax.taxgen.TaxListener;
import org.tax.taxgen.TaxParser;


public class CodeGenStart {
	public void compile(String fileName) throws IOException {
		try { 
			TaxLexer lexer = new TaxLexer(new ANTLRFileStream(fileName));
			TaxParser parser = new TaxParser(new CommonTokenStream(lexer));
			ParseTree tree = parser.prog();

			ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
			TaxListener listener = new TaxCodeGen();
			walker.walk(listener, tree); // initiate walk of tree with listener
			
//	        TaxVisitor eval = new TaxManVisitor();
//	        eval.visit(tree);	
			
		}
		finally {}
	}
	public static void main(String[] args) throws IOException {
		CodeGenStart c = new CodeGenStart();
		c.compile("C:\\Users\\a550396\\Downloads\\myinput.txt");
	}

}
