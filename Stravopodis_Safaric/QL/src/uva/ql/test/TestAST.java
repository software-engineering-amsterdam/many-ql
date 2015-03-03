package uva.ql.test;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import uva.ql.ast.ASTNode;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;



import uva.ql.ast.question.Question;

import uva.ql.ast.Form;


public class TestAST {
	
	private static String getTokensWithoutStringLiterals(String inputStream){
		ANTLRInputStream stream = new ANTLRInputStream(inputStream);
		QLLexer lexer = new QLLexer(stream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		return tokenStream.getText().replaceAll("\".*?\"","");
	}
	
	private static ASTNode questCheck(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		QLLexer lexer = new QLLexer(s);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.quest();
		QLMainVisitor visitor = new QLMainVisitor();
		ASTNode ast = visitor.visit(tree);
		
		return ast;
	}
	
	private static ASTNode formCheck(String stream){
		ANTLRInputStream s = new ANTLRInputStream(stream);
		QLLexer lexer = new QLLexer(s);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokenStream);
		ParseTree tree = parser.form();
		QLMainVisitor visitor = new QLMainVisitor();
		ASTNode ast = visitor.visit(tree);
		
		return ast;
	}
	
   //testing if tokeniser returns correctly the tokens
	@Test
	public void testTokens() {
		String tok = TestAST.getTokensWithoutStringLiterals("form someForm{ question someQuestion typeof int { someQuestion: \"This is some question:\";}}");
		
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
		Question quest = (Question)TestAST.questCheck("question someQuestion typeof int { someQuestion: \"This is some question:\";}");
		assertEquals(quest.getIdentifier().evaluate().getValue(),"someQuestion");
		assertEquals(quest.getType().getTypeName(),"int");
		assertEquals(quest.getQuestionText(),"This is some question:");
	}
	
	@Test
	public void testForm(){
		Pattern regex = Pattern.compile("\".*?\"");
		String result=null;
		Form form = (Form)TestAST.formCheck("form someForm{ question someQuestion typeof int { someQuestion: \"This is some question:\";}}");
		String stats = form.getStatement().toString();
		Matcher m = regex.matcher(stats);
		
		if (m.find()) {
		    result = m.group();
		}
		assertEquals(form.getIdentifier().evaluate().getValue(),"someForm");
		assertEquals(result,"\"This is some question:\"");
		
	}
}
