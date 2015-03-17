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
import uva.sc.ql.dependentElements.DependentQuestionsVisitor;
import uva.sc.ql.evaluator.EvaluatorVisitor;
import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLErrorListener;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;
import uva.sc.ql.typeChecker.TypeCheckerVisitor;

@SuppressWarnings("serial")
public class QuestionnaireForm extends JFrame {

    ParseTree tree;
    File file;
    
    public QuestionnaireForm(File f) throws IOException {
	file = f;
	CharStream in = new ANTLRFileStream(file.getAbsolutePath());
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	parser.removeErrorListeners();
	QLErrorListener syntaxErrorListener = new QLErrorListener();
	parser.addErrorListener(syntaxErrorListener);
	tree = parser.form();

	List<IError> syntaxErrors = syntaxErrorListener.getErrors();
	showErrorMessages(file, "Syntax Errors", syntaxErrors);
	
	IQLFormNode questionnaire = generateAST(); 
	typeChecking(questionnaire);
	EvaluatorVisitor eval = evaluate(questionnaire);
	DependentQuestionsVisitor dependentQuestions = findDependentQuestions(questionnaire);
	GUIVisitor questions = generateGUIQuestions(eval, dependentQuestions, questionnaire);
	renderQuestionnaire(eval, questions, dependentQuestions);
    }
    
    public IQLFormNode generateAST() {
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);
	return questionnaire;
    }
    
    public TypeCheckerVisitor typeChecking(IQLFormNode questionnaire) {
	TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
	questionnaire.accept(typeChecker);
	List<IError> typeCheckerErrors = typeChecker.getErrors();
	List<IWarning> typeCheckerWarnings = typeChecker.getWarnings();
	showErrorMessages(file, "Type Checking Errors", typeCheckerErrors);
	showWarningMessages(file, "Warnings", typeCheckerWarnings);
	return typeChecker;
    }
    
    public EvaluatorVisitor evaluate(IQLFormNode questionnaire) {
	EvaluatorVisitor evaluator = new EvaluatorVisitor();
	try {
	    questionnaire.accept(evaluator);
	} catch (Exception e) {
	}
	return evaluator;
    }
    
    public DependentQuestionsVisitor findDependentQuestions (IQLFormNode questionnaire) {
	DependentQuestionsVisitor d = new DependentQuestionsVisitor();
	questionnaire.accept(d);
	return d;
    }
    
    public GUIVisitor generateGUIQuestions(EvaluatorVisitor eval, DependentQuestionsVisitor d, IQLFormNode questionnaire) {
	GUIVisitor vis = new GUIVisitor(eval, d);
	questionnaire.accept(vis);
	return vis;
    }
    
    public void renderQuestionnaire(EvaluatorVisitor eval, GUIVisitor vis, DependentQuestionsVisitor d) {
	DrawQuestionnaire draw = new DrawQuestionnaire(eval, vis.getComponentList(), d.getDependentElements());
	draw.render();
    }

    private void showWarningMessages(File file, String title,
	    List<IWarning> typeCheckerWarnings) {
	// Show an Warning messageBox
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