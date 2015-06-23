package uva.ql.test;


import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import uva.ql.ast.Form;
import uva.ql.ast.Node;
import uva.ql.ast.statements.Question;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;

public class TestAST {
	
	private String testQuestion = "question boolean hasRentHouse (\"Did you rent a house in 2015?\"){hasRentHouse : true;}";
	private String testForm = "form someForm{ question boolean hasRentHouse (\"Did you rent a house in 2015?\"){hasRentHouse : true;}}";
	
	private static String getTokensWithoutStringLiterals(String inputStream){
		ANTLRInputStream stream = new ANTLRInputStream(inputStream);
		QLLexer lexer = new QLLexer(stream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		return tokenStream.getText().replaceAll("\".*?\"","");
	}
	
	private static Node questCheck(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		QLLexer lexer = new QLLexer(s);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.quest();
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(tree);
		
		return ast;
	}
	
	private static Node formCheck(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		QLLexer lexer = new QLLexer(s);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.form();
		QLMainVisitor visitor = new QLMainVisitor();
		Node ast = visitor.visit(tree);
		
		return ast;
	}
	
	private static String matchRegex(String _statements){
		String _result = null;
		Pattern regex = Pattern.compile("\".*?\"");
		Matcher matcher = regex.matcher(_statements);
		
		if (matcher.find()) {
		    _result = matcher.group();
		}
		
		return _result;
	}
	
	//testing if tokeniser returns correctly the tokens
	@Test
	public void testTokens() {
		String tok = TestAST.getTokensWithoutStringLiterals(testForm);
		assertEquals(tok.indexOf(""),0);
	}
		
	//testing that tokeniser can receive empty input and recognise correctly that the string is empty
	@Test
	public void testEmptyInput() {
		String tok = TestAST.getTokensWithoutStringLiterals("");
		assertEquals(tok.isEmpty(),true);
	}
		
	//testing that a question is correctly recognised by type,identifier and content.
	@Test
	public void testQuestionType(){
		Question quest = (Question)TestAST.questCheck(testQuestion);
			
		assertEquals(quest.getQuestionIdentifierValue(),"hasRentHouse");
		assertEquals(quest.getQuestionType().toString(),"TypeBoolean()");
		assertEquals(quest.getQuestionLabelText(), "Did you rent a house in 2015?");
		assertEquals(quest.getQuestionExpression().evaluate().getValue(),true);
	}
	
	//Testing that a form is recognised correctly and using regex to match strings (validate recognition)
	@Test
	public void testForm(){
		Form form = (Form)TestAST.formCheck(testForm);
		String result = matchRegex(form.getFormStatements().toString());
			
		assertEquals(form.getFormIdentifier().evaluate().toString(),"someForm");
		assertEquals(result,"\"Did you rent a house in 2015?\"");
	}
}
