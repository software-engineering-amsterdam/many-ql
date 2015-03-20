package test.ql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Test;

import ql.ast.QLNode;
import ql.parser.Parser;
import ql.parser.QLLexer;

public class TestParser {
	Parser formParser = new Parser();
	
	@Test
	public void testZeroToken() {
		Reader myReader = new StringReader("");
		QLLexer lexer = new QLLexer(myReader);
		
		assertEquals("Return 0 when nothing is done.", 0, lexer.getToken());
	}
	
	@Test
	public void testParsableString() {
		String myExpression = "5 + 5";
		
		QLNode result = Parser.parse(myExpression);
		assertNotNull(result);
		
		assertEquals("5 + 5", result.toString());
	}

	@Test
	public void testParsableForm() {
		String myForm = 
				"form taxOfficeExample {"
				+ "hasSoldHouse : boolean {"
				+ "\"Did you sell a house in 2010?\""
				+ "}"
				+ "}";

		QLNode result = Parser.parse(myForm);
		assertNotNull(result);
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, boolean, "
				+ "\"Did you sell a house in 2010?\")))", result.toString());
	}
	
	@Test
	public void testParsableAssignedForm() {
		String myForm =
				"form newForm { houseValue : money { \"what is your house?\" assign(105050*238482/2342)} }";

		QLNode result = Parser.parse(myForm);
		assertNotNull(result);
		
		assertEquals("Form(newForm, Block(ComputedQuestion(houseValue, money, "
				+ "\"what is your house?\", 105050 * 238482 / 2342)))", result.toString());
	}
	
	@Test
	public void testConditionalForm() {
		String myForm = 
				"form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"if(5 == 5) {"
				+ 		"houseValue : money {"
				+ 			"\"Lol I dont care\""
				+ 		"}"
				+ 	"}"
				+ "}";
		
		QLNode result = Parser.parse(myForm);
		assertNotNull(result);
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, boolean, "
				+ "\"Did you sell a house in 2010?\"), IfThen(5 == 5, "
				+ "Block(Question(houseValue, money, \"Lol I dont care\")))))", result.toString());
	}
	
	@Test
	public void testParsableComputerQuestion() {
		String myForm = 
				  "form taxOfficeExample {"
				+ 	"hasSoldHouse : boolean {"
				+ 		"\"Did you sell a house in 2010?\""
				+ 	"}"
				+ 	"houseValue : money {"
				+ 		"\"Your house is worth:\""
				+ 		"assign(5000.0)"
				+ 	"}"
				+ "}";

		QLNode result = Parser.parse(myForm);
		assertNotNull(result);
		
		assertEquals("Form(taxOfficeExample, Block(Question(hasSoldHouse, boolean, "
				+ "\"Did you sell a house in 2010?\"), ComputedQuestion(houseValue, "
				+ "money, \"Your house is worth:\", 5000.0)))", result.toString());
	}	
}