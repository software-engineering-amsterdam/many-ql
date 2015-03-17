package main.manager;

import main.TaZQLLexer;
import main.TaZQLParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.form.Form;
import astvisitor.MyBaseVisitor;

public class ASTCreator {
	
	public Form formCreator() { 
		FileManager file = new FileManager();
		String filename = file.getFileString();
	
		ANTLRInputStream inputStream = new ANTLRInputStream(filename);
	
		TaZQLLexer lexer = new TaZQLLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		TaZQLParser parser = new TaZQLParser(tokens);			
		
		//Walk my tree
		ParseTree tree = parser.form();
		MyBaseVisitor v = new MyBaseVisitor();
		Form form = (Form) v.visit(tree);
			
		// Print my AST in console
		System.out.println("AST: \n" + form.toString());
		
		return form;
	}
}
