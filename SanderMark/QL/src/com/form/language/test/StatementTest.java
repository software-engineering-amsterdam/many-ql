package com.form.language.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.AssignmentStatement;
import com.form.language.ast.statement.Question;
import com.form.language.ast.type.BoolType;
import com.form.language.ast.values.IntValue;
import com.form.language.memory.RuntimeMemory;

public class StatementTest {
	
	private String getQuestionString() {
		return "hasSoldHouse: \"Did you sell a house in 2010?\" boolean";
	}

	private Question getQuestionObject() {
		return new Question("\"Did you sell a house in 2010?\"","hasHouseSold",	new BoolType());
	}
	
	private String getAssigementString()
	{
		return "hasHouseSold := Boolean true";		
	}
	private AssignmentStatement getAssigmentStatementObject() throws IOException{
		GrammarParser parser= AstTest.getParser("true");
		Expression expression= parser.expression().result;
		return new AssignmentStatement("hasHouseSold", new BoolType(), expression);		
	}	
	private String getIfString()
	{
		return "if hasSoldHouse == true && hasBoughtHouse == true then question" + "\"Test?\"" + "hasTest : Boolean end";		
	}
	private void IfStatementObject(){
		GrammarParser parser= AstTest.getParser("hasSoldHouse == true && hasBoughtHouse == true");
		Expression expression= parser.expression().result;
		return new IfStatement("hasHouseSold", new BoolType(), expression);		
		//return new AssignementStatement();		
	}
	
	@Test
	public void testQuestion() throws RecognitionException, IOException  {
		String str= getQuestionString();
		GrammarParser parser= AstTest.getParser(str);
		Question actual=parser.question().result;
		Question expected=getQuestionObject();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAssigement() throws RecognitionException, IOException  {
		String str= getAssigementString();
		GrammarParser parser= AstTest.getParser(str);
		AssignmentStatement actual= (AssignmentStatement) parser.assignmentStatement().result;
		AssignmentStatement expected=getAssigmentStatementObject();
		assertEquals(expected, actual);
	}

	@Test
	public void testIf() throws RecognitionException  {
	
	}

	@Test
	public void testForm() throws RecognitionException  {
	
	}

	@Test
	public void testCompleteForm() throws RecognitionException  {
	}

}
