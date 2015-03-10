package uva.sc.ql.gui;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.sc.ql.ast.INode;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;
import uva.sc.ql.parser.QLVisitor;

@SuppressWarnings("serial")
public class QuestionareForm extends JFrame {

	public QuestionareForm() throws IOException {

		CharStream in = new ANTLRFileStream("C:/Users/Pantelis/Documents/GitHub/software-construction/QL/form/test.grammar");
		// CharStream in = new
		// ANTLRFileStream("/Users/santiagovalenciavargas/Documents/UvA/workspace/Software Construction/QL_QLS/QL/form/test.grammar");
		QLGrammarLexer lexer = new QLGrammarLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLGrammarParser parser = new QLGrammarParser(tokens);
		ParseTree tree = parser.form();

		QLVisitor visitor = new QLVisitor();
		INode questionare = visitor.visit(tree);
		EvaluatorVisitor eval = new EvaluatorVisitor();
		try {
			questionare.accept(eval);
		}
		catch (Exception e) {
		}

		GUIVisitor vis = new GUIVisitor(eval);
		questionare.accept(vis);
		

		/*-------------------------------------------------------------------*/

		JButton submitButton = new JButton("Submit");
		submitButton.setName("subButton");
		vis.getComponentList().add(submitButton);
		JPanel questionarePanel = new JPanel();
		JScrollPane scrollerPane = new JScrollPane(questionarePanel);
		setTitle("QL Questionare Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		questionarePanel.setLayout(new GridLayout(vis.getComponentList().size(), 0));
		scrollerPane.setPreferredSize(new Dimension(300, 600));
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
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
