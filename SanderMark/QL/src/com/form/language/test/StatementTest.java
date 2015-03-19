package com.form.language.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.RecognitionException;
import org.junit.Test;

import com.form.language.GrammarParser;
import com.form.language.ast.Form;
import com.form.language.ast.expression.Expression;
import com.form.language.ast.statement.IfStatement;
import com.form.language.ast.statement.Question;
import com.form.language.ast.statement.Statement;
import com.form.language.ast.type.BoolType;

public class StatementTest {

    private String getQuestionString() {
	return "hasSoldHouse: \"Did you sell a house in 2010?\" boolean";
    }

    private String getIfString() {
	return "if hasSoldHouse == true && hasBoughtHouse == true then question" + "\"Test?\""
		+ "hasTest : Boolean end";
    }

    private String getFormString() {
	return "form formExample {" + getQuestionString() + "}";
    }

    private Question getQuestionObject() {
	return new Question("\"Did you sell a house in 2010?\"", "hasHouseSold", new BoolType(), null);
    }

    private IfStatement getIfStatementObject() throws IOException {
	GrammarParser parser = AstTest.getParser("hasSoldHouse == true && hasBoughtHouse == true");
	Expression expression = parser.expression().result;
	List<Statement> statements = new ArrayList<Statement>();
	statements.add(new Question("\"Test?\"", "hasTest", new BoolType(), null));
	return new IfStatement(expression, statements, null);
    }

    private Form getFormObject() throws IOException {
	List<Statement> statements = new ArrayList<Statement>();
	statements.add(getQuestionObject());
	return new Form("formExample", statements);
    }

    @Test
    public void testIf() throws IOException {
	String str = getIfString();
	GrammarParser parser = AstTest.getParser(str);
	IfStatement actual = (IfStatement) parser.ifStatement().result;
	IfStatement expected = getIfStatementObject();
	assertEquals(expected, actual);
    }

    @Test
    public void testQuestion() throws RecognitionException, IOException {
	String str = getQuestionString();
	GrammarParser parser = AstTest.getParser(str);
	Question actual = parser.question().result;
	Question expected = getQuestionObject();
	assertEquals(expected, actual);
    }

    @Test
    public void testForm() throws RecognitionException, IOException {
	String str = getFormString();
	GrammarParser parser = AstTest.getParser(str);
	Form actual = parser.form().result;
	Form expected = getFormObject();
	assertEquals(expected, actual);
    }
}
