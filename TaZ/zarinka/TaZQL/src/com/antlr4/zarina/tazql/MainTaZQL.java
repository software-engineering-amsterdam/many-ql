	/*
	 * @Zarina
	 */

	package com.antlr4.zarina.tazql;

	import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;


	public class MainTaZQL {
		//private JFrame mainFrame = new JFrame("Quistionnaire");
		//private JPanel mainPanel = new JPanel();
		
		public static void main(String[] args) {
			Scanner scan = null;
			try {
				
				FileInputStream questionnaireFile = new FileInputStream("C:/questions.txt"); 
				scan = new Scanner(questionnaireFile, "UTF-8").useDelimiter("\\A");
				String inputQuestions = scan.next();
				//	System.out.println(inputQuestions);
				
				ANTLRInputStream inputStream = new ANTLRInputStream(inputQuestions);
				TaZQLLexer lexer = new TaZQLLexer(inputStream);
				CommonTokenStream tokens = new CommonTokenStream( lexer );
				TaZQLParser parser = new TaZQLParser(tokens);
				ParseTree tree = parser.parse();			
				
				parser.setBuildParseTree(true);
				
				Questions q = new Questions();
				parser.addParseListener(new MyTaZQLBaseListener(q));
				
				ParseTreeWalker walker = new ParseTreeWalker();
				walker.walk( new MyTaZQLBaseListener(q), tree );
				
				MainFrame frame = new MainFrame();
				frame.mainUi();
				
				System.out.println("Tree: " + tree.toStringTree(parser));
		    
				// Tree in JFrame
				
				JFrame treeframe = new JFrame("Tree");
				treeframe.setContentPane( new JScrollPane( new TreeViewer( null, tree ) ) );
				treeframe.setPreferredSize( new Dimension( 600, 400 ) );
				treeframe.pack();
				treeframe.setLocationRelativeTo( null );
				treeframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				treeframe.setVisible( true );
				
				
				
				
			}
			catch (Exception e){
				System.err.println(e.getMessage());
			}
			finally {
				scan.close();
				if (scan!=null) 
					try {scan.close();} 
					catch (Exception e) {System.err.println(e.getMessage());}
				
			}
		}	
	   
	}

