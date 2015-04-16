package com.form.language.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

import com.form.language.GrammarLexer;
import com.form.language.GrammarParser;
import com.form.language.ast.values.BoolValue;
import com.form.language.ast.values.IntValue;
import com.form.language.ast.values.StringValue;
import com.form.language.memory.Context;

public class AstTest {

    public static GrammarParser getParser(String input) throws IOException {
	GrammarParser parser = null;
	CharStream charStream = new ANTLRInputStream(input);
	TokenStream tokenStream = new CommonTokenStream(new GrammarLexer(charStream));
	parser = new GrammarParser(tokenStream);
	return parser;
    }

    @Test
    public void testInt() throws RecognitionException, IOException {
	String str = "1";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = new IntValue(1).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testString() throws RecognitionException, IOException {
	String str = "\"abc\"";
	GrammarParser parser = AstTest.getParser(str);
	String actual = ((StringValue) (parser.expression().result).evaluate(new Context())).getValue();
	String exspected = new StringValue(str).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testBoolean() throws RecognitionException, IOException {
	String str = "true";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = new BoolValue(true).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testIntBrackets() throws RecognitionException, IOException {
	String str = "(1)";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = new IntValue((1)).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testStringBrackets() throws RecognitionException, IOException {
	String str = "\"(abc)\"";
	GrammarParser parser = AstTest.getParser(str);
	String actual = ((StringValue) (parser.expression().result).evaluate(new Context())).getValue();
	String exspected = new StringValue(str).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testBooleanBrackets() throws RecognitionException, IOException {
	String str = "(true)";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = new BoolValue((true)).getValue();
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionNegative() throws RecognitionException, IOException {
    String str = "-1";
    GrammarParser parser = AstTest.getParser(str);
    int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
    int exspected = new IntValue((-1)).getValue();
    assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionNot() throws RecognitionException, IOException {
	String str = "!true";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = !true;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionMultiplication() throws RecognitionException, IOException {
	String str = "2*2";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = 2 * 2;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionDivision() throws RecognitionException, IOException {
	String str = "6/3";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = 6 / 3;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionAddition() throws RecognitionException, IOException {
	String str = "1+1";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = 1 + 1;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionSubstraction() throws RecognitionException, IOException {
	String str = "5-1";
	GrammarParser parser = AstTest.getParser(str);
	int actual = ((IntValue) (parser.expression().result).evaluate(new Context())).getValue();
	int exspected = 5 - 1;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionEqual() throws RecognitionException, IOException {
	String str = "1==1";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = ((Integer) 1).equals((Integer) 1);
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionGreaterThan() throws RecognitionException, IOException {
	String str = "1>1";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = 1 > 1;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionGreaterThanOrEqual() throws RecognitionException, IOException {
	String str = "1>=1";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = 1 >= 1;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionLessThan() throws RecognitionException, IOException {
	String str = "1<1";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = 1 < 1;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionLessThanOrEqual() throws RecognitionException, IOException {
	String str = "5<=6";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = 5 <= 6;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionAnd() throws RecognitionException, IOException {
	String str = "true && true";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = true && true;
	assertEquals(exspected, actual);
    }

    @Test
    public void testExpressionOr() throws RecognitionException, IOException {
	String str = "true || true";
	GrammarParser parser = AstTest.getParser(str);
	boolean actual = ((BoolValue) (parser.expression().result).evaluate(new Context())).getValue();
	boolean exspected = true;
	assertEquals(exspected, actual);
    }

}
