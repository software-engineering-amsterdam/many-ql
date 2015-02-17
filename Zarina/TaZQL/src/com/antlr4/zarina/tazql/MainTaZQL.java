	/*
	 * @Zarina
	 */

package com.antlr4.zarina.tazql;

import java.io.FileInputStream;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


	public class MainTaZQL {
		
		public static void main(String[] args) {
			Scanner scan = null;
			try {
				// has to be fixed later
				FileInputStream questionnaireFile = new FileInputStream("./test2.ql"); 
				scan = new Scanner(questionnaireFile, "UTF-8").useDelimiter("\\A");
				String inputQuestions = scan.next();
								
				ANTLRInputStream inputStream = new ANTLRInputStream(inputQuestions);
				
				TaZQLLexer lexer = new TaZQLLexer(inputStream);
				CommonTokenStream tokens = new CommonTokenStream( lexer );
				TaZQLParser parser = new TaZQLParser(tokens);			
				
				//Walk my tree
				ParseTree tree = parser.questionnaire();
				MyBaseVisitor v = new MyBaseVisitor();
				v.visit(tree);
					
				// Build a tree in console
				System.out.println("Tree: " + tree.toStringTree(parser));
									    
				// Tree in JFrame
				/*
				JFrame treeframe = new JFrame("Tree");
				treeframe.setContentPane( new JScrollPane( new TreeViewer( null, tree ) ) );
				treeframe.setPreferredSize( new Dimension( 600, 400 ) );
				treeframe.pack();
				treeframe.setLocationRelativeTo( null );
				treeframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				treeframe.setVisible( true );			
				*/
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

