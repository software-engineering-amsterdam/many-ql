package uva.sc.ql.gui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import uva.sc.core.errors.IError;
import uva.sc.core.warnings.IWarning;
import uva.sc.ql.ast.IQLFormNode;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;
import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLErrorListener;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;
import uva.sc.ql.patronElements.PatronQuestionsVisitor;
import uva.sc.ql.typeChecker.TypeCheckerVisitor;

@SuppressWarnings("serial")
public class QuestionnaireForm extends JFrame {
    
    private ID formTitle;

    public void drawQuestionnaireFormManager(File file) throws IOException {
	ParseTree tree = generateParseTree(file);
	IQLFormNode questionnaire = generateAST(tree);
	typeChecking(questionnaire, file);
	QuestionsPropertiesVisitor questionsProperties = initialEvaluation(questionnaire);
	PatronQuestionsVisitor dependentQuestions = findDependentQuestions(questionnaire);
	GUIVisitor questions = generateGUIQuestions(questionsProperties,
		dependentQuestions, questionnaire);
	renderQuestionnaire(questions, dependentQuestions);
    }

    public ParseTree generateParseTree(File file) throws IOException {
	CharStream in = new ANTLRFileStream(file.getAbsolutePath());
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	QLErrorListener syntaxErrorListener = setErrorListenersToParseTree(parser);
	ParseTree tree = parser.form();
	syntaxErrorChecking(syntaxErrorListener, file);
	return tree;
    }

    private QLErrorListener setErrorListenersToParseTree(QLGrammarParser parser) {
	parser.removeErrorListeners();
	QLErrorListener syntaxErrorListener = new QLErrorListener();
	parser.addErrorListener(syntaxErrorListener);
	return syntaxErrorListener;
    }

    public IQLFormNode generateAST(ParseTree tree) {
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);
	return questionnaire;
    }

    public void syntaxErrorChecking(QLErrorListener syntaxErrorListener,
	    File file) {
	List<IError> syntaxErrors = syntaxErrorListener.getErrors();
	showErrorMessages(file, "Syntax Errors", syntaxErrors);
    }

    public TypeCheckerVisitor typeChecking(IQLFormNode questionnaire, File file) {
	TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
	questionnaire.accept(typeChecker);
	List<IError> typeCheckerErrors = typeChecker.getErrors();
	List<IWarning> typeCheckerWarnings = typeChecker.getWarnings();
	showErrorMessages(file, "Type Checking Errors", typeCheckerErrors);
	showWarningMessages(file, "Warnings", typeCheckerWarnings);
	formTitle = typeChecker.getFormTitle();
	return typeChecker;
    }

    @SuppressWarnings("unchecked")
    public QuestionsPropertiesVisitor initialEvaluation(
	    IQLFormNode questionnaire) {
	QuestionsPropertiesVisitor questionsProperties = new QuestionsPropertiesVisitor();
	questionnaire.accept(questionsProperties);
	return questionsProperties;
    }

    public PatronQuestionsVisitor findDependentQuestions(
	    IQLFormNode questionnaire) {
	PatronQuestionsVisitor d = new PatronQuestionsVisitor();
	questionnaire.accept(d);
	return d;
    }

    public GUIVisitor generateGUIQuestions(
	    QuestionsPropertiesVisitor questionsProperties,
	    PatronQuestionsVisitor patronElements, IQLFormNode questionnaire) {
	GUIVisitor vis = new GUIVisitor(questionsProperties, patronElements);
	questionnaire.accept(vis);
	return vis;
    }

    public void renderQuestionnaire(GUIVisitor vis, PatronQuestionsVisitor d) {
	DrawQuestionnaire draw = new DrawQuestionnaire(vis.getComponentList(), formTitle);
	draw.render();
    }

    private void showWarningMessages(File file, String title,
	    List<IWarning> typeCheckerWarnings) {
	String message = "Warnings in the file " + file + ":\n\n";
	for (IWarning warning : typeCheckerWarnings) {
	    message = message + warning + "\n";
	}
	JOptionPane.showMessageDialog(this, message, title,
		JOptionPane.WARNING_MESSAGE);
    }

    private void showErrorMessages(File file, String title, List<IError> errors) {
	if (!(errors.isEmpty())) {
	    // Show an Error messageBox and terminate
	    String message = "Errors in the file " + file + ":\n\n";
	    for (IError error : errors) {
		message = message + error + "\n";
	    }
	    message += "The program will now terminate.";
	    JOptionPane.showMessageDialog(this, message, title,
		    JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
    }
}