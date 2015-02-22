	/*
	 * @Zarina
	 */

package com.antlr4.zarina.tazql;

import gui.MainFrame;

import java.io.FileInputStream;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.form.Form;
import ast.treevisitor.MyBaseVisitor;


	public class MainTaZQL {
		
		public static void main(String[] args) throws Exception {
			Scanner scan = null;
	
				// has to be fixed later
				FileInputStream questionnaireFile = new FileInputStream("./questionnaires/test.ql"); 
				scan = new Scanner(questionnaireFile, "UTF-8").useDelimiter("\\A");
				
				String inputQuestions = scan.next();
								
				ANTLRInputStream inputStream = new ANTLRInputStream(inputQuestions);
				
				TaZQLLexer lexer = new TaZQLLexer(inputStream);
				CommonTokenStream tokens = new CommonTokenStream( lexer );
				TaZQLParser parser = new TaZQLParser(tokens);			
				
				//Walk my tree
				ParseTree tree = parser.form();
				MyBaseVisitor v = new MyBaseVisitor();
				Form form = (Form) v.visit(tree);
					
				// Build a tree in console
			//	System.out.println("Tree: " + tree.toStringTree(parser));
				System.out.println(form.toString());
				
				// Let's try my gui...
			//	GUIMaker guiMaker = new GUIMaker();
				MainFrame mf = new MainFrame();
				mf.magic(form);
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
		
	
	   
	}

