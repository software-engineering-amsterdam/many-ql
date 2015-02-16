package org.blast.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Main {

	public static void main(String[] args) {
		File file = new File("testfiles\\testdocument.txt");
     
		//Creating Scanner instanace to read File in Java
        Scanner scnr = null;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        //Reading each line of file using Scanner class
        int lineNumber = 1;
        String lines = "";
        while(scnr.hasNextLine()) {
            lines += scnr.nextLine();
            lineNumber++;
        }
        printThem(lines);
     }

	private static void printThem(String lines) {
		//System.out.println(lines);
		  ArrayInitLexer lexer = new ArrayInitLexer(new ANTLRInputStream(lines));	  
		  CommonTokenStream tokens = new CommonTokenStream(lexer);
		  ArrayInitParser parser = new ArrayInitParser(tokens);
		 // HelloBaseListener helloBaseListener = new HelloBaseListener();
		 // parser.addParseListener(helloBaseListener);
		  ParseTree tree = parser.init();
		  System.out.println( tree.toStringTree(parser) );
		 // ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		  //walker.walk(new ArrayInitBaseListener(), tree);
	}
}
