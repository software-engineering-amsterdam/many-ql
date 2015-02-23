	/*
	 * @Zarina
	 */

package com.antlr4.zarina.tazql;

import gui.MainFrame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.form.Form;
import ast.treevisitor.MyBaseVisitor;


	public class MainTaZQL {
		
		public static void main(String[] args) throws FileNotFoundException, IOException  {
						
				ANTLRInputStream inputStream = new ANTLRInputStream(fileToString("./questionnaires/test.ql"));
				
				TaZQLLexer lexer = new TaZQLLexer(inputStream);
				CommonTokenStream tokens = new CommonTokenStream( lexer );
				TaZQLParser parser = new TaZQLParser(tokens);			
				
				//Walk my tree
				ParseTree tree = parser.form();
				MyBaseVisitor v = new MyBaseVisitor();
				Form form = (Form) v.visit(tree);
					
				// Print my AST in console
				System.out.println("AST: \n" + form.toString());
				
				// Build my GUI
				MainFrame mf = new MainFrame();
				mf.magic(form);
				
		}
	
		public static String fileToString(String file) throws FileNotFoundException, IOException {
		    	//to be changed later
				FileInputStream questionnaireFile = new FileInputStream(new File(file)); 
				String inputQuestions = new Scanner(questionnaireFile,"UTF-8").useDelimiter("\\A").next();
				return inputQuestions;
    	}
}

