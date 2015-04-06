package org.nlamah.QL;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
import org.apache.commons.io.IOUtils;

public class Main 
{
    public static void main( String[] args )
    {
		ANTLRInputStream input = null;
		
		try {
			InputStream inputStream = Main.class.getResourceAsStream("source.ql");
			String tazQLSourceCode = IOUtils.toString(inputStream, "UTF-8");
			input = new ANTLRInputStream(tazQLSourceCode);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		// create a lexer that feeds off of input CharStream
		QLLexer lexer = new QLLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		QLParser parser = new QLParser(tokens);

//	    ParseTreeWalker walker = new ParseTreeWalker();
//	    MyTaZQLListener listener = new MyTaZQLListener();
//	    walker.walk(listener, parser.init());
		
	    ParseTree tree = parser.form();
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
		// Tree in JFrame
		JFrame treeframe = new JFrame("Tree");
		treeframe.setContentPane( new JScrollPane( new TreeViewer( null, tree ) ) );
		treeframe.setPreferredSize( new Dimension( 600, 400 ) );
		treeframe.pack();
		treeframe.setLocationRelativeTo( null );
		treeframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		treeframe.setVisible( true );
    }
}
