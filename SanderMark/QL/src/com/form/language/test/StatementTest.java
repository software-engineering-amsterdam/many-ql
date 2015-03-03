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
		String str= getQuestionString();
		GrammarParser parser= AstTest.getParser(str);
		Question actual=parser.question().result;
		Question expected=getQuestionObject();
		assertEquals(expected, actual);
	}

	@Test
	public void testIf() throws RecognitionException  {
		String str="if (hasSoldHouse) { " + getQuestionString1() + "}";
		QLParser parser=ASTNodes.getParser(str);

		IfBlock actual=parser.if_block().result;

		Question q=getQuestion1();
		List<Statement> list=new LinkedList<>();
		list.add(q);
		IfBlock expected=new IfBlock(new Ident("hasSoldHouse"),list);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testForm() throws RecognitionException  {
		String str="	form Box1HouseOwning { " + getQuestionString1() + "}";

		QLParser parser=ASTNodes.getParser(str);
		Form actual=parser.form().result;

		List<Statement> list=new LinkedList<>();
		list.add(getQuestion1());
		Form expected=new Form(new Ident("Box1HouseOwning"),list);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCompleteForm() throws RecognitionException  {
		String str=
				"form Box1HouseOwning { " +
						"hasSoldHouse: \"Did you sell a house in 2010?\" boolean " +
						"if (hasSoldHouse) { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"privateDebt: \"Private debts for the sold house:\" integer " +
						"valueResidue: \"Value residue:\" integer(sellingPrice - privateDebt) " +
						"} else { " +
						"sellingPrice: \"Price the house was sold for:\" integer " +
						"} }";

		QLParser parser=ASTNodes.getParser(str);
		Form tree1=parser.form().result;

		parser=ASTNodes.getParser( tree1.toString() );
		Form tree2=parser.form().result;

		Assert.assertTrue(tree1.equals(tree2));
	}

}
