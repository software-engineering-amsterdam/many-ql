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
import com.form.language.ast.values.IntValue;
import com.form.language.memory.RuntimeMemory;

public class StatementTest {
	
	public static GrammarParser getParser(String input) throws IOException {
		GrammarParser parser = null;
		CharStream charStream = new ANTLRInputStream(input);
		TokenStream tokenStream = new CommonTokenStream(new GrammarLexer(charStream));
		parser= new GrammarParser(tokenStream);
		return parser; 
	}	
		
	@Test
	public void testForm() throws RecognitionException, IOException  {
		String str="";
		GrammarParser parser= AstTest.getParser(str);
		int actual = ((IntValue)(parser.expression().result).evaluate(new RuntimeMemory())).getValue();
		int exspected = new IntValue(1).getValue();
		assertEquals(exspected,actual);
	}
	
	@Test
	public void testFormWithQuestion() throws RecognitionException, IOException  {
		String str="1";
		GrammarParser parser= AstTest.getParser(str);
		int actual = ((IntValue)(parser.expression().result).evaluate(new RuntimeMemory())).getValue();
		int exspected = new IntValue(1).getValue();
		assertEquals(exspected,actual);
	}
	
	@Test
	public void testFormWithIf() throws RecognitionException, IOException  {
		String str="1";
		GrammarParser parser= AstTest.getParser(str);
		int actual = ((IntValue)(parser.expression().result).evaluate(new RuntimeMemory())).getValue();
		int exspected = new IntValue(1).getValue();
		assertEquals(exspected,actual);
	}
	
	@Test
	public void testFormWithStatement() throws RecognitionException, IOException  {
		String str="1";
		GrammarParser parser= AstTest.getParser(str);
		int actual = ((IntValue)(parser.expression().result).evaluate(new RuntimeMemory())).getValue();
		int exspected = new IntValue(1).getValue();
		assertEquals(exspected,actual);
	}

}
