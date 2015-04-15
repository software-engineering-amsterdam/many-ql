package qlProject.main;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;

import qlProject.ast.Questionnaire;
import qlProject.ast.value.Value;
import qlProject.grammar.ParserToASTVisitor;
import qlProject.grammar.qlGrammarLexer;
import qlProject.grammar.qlGrammarParser;
import qlProject.gui.GuiManager;
import qlProject.typeChecking.TypeCheckManager;
import qlProject.util.QuestionDetails;

public class Main {

  	public static ParseTree createParseTreeFromInput(String s){
		ANTLRInputStream inputStream = new ANTLRInputStream(s);
		qlGrammarLexer lexer = new qlGrammarLexer(inputStream);
		CommonTokenStream tokens = new CommonTokenStream( lexer );
		qlGrammarParser parser = new qlGrammarParser( tokens );
		return parser.form();
	}

	public static void main(String[] args) {

		Map<String, QuestionDetails> questionsDetails = new LinkedHashMap<String, QuestionDetails>();
		Map<String,Set<String>> dependencies = new HashMap<String,Set<String>>();
		Map<String,Set<String>> awaitingCalculationIds = new HashMap<String,Set<String>>();
		Map<String, Value> valuesEnvironment = new HashMap<String, Value>();


		try
		
		{
			File f = new File("E:/tstst.txt");
			String input = FileUtils.readFileToString(f);
			ParseTree tree = createParseTreeFromInput(input);
			
			Questionnaire q = (Questionnaire)tree.accept(new ParserToASTVisitor());
			new TypeCheckManager(q, questionsDetails, valuesEnvironment, dependencies ,awaitingCalculationIds).manageTypeChecking();
			new GuiManager(questionsDetails, valuesEnvironment, dependencies, awaitingCalculationIds).manageGUI(q);
		} 
// TODO tostring expressions questions?
		catch (Exception exc) {
			System.err.println(exc.getMessage());
		}
	}
}