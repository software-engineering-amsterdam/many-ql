package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
//import org.nlamah.QL.Conditional.ConditionalBlock;
//import org.nlamah.QL.Conditional.ElseIfThenNode;
//import org.nlamah.QL.Conditional.ElseThenNode;
//import org.nlamah.QL.Conditional.IfThenNode;
//import org.nlamah.QL.Expression.Expression;
//import org.nlamah.QL.Expression.LogicalExpression;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.BooleanQuestion;


/**
 * Unit test for simple App.
 */
public class QLTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QLTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( QLTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
	
	String parsedString;
	String referenceString;
	
	String produceParseStringFromSource(String source)
	{
		ANTLRInputStream input = new ANTLRInputStream(source);
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.form();
		
		return tree.toStringTree(parser);
	}
	
	String produceParseStringFromSourceFile(String filename)
	{
		ANTLRInputStream input = null;
		
		try {
			InputStream inputStream = QLInterpreter.class.getResourceAsStream(filename + ".ql");
			String qlSourceCode = IOUtils.toString(inputStream, "UTF-8");
			input = new ANTLRInputStream(qlSourceCode);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		QLLexer lexer = new QLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLParser parser = new QLParser(tokens);
		ParseTree tree = parser.form();
		
		return tree.toStringTree(parser);
		
	}
	
	public void testEmptyForm() {	

		parsedString = produceParseStringFromSourceFile("emptyform");
		
		Form form = new Form("test", null);
		
		referenceString = form.toParseTreeString();
		System.out.println("empty from:" + referenceString + "||" + parsedString);
	    assertEquals( parsedString, referenceString );  
	    
	}
	
	public void testOneQuestion() {
	
		parsedString = produceParseStringFromSourceFile("onequestion");
		System.out.println(parsedString);
		
		BooleanQuestion question = new BooleanQuestion("hasSoldHouse", "boolean", "Did you sell a house in 2010?");
		ArrayList<FormElement> questions = new ArrayList<FormElement>(1);
		questions.add(0, question);
		
		Form form = new Form("test", questions);
		
		referenceString = form.toParseTreeString();
		System.out.println("one question:" + referenceString + "||" + parsedString);
	    assertEquals( parsedString, referenceString );
	}
	
	 public void testTwoQuestions() {

 		parsedString = produceParseStringFromSourceFile("twoquestions");
 		System.out.println(parsedString);

 		BooleanQuestion question1 = new BooleanQuestion("hasSoldHouse", "boolean", "Did you sell a house in 2010?");
 		BooleanQuestion question2 = new BooleanQuestion("hasMaintLoan", "boolean", "Did you enter a loan for maintenance/reconstruction?");


 		ArrayList<FormElement> questions = new ArrayList<FormElement>(2);
 		questions.add(0, question1);
 		questions.add(1, question2);

 		Form form = new Form("test", questions);

 		referenceString = form.toParseTreeString();
 		System.out.println("two questions:" + referenceString + "||" + parsedString);
 	    assertEquals( parsedString, referenceString );
 	}
//
// 	public void testSimpleIfStatement() {
// 		parsedString = produceParseStringFromSourceFile("simpleifstatement");
//
// 		IfThenNode ifThenNode = new IfThenNode(new LogicalExpression(new Expression("logical_expression", "statement")), null);
// 		ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenNode, null, null);
// 		ArrayList<FormElement> conditionalBlocks = new ArrayList<FormElement>(1);
// 		conditionalBlocks.add(0, conditionalBlock);
//
// 		Form form = new Form("test", conditionalBlocks);
//
// 		referenceString = form.toParseTreeString();
// 		System.out.println("simple if statement:" + referenceString + "||" + parsedString);
// 	    assertEquals( parsedString, referenceString );
// 	}
//
// 	public void testSimpleIfElseStatement() {
// 		parsedString = produceParseStringFromSourceFile("simpleifelsestatement");
//
// 		IfThenNode ifThenNode = new IfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ElseThenNode elseThenNode = new ElseThenNode(null);
// 		ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenNode, null, elseThenNode);
// 		ArrayList<FormElement> conditionalBlocks = new ArrayList<FormElement>(1);
// 		conditionalBlocks.add(0, conditionalBlock);
//
// 		Form form = new Form("test", conditionalBlocks);
//
// 		referenceString = form.toParseTreeString();
// 		System.out.println("simple ifelse statement:" + referenceString + "||" + parsedString);
// 	    assertEquals( parsedString, referenceString );
// 	}
//
// 	public void testSimpleIfElsifElseStatement() {
// 		parsedString = produceParseStringFromSourceFile("simpleifelsifelsestatement");
//
// 		IfThenNode ifThenNode = new IfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ElseIfThenNode elseIfThen1 = new ElseIfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ElseIfThenNode elseIfThen2 = new ElseIfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ArrayList<ElseIfThenNode> elseIfThenNodes = new ArrayList<ElseIfThenNode>(2);
// 		elseIfThenNodes.add(0, elseIfThen1);
// 		elseIfThenNodes.add(1, elseIfThen2);
//
//
// 		ElseThenNode elseThenNode = new ElseThenNode(null);
// 		ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenNode, elseIfThenNodes, elseThenNode);
// 		ArrayList<FormElement> conditionalBlocks = new ArrayList<FormElement>(1);
// 		conditionalBlocks.add(0, conditionalBlock);
//
// 		Form form = new Form("test", conditionalBlocks);
//
// 		referenceString = form.toParseTreeString();
// 		System.out.println("simple ifelseifelse statement:" + referenceString + "||\n\t\t\t" + parsedString);
// 	    assertEquals( parsedString, referenceString );
// 	}
//
// 	public void testNestedIfElsifElseStatement() {
// 		parsedString = produceParseStringFromSourceFile("nestedifelsestatement");
// 		IfThenNode ifThenNode = new IfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
//
// 		IfThenNode nestedIfThenNode = new IfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ElseThenNode nestedElseThenNode = new ElseThenNode(null);
// 		ConditionalBlock nestedConditionBlock = new ConditionalBlock(nestedIfThenNode, null, nestedElseThenNode);
// 		ArrayList<FormElement>nestedConditionalBlocks = new ArrayList<FormElement>(1);
// 		nestedConditionalBlocks.add(0, nestedConditionBlock);
//
// 		ElseIfThenNode elseIfThen1 = new ElseIfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), nestedConditionalBlocks);
// 		ElseIfThenNode elseIfThen2 = new ElseIfThenNode(new LogicalExpression(new Expression("logical_expression","statement")), null);
// 		ArrayList<ElseIfThenNode> elseIfThenNodes = new ArrayList<ElseIfThenNode>(2);
// 		elseIfThenNodes.add(0, elseIfThen1);
// 		elseIfThenNodes.add(1, elseIfThen2);
//
//
// 		ElseThenNode elseThenNode = new ElseThenNode(null);
// 		ConditionalBlock conditionalBlock = new ConditionalBlock(ifThenNode, elseIfThenNodes, elseThenNode);
// 		ArrayList<FormElement> conditionalBlocks = new ArrayList<FormElement>(1);
// 		conditionalBlocks.add(0, conditionalBlock);
//
// 		Form form = new Form("test", conditionalBlocks);
//
// 		referenceString = form.toParseTreeString();
// 		System.out.println("nested ifelseifelse statement:" + referenceString + "||\n\t\t\t      " + parsedString);
// 	    assertEquals( parsedString, referenceString );
// 	}
}
