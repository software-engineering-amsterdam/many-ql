package uva.sc.ql.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import uva.sc.core.errors.IError;
import uva.sc.core.warnings.IWarning;
import uva.sc.ql.ast.IQLFormNode;
import uva.sc.ql.atom.ID;
import uva.sc.ql.parser.ASTGeneratorVisitor;
import uva.sc.ql.parser.QLErrorListener;
import uva.sc.ql.parser.QLGrammarLexer;
import uva.sc.ql.parser.QLGrammarParser;
import uva.sc.ql.patronElements.PatronQuestionsVisitor;
import uva.sc.ql.typeChecker.TypeCheckerVisitor;

public class QLIntegration {

    @Test
    public void testSyntaxErrors() throws IOException {
	File file = new File("form/test/test1.grammar");
	CharStream in = new ANTLRFileStream(file.getAbsolutePath());
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	
	parser.removeErrorListeners();
	QLErrorListener syntaxErrorListener = new QLErrorListener();
	parser.addErrorListener(syntaxErrorListener);
	@SuppressWarnings("unused")
	ParseTree tree = parser.form();
	List<IError> syntaxErrors = syntaxErrorListener.getErrors();
	
	int syntaxErrorsAmount = syntaxErrors.size();
	
	Assert.assertTrue("Assertion failed. Expected 3 syntax errors, but got " + syntaxErrorsAmount, syntaxErrorsAmount == 3);
    }

    @Test
    public void testTypeCheckingErrors() throws IOException {
	File file = new File("form/test/test2.grammar");
	ParseTree tree = generateParseTree(file);
	
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);

	TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
	questionnaire.accept(typeChecker);
	List<IError> typeCheckerErrors = typeChecker.getErrors();
	
	int typeCheckerErrorsAmount = typeCheckerErrors.size();
	
	Assert.assertTrue("Assertion failed. Expected 2 type checking errors, but got " + typeCheckerErrorsAmount, typeCheckerErrorsAmount == 2);
    }
    
    @Test
    public void testTypeCheckingWarnings() throws IOException {
	File file = new File("form/test/test3.grammar");
	ParseTree tree = generateParseTree(file);
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);

	TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
	questionnaire.accept(typeChecker);
	List<IWarning> typeCheckerWarings = typeChecker.getWarnings();
	
	int typeCheckerWarningsAmount = typeCheckerWarings.size();
	
	Assert.assertTrue ("Assertion failed. Expected 1 type checking warning, but got " + typeCheckerWarningsAmount, typeCheckerWarningsAmount == 1);
    }
    
    @Test
    public void testDependentQuestions() throws IOException {
	File file = new File("form/test/test3.grammar");
	ParseTree tree = generateParseTree(file);
	ASTGeneratorVisitor visitor = new ASTGeneratorVisitor();
	IQLFormNode questionnaire = (IQLFormNode) visitor.visit(tree);
	
	PatronQuestionsVisitor dependentQuestions = new PatronQuestionsVisitor();
	questionnaire.accept(dependentQuestions);
	Map<ID, List<ID>> depenetQuestions = dependentQuestions.getPatronElements();
	
	int numberOfpatronElements = depenetQuestions.size();
	Assert.assertTrue ( "Assertion failed. Expected 4 dependent questions, but got " + numberOfpatronElements, numberOfpatronElements == 4 );
    }

    private ParseTree generateParseTree(File file) throws IOException {
	CharStream in = new ANTLRFileStream(file.getAbsolutePath());
	QLGrammarLexer lexer = new QLGrammarLexer(in);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	QLGrammarParser parser = new QLGrammarParser(tokens);
	ParseTree tree = parser.form();
	return tree;
    }
}
