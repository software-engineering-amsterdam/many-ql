package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.form.Form;
import ast.treevisitor.MyBaseVisitor;

public class ASTCreator {

	public Form formCreator() throws FileNotFoundException, IOException {
		ANTLRInputStream inputStream = new ANTLRInputStream(fileToString(fileName()));
	
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

	public String fileToString(String filename) throws FileNotFoundException, IOException {
		File file = new File(filename);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scan = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");
		
		try {
		    while(scan.hasNextLine()) {        
		        fileContents.append(scan.nextLine() + lineSeparator);
		    }
		return fileContents.toString();
		} 
		finally {
		    scan.close();
		}
	}
	
	public String fileName() {
		String fileName = "./questionnaires/test2.ql";
		return fileName;
	}
}
