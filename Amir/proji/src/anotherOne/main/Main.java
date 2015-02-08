package anotherOne.main;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;

import anotherOne.ast.FormObject;
import anotherOne.grammar.QuestionnaireBuilderVisitor;
//import anotherOne.ast.QuestionnaireBuilderVisitor;
import anotherOne.grammar.qlGrammarLexer;
import anotherOne.grammar.qlGrammarParser;
import anotherOne.gui.userInterface.FormGUI;

/** Client */

public class Main {
	
	private static final JFrame frame = new JFrame("titletitle");
	private JPanel panel1 = new JPanel();

	static public String tmp = "";
	private Main()
	{
	}
	public static void main(String[] args) {
		try
		{	QuestionnaireBuilderVisitor formBuilder = new QuestionnaireBuilderVisitor();
		File aa = new File("E:/tstst.txt");
		String str = FileUtils.readFileToString(aa);
		tmp = str;
		System.out.println(str);
		System.out.println("test");
		ANTLRInputStream bb = new ANTLRInputStream(str);
		qlGrammarLexer lexer = new qlGrammarLexer(bb);
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		qlGrammarParser parser = new qlGrammarParser( tokens );
		ParseTree tree = parser.form() ;//();
		FormObject questionnaire = (FormObject)formBuilder.visit(tree);
		//	    FormObject frm = (FormObject)zero.visit(tree);
		//	    FormObject questionnaireList = (FormObject) astBuilderVisitor.visit(tree);
		System.out.println(tree.toStringTree(parser));
		System.out.println(questionnaire); // manipulate the Mofo
		FormGUI.main(questionnaire);

		} catch (Exception exc) {
			System.err.println(exc.getMessage());
		}

	}    }

