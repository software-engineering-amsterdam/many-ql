package uva.sc.ql.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.sc.core.INode;
import uva.sc.ql.ast.IQLExpressionNode;
import uva.sc.ql.ast.IQLFormNode;
import uva.sc.ql.ast.IQLStatementNode;
import uva.sc.ql.dependentElements.DependentQuestionsVisitor;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;

@SuppressWarnings("serial")
public class QuestionnaireForm extends JFrame {

    public QuestionnaireForm(File file) throws IOException {

	CharStream in = new ANTLRFileStream(file.getAbsolutePath());
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	ParseTree tree = parser.form();

	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);
	
	EvaluatorVisitor eval = new EvaluatorVisitor();
	try {
	    questionnaire.accept(eval);
	} catch (Exception e) {
	}
	DependentQuestionsVisitor d = new DependentQuestionsVisitor();
	questionnaire.accept(d);
	
	GUIVisitor vis = new GUIVisitor(eval, d);
	questionnaire.accept(vis);
	
	/*-----------------------------QL Program------------------------------*/

	DrawQuestionnaire draw = new DrawQuestionnaire(eval, vis.getComponentList(), d.getDependentElements());
	draw.render();
    }
}