package uva.sc.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.sc.ast.INode;
import uva.sc.parser.GrammarLexer;
import uva.sc.parser.GrammarParser;
import uva.sc.parser.QLVisitor;

@SuppressWarnings("serial")
public class QuestionareForm extends JFrame {	
	
	public QuestionareForm() throws IOException{
		
		//CharStream in = new ANTLRFileStream("C:/Users/Pantelis/git/software-construction/QL/form/test.grammar");
        CharStream in = new ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction//QL/QL/form/test.grammar");
        GrammarLexer lexer = new GrammarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.form();

        QLVisitor visitor = new QLVisitor();
        INode questionare = visitor.visit(tree);
        
        GUIVisitor vis = GUIVisitor.getInstance();
        questionare.accept(vis);
        
        /*-------------------------------------------------------------------*/ 
        
        JButton submitButton = new JButton("Submit");
        submitButton.setName("subButton");
        vis.getComponentList().add(submitButton);
        JPanel questionarePanel = new JPanel();
        JScrollPane scrollerPane = new JScrollPane(questionarePanel);
		setTitle ("QL Questionare Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionarePanel.setLayout(new GridLayout(vis.getComponentList().size(),0));
        scrollerPane.setPreferredSize(new Dimension(300,600));
        for (Component component : vis.getComponentList()) {
        	questionarePanel.add(component);
        }
        add(scrollerPane);
        pack();
        vis.addListeners();
	}
	
	public static void main(String[] args) {
		QuestionareForm form;
		try {
			form = new QuestionareForm();
			form.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

