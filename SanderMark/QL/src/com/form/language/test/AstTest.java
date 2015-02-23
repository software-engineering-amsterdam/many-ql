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
import com.form.language.ast.expression.literal.BoolLiteral;
import com.form.language.ast.expression.literal.IntLiteral;
import com.form.language.ast.expression.literal.StringLiteral;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;

public class AstTest {

	public static GrammarParser getParser(String input) throws IOException {
		GrammarParser parser = null;
		CharStream charStream = new ANTLRInputStream(input);
		TokenStream tokenStream = new CommonTokenStream(new GrammarLexer(charStream));
		parser= new GrammarParser(tokenStream);
		return parser; 
	}		
	
	@Test
	public void testPrimaryInt() throws RecognitionException, IOException  {
		String str="1";
		GrammarParser parser= AstTest.getParser(str);
		Expression result = parser.expression().result;
		IntValue x = new IntValue(((IntValue)result.evaluate()).getValue());
		IntValue y = new IntValue(1);
		assertEquals(x.getValue(), y.getValue());
	}
	
    @Test
    public void testPrimaryString() throws RecognitionException, IOException  {
	  String str="abc";
	  GrammarParser parser= AstTest.getParser(str);
	  String result = ((StringValue)(parser.expression().result).evaluate()).getValue();
	  assertEquals(str, result);
	 }
	

}
