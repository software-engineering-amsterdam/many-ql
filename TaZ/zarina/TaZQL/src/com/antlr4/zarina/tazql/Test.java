/*
 * @Zarina
 */

package com.antlr4.zarina.tazql;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;


public class Test {

	public static void main(String[] args) throws RecognitionException {
		
		
		TaZQLLexer lexer = new TaZQLLexer(new ANTLRInputStream("hello"));
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		TaZQLParser parser = new TaZQLParser(tokens);
		
		ParseTree tree = parser.r();
		ParseTreeWalker walker = new ParseTreeWalker();
	    walker.walk( new TestWalker(), tree );
	    System.out.println(tree.toStringTree(parser));
	    
	    JFrame frame = new JFrame();
	    frame.setContentPane( new JScrollPane( new TreeViewer( null, tree ) ) );
	    frame.setPreferredSize( new Dimension( 800, 600 ) );
	    frame.pack();
	    frame.setLocationRelativeTo( null );
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setVisible( true );
	}
   
}
